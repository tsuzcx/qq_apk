package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import begw;
import begy;
import bepo;
import bepv;
import beru;
import besl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.minigame.api.ApiUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCClient;
import eipc.EIPCResult;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class MiniSDKClientQIPCModule
  extends QIPCModule
{
  public static final String KEY_MINI_REPORT_EVENT_ACTION_TYPE = "key_mini_report_event_action_type";
  public static final String KEY_MINI_REPORT_EVENT_RESERVES = "key_mini_report_event_reserves";
  public static final String KEY_MINI_REPORT_EVENT_RESERVES2 = "key_mini_report_event_reserves2";
  public static final String KEY_MINI_REPORT_EVENT_SUB_ACTION_TYPE = "key_mini_report_event_sub_action_type";
  public static final String MODULE_NAME = "mini_sdk_client_module";
  public static final String TAG = "MiniSDKClientQIPCModule";
  private String appId;
  private int verType;
  
  private MiniSDKClientQIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static MiniSDKClientQIPCModule getQIPCModule()
  {
    return MiniSDKClientQIPCModule.MiniSDKClientClass.access$100();
  }
  
  private void onShareCallback(boolean paramBoolean)
  {
    Object localObject = bepo.a().a();
    if (localObject == null) {}
    begw localbegw;
    begy localbegy;
    beru localberu;
    do
    {
      do
      {
        do
        {
          return;
          localbegw = ((bepv)localObject).getRuntime();
        } while (localbegw == null);
        localbegy = localbegw.a();
      } while (localbegy == null);
      localberu = localbegw.a();
    } while (localberu == null);
    if (paramBoolean)
    {
      localObject = ApiUtil.wrapCallbackOk(localberu.a, null);
      if (localObject != null) {}
      for (localObject = ((JSONObject)localObject).toString();; localObject = "")
      {
        localbegy.a(localberu.c, (String)localObject);
        ThreadManager.getSubThreadHandler().post(new MiniSDKClientQIPCModule.1(this, localbegw));
        return;
      }
    }
    localObject = ApiUtil.wrapCallbackFail(localberu.a, null);
    if (localObject != null) {}
    for (localObject = ((JSONObject)localObject).toString();; localObject = "")
    {
      localbegy.a(localberu.c, (String)localObject);
      ThreadManager.getSubThreadHandler().post(new MiniSDKClientQIPCModule.2(this, localbegw));
      return;
    }
  }
  
  public static void registerModule()
  {
    MiniSDKClientQIPCModule localMiniSDKClientQIPCModule = getQIPCModule();
    try
    {
      QIPCClientHelper.getInstance().register(localMiniSDKClientQIPCModule);
      return;
    }
    catch (Exception localException)
    {
      besl.d("MiniSDKClientQIPCModule", "register ipc module error.", localException);
    }
  }
  
  public static void unRegisterModule()
  {
    QIPCClientHelper.getInstance().getClient().unRegisterModule(getQIPCModule());
  }
  
  public void attachData(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.verType = paramInt;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (besl.a()) {
      besl.a("MiniSDKClientQIPCModule", "onCall main server action=" + paramString);
    }
    if ("action_sync_unreadcount".equals(paramString)) {}
    for (;;)
    {
      return null;
      if ("actionMiniShareSucCallback".equals(paramString)) {
        onShareCallback(true);
      } else if ("actionMiniShareFailCallback".equals(paramString)) {
        onShareCallback(false);
      } else if (("actionMiniDirectShareSucCallback".equals(paramString)) || ("actionMiniDirectShareFailCallback".equals(paramString)) || (!"actionMiniReportEvent".equals(paramString))) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule
 * JD-Core Version:    0.7.0.1
 */