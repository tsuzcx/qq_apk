package cooperation.qqreader.ipc;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.redtouch.RedTouchUtils;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import cooperation.qqreader.QRBridgeUtil;
import cooperation.qqreader.QRPluginManager;
import cooperation.qqreader.utils.Log;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class ReaderIPCModule
  extends QIPCModule
{
  private static ReaderIPCModule a;
  
  public ReaderIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static ReaderIPCModule a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ReaderIPCModule("ReaderIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Log.e("ReaderIPCModule", "action = " + paramString);
    if (paramBundle == null)
    {
      Log.e("ReaderIPCModule", "Err params = null, action = " + paramString);
      return null;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface))
    {
      Log.e("ReaderIPCModule", "onRemoteInvoke cannot get QQAppInterface");
      return null;
    }
    localObject = (QQAppInterface)localObject;
    if ("getRedTouchInfo".equals(paramString))
    {
      paramString = (RedTouchManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_RED_TOUCH);
      localObject = paramBundle.getStringArrayList("pathList");
      if ((paramString != null) && (localObject != null))
      {
        paramBundle = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          BusinessInfoCheckUpdate.AppInfo localAppInfo = paramString.a((String)((Iterator)localObject).next());
          if (localAppInfo != null) {
            paramBundle.add(RedTouchUtils.a(localAppInfo));
          }
        }
        paramString = new Bundle();
        paramString.putParcelableArrayList("redTouchInfoList", paramBundle);
        return EIPCResult.createResult(0, paramString);
      }
    }
    else if ("getSingleRedTouchInfo".equals(paramString))
    {
      paramString = (RedTouchManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (paramString != null)
      {
        paramString = paramString.a(paramBundle.getString("path"));
        if (paramString != null)
        {
          paramString = RedTouchUtils.a(paramString);
          paramBundle = new Bundle();
          paramBundle.putParcelable("redTouchInfo", paramString);
          if ((paramString != null) && (paramString.b() == 1)) {
            Log.e("ReaderIPCModule", "path=" + paramString.b());
          }
          return EIPCResult.createResult(0, paramBundle);
        }
      }
    }
    else
    {
      if (!"reportRedTouchClick".equals(paramString)) {
        break label399;
      }
      paramString = (RedTouchManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (paramString != null)
      {
        paramBundle = paramBundle.getString("path");
        paramString.b(paramBundle);
      }
    }
    label399:
    do
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("service_type", 2);
        ((JSONObject)localObject).put("act_id", 1002);
        paramString.c(paramString.a(paramBundle), ((JSONObject)localObject).toString());
        return null;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
      if ("download_reader_plugin".equals(paramString))
      {
        QRPluginManager.a().a(((QQAppInterface)localObject).getApp());
        return EIPCResult.createResult(0, new Bundle());
      }
      if ("get_skey".equals(paramString))
      {
        paramString = new Bundle();
        paramString.putString("get_skey_value", QRBridgeUtil.getSKey((QQAppInterface)localObject));
        return EIPCResult.createResult(0, paramString);
      }
    } while (!"action_get_account".equals(paramString));
    paramString = new Bundle();
    paramString.putString("key_get_account", ((QQAppInterface)localObject).getAccount());
    return EIPCResult.createResult(0, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.ipc.ReaderIPCModule
 * JD-Core Version:    0.7.0.1
 */