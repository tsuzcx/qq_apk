package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import bgls;
import bglu;
import bglx;
import bgun;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.minigame.api.ApiUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qqmini.sdk.core.widget.CapsuleButton;
import com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.log.QMLog;
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
    Object localObject1 = AppRuntimeLoaderManager.g().getCurrentRunTimeLoader();
    if (localObject1 == null) {}
    bgls localbgls;
    ShareState localShareState;
    Object localObject2;
    for (;;)
    {
      return;
      localbgls = ((bgun)localObject1).getRuntime();
      if (localbgls != null) {
        try
        {
          localObject1 = localbgls.a();
          if (localObject1 != null)
          {
            localShareState = localbgls.a();
            if (localShareState != null) {
              if (paramBoolean)
              {
                localObject3 = ApiUtil.wrapCallbackOk(localShareState.shareEvent, null);
                if (localObject3 != null)
                {
                  localObject3 = ((JSONObject)localObject3).toString();
                  ((bglu)localObject1).a(localShareState.shareCallbackId, (String)localObject3);
                  ThreadManager.getSubThreadHandler().post(new MiniSDKClientQIPCModule.1(this, localbgls));
                  return;
                }
              }
            }
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localObject2 = null;
            continue;
            localObject3 = "";
          }
          localObject3 = ApiUtil.wrapCallbackFail(localShareState.shareEvent, null);
          if (localObject3 == null) {}
        }
      }
    }
    for (Object localObject3 = ((JSONObject)localObject3).toString();; localObject3 = "")
    {
      localObject2.a(localShareState.shareCallbackId, (String)localObject3);
      ThreadManager.getSubThreadHandler().post(new MiniSDKClientQIPCModule.2(this, localbgls));
      return;
    }
  }
  
  private void onSyncUnReadCount(Bundle paramBundle)
  {
    int i;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("param_proc_badge_count");
      if (QMLog.isColorLevel()) {
        QMLog.d("MiniSDKClientQIPCModule", "count is " + i);
      }
      paramBundle = AppRuntimeLoaderManager.g().getCurrentRunTimeLoader();
      if (paramBundle != null) {
        break label53;
      }
    }
    label53:
    do
    {
      do
      {
        return;
        paramBundle = paramBundle.getRuntime();
      } while ((paramBundle == null) || (paramBundle.a() == null));
      paramBundle = paramBundle.a().a();
    } while (paramBundle == null);
    QMLog.e("MiniSDKClientQIPCModule", BaseApplicationImpl.getApplication().getQQProcessName() + " msg count = " + i);
    paramBundle.setUnReadCount(i, true);
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
      QMLog.e("MiniSDKClientQIPCModule", "register ipc module error.", localException);
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
    if (QMLog.isColorLevel()) {
      QMLog.d("MiniSDKClientQIPCModule", "onCall main server action=" + paramString);
    }
    if ("action_sync_unreadcount".equals(paramString)) {
      onSyncUnReadCount(paramBundle);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule
 * JD-Core Version:    0.7.0.1
 */