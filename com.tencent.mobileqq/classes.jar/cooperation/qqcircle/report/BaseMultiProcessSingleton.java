package cooperation.qqcircle.report;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qcircle.cooperation.config.QCircleSpUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public abstract class BaseMultiProcessSingleton
{
  private static final String ACTION_MULTI_PROCESS_SINGLETON = "action_multi_process_singleton";
  private static final String KEY_PROCESS_DATA_UPDATE = "key_process_data_update_";
  private static final String TAG = "BaseMultiProcessSingleton";
  private ConcurrentHashMap<String, Object> mDataMap = new ConcurrentHashMap();
  
  protected BaseMultiProcessSingleton()
  {
    initBroadcast();
  }
  
  private void initBroadcast()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_multi_process_singleton");
    BaseMultiProcessSingleton.MultiProcessBroadcastReceiver localMultiProcessBroadcastReceiver = new BaseMultiProcessSingleton.MultiProcessBroadcastReceiver(this, null);
    MobileQQ.sMobileQQ.registerReceiver(localMultiProcessBroadcastReceiver, localIntentFilter);
  }
  
  private void updateDataMap(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e("BaseMultiProcessSingleton", 1, "updateDataMap  bundle == null");
      return;
    }
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.mDataMap.put(str, paramBundle.get(str));
    }
  }
  
  private void updateSpData(Bundle paramBundle)
  {
    ThreadManager.getFileThreadHandler().post(new BaseMultiProcessSingleton.1(this, paramBundle));
  }
  
  protected Object getMultiProcessData(String paramString, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("BaseMultiProcessSingleton", 1, "getMultiProcessData  key == null");
      return paramObject;
    }
    Object localObject2 = this.mDataMap.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("key_process_data_update_");
      ((StringBuilder)localObject1).append(paramString);
      paramObject = QCircleSpUtil.a(((StringBuilder)localObject1).toString(), paramObject);
      localObject1 = paramObject;
      if (paramObject != null)
      {
        this.mDataMap.put(paramString, paramObject);
        localObject1 = paramObject;
      }
    }
    paramObject = new StringBuilder();
    paramObject.append("getMultiProcessData  key = ");
    paramObject.append(paramString);
    paramObject.append(" , object = ");
    paramObject.append(localObject1);
    QLog.i("BaseMultiProcessSingleton", 1, paramObject.toString());
    return localObject1;
  }
  
  protected void updateMultiProcessData(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e("BaseMultiProcessSingleton", 1, "updateMultiProcessData  bundle == null");
      return;
    }
    updateDataMap(paramBundle);
    Object localObject = new Intent();
    ((Intent)localObject).setAction("action_multi_process_singleton");
    ((Intent)localObject).putExtra("key_process_data_update_", paramBundle);
    MobileQQ.sMobileQQ.sendBroadcast((Intent)localObject);
    updateSpData(paramBundle);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateMultiProcessData  bundle = ");
    ((StringBuilder)localObject).append(paramBundle.toString());
    QLog.i("BaseMultiProcessSingleton", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.BaseMultiProcessSingleton
 * JD-Core Version:    0.7.0.1
 */