package com.tencent.qqmini.miniapp.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.miniapp.R.string;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import com.tencent.smtt.sdk.QbSdk;
import java.util.ArrayList;

public class EmbeddedHelper
{
  public static final String EVENT_INSERT_LIVE_PLAYER = "insertLivePlayer";
  public static final String EVENT_INSERT_LIVE_PUSHER = "insertLivePusher";
  public static final String EVENT_INSERT_VIDEO_PLAYER = "insertVideoPlayer";
  public static final String SP_NAME = "update_embedded_status";
  public static final String TAG = "EmbeddedHelper";
  private static ArrayList<String> appIDWhiteList = null;
  private static final boolean enableEmbeddedLiveConfig;
  private static final boolean enableEmbeddedVideoConfiog;
  private static boolean enableUpdateForEmbeddedWidget;
  private static volatile Boolean isRunning;
  private static String mCurWhiteListConfig = null;
  
  static
  {
    boolean bool2 = false;
    isRunning = Boolean.valueOf(false);
    if (WnsConfig.getConfig("qqminiapp", "enableUpdateForEmbeddedWidget", 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    enableUpdateForEmbeddedWidget = bool1;
    if (WnsConfig.getConfig("qqminiapp", "enable_embedded_video", 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    enableEmbeddedVideoConfiog = bool1;
    boolean bool1 = bool2;
    if (WnsConfig.getConfig("qqminiapp", "enable_embedded_live", 1) == 1) {
      bool1 = true;
    }
    enableEmbeddedLiveConfig = bool1;
  }
  
  public static void checkEmbeddedWidgetSupport(RequestEvent paramRequestEvent, String paramString, Activity paramActivity)
  {
    ThreadManager.getSubThreadHandler().post(new EmbeddedHelper.1(paramRequestEvent, paramString, paramActivity));
  }
  
  private static boolean doRealCheck(RequestEvent paramRequestEvent, String paramString, Activity paramActivity)
  {
    getAppWhiteList();
    boolean bool = isIsRunning().booleanValue();
    Boolean localBoolean = Boolean.valueOf(false);
    if (bool)
    {
      QMLog.d("EmbeddedHelper", "checkEmbeddedWidgetSupport isRunning, return.");
      return false;
    }
    setIsRunning(Boolean.valueOf(true));
    if (paramRequestEvent == null)
    {
      QMLog.d("EmbeddedHelper", "checkEmbeddedWidgetSupport req nll, return.");
      setIsRunning(localBoolean);
      return false;
    }
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkEmbeddedWidgetSupport event : ");
      ((StringBuilder)localObject).append(paramRequestEvent.event);
      QMLog.d("EmbeddedHelper", ((StringBuilder)localObject).toString());
      if (!isEmbeddedWidgetApi(paramRequestEvent))
      {
        QMLog.d("EmbeddedHelper", "checkEmbeddedWidgetSupport isEmbeddedWidgetApi false, return.");
        setIsRunning(localBoolean);
        return false;
      }
      if (!enableUpdateForEmbeddedWidget)
      {
        QMLog.d("EmbeddedHelper", "checkEmbeddedWidgetSupport enableUpdateForEmbeddedWidget false, return.");
        setIsRunning(localBoolean);
        return false;
      }
      if (!appIDWhiteList.contains(paramString))
      {
        paramRequestEvent = new StringBuilder();
        paramRequestEvent.append("checkEmbeddedWidgetSupport appIDWhiteList false, appid is : ");
        paramRequestEvent.append(paramString);
        paramRequestEvent.append(", return.");
        QMLog.d("EmbeddedHelper", paramRequestEvent.toString());
        setIsRunning(localBoolean);
        return false;
      }
      paramRequestEvent = LoginManager.getInstance().getAccount();
      paramString = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion();
      localObject = getSp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramRequestEvent);
      if (((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0) == 1)
      {
        QMLog.d("EmbeddedHelper", "checkEmbeddedWidgetSupport sp false, return.");
        setIsRunning(localBoolean);
        return false;
      }
      if ((!enableEmbeddedVideoConfiog) && (!enableEmbeddedLiveConfig))
      {
        QMLog.d("EmbeddedHelper", "checkEmbeddedWidgetSupport widget false, return.");
        setIsRunning(localBoolean);
        return false;
      }
      int i = QbSdk.getTbsVersion(paramActivity);
      int j = QbSdk.getTmpDirTbsVersion(paramActivity);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tbsVersion : ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("; tmpDirTbsVersion : ");
      ((StringBuilder)localObject).append(j);
      QMLog.d("EmbeddedHelper", ((StringBuilder)localObject).toString());
      if ((i <= 0) && (j <= 0))
      {
        AppBrandTask.runTaskOnUiThread(new EmbeddedHelper.2(paramActivity, paramString, paramRequestEvent));
        setTbsListener(paramActivity);
        return true;
      }
      QMLog.d("EmbeddedHelper", "checkEmbeddedWidgetSupport tbsVersion || tmpDirTbsVersion > 0, return.");
      setIsRunning(localBoolean);
      return false;
    }
    setIsRunning(localBoolean);
    return false;
  }
  
  private static void downloadSuccess(Activity paramActivity)
  {
    AppBrandTask.runTaskOnUiThread(new EmbeddedHelper.6(paramActivity));
  }
  
  private static ArrayList<String> getAppWhiteList()
  {
    if (appIDWhiteList == null)
    {
      String str1 = WnsConfig.getConfig("qqminiapp", "enableUpdateEmbeddedAppList", "1108711239;1108735743;1110465521");
      if ((str1 != null) && (!str1.equals(mCurWhiteListConfig)))
      {
        appIDWhiteList = new ArrayList();
        try
        {
          String[] arrayOfString = str1.split(";");
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            String str2 = arrayOfString[i];
            if (!TextUtils.isEmpty(str2)) {
              appIDWhiteList.add(str2);
            }
            i += 1;
          }
          return appIDWhiteList;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          mCurWhiteListConfig = str1;
        }
      }
    }
  }
  
  private static SharedPreferences getSp()
  {
    return AppLoaderFactory.g().getContext().getSharedPreferences("update_embedded_status", 4);
  }
  
  private static boolean isEmbeddedWidgetApi(RequestEvent paramRequestEvent)
  {
    return ("insertVideoPlayer".equals(paramRequestEvent.event)) || ("insertLivePlayer".equals(paramRequestEvent.event)) || ("insertLivePusher".equals(paramRequestEvent.event));
  }
  
  public static Boolean isIsRunning()
  {
    return isRunning;
  }
  
  private static void reportEmbeddedStatus(int paramInt, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new EmbeddedHelper.9(paramInt, paramString));
  }
  
  public static void setIsRunning(Boolean paramBoolean)
  {
    isRunning = paramBoolean;
  }
  
  private static void setTbsListener(Activity paramActivity)
  {
    QbSdk.setTbsListener(new EmbeddedHelper.3(paramActivity));
  }
  
  private static void showRestartDialog(Activity paramActivity)
  {
    DialogUtil.createCustomDialog(paramActivity, 230, "升级成功", "小程序内核升级完成，重启手机QQ立即生效", R.string.mini_sdk_cancel, R.string.mini_sdk_ok, new EmbeddedHelper.7(), new EmbeddedHelper.8()).show();
  }
  
  private static void showUpdateDialog(Activity paramActivity, String paramString1, String paramString2)
  {
    DialogUtil.createCustomDialog(paramActivity, 230, "提示", "建议您升级小程序内核提升视频，直播等观看体验", R.string.mini_sdk_cancel, R.string.mini_sdk_ok, new EmbeddedHelper.4(paramString1, paramString2, paramActivity), new EmbeddedHelper.5(paramString1, paramString2)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.EmbeddedHelper
 * JD-Core Version:    0.7.0.1
 */