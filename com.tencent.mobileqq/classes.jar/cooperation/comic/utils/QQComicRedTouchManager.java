package cooperation.comic.utils;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class QQComicRedTouchManager
  extends Observable
  implements Manager
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  public QQComicRedTouchManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new QQComicRedTouchManager.1(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.redpoint.broadcast.push.av"));
  }
  
  public Map<String, RedAppInfo> a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {}
    do
    {
      do
      {
        return null;
        localObject = new Bundle();
        ((Bundle)localObject).putStringArrayList("pathList", paramArrayList);
        paramArrayList = QIPCClientHelper.getInstance().getClient().callServer("QQComicIPCModule", "getRedTouchInfo", (Bundle)localObject);
      } while ((paramArrayList == null) || (paramArrayList.code != 0) || (paramArrayList.data == null));
      paramArrayList = paramArrayList.data;
      paramArrayList.setClassLoader(RedAppInfo.class.getClassLoader());
      localObject = paramArrayList.getParcelableArrayList("redTouchInfoList");
    } while (localObject == null);
    paramArrayList = new HashMap();
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      RedAppInfo localRedAppInfo = (RedAppInfo)((Iterator)localObject).next();
      paramArrayList.put(localRedAppInfo.b(), localRedAppInfo);
    }
    return paramArrayList;
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString);
    QIPCClientHelper.getInstance().getClient().callServer("QQComicIPCModule", "reportRedTouchClick", localBundle);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("appId", paramInt);
    localObject = QIPCClientHelper.getInstance().getClient().callServer("QQComicIPCModule", "isLebaItemOpen", (Bundle)localObject);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((EIPCResult)localObject).code == 0)
      {
        bool1 = bool2;
        if (((EIPCResult)localObject).data != null) {
          bool1 = ((EIPCResult)localObject).data.getBoolean("isLebaItemOpen", false);
        }
      }
    }
    return bool1;
  }
  
  public void onDestroy()
  {
    super.deleteObservers();
    try
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.utils.QQComicRedTouchManager
 * JD-Core Version:    0.7.0.1
 */