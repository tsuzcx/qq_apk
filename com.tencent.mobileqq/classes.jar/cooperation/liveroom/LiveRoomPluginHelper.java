package cooperation.liveroom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaAccessHelper;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaSoLoaderManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.commons.IReportDelegate;
import mqq.app.AppRuntime;

public class LiveRoomPluginHelper
{
  private static final String TAG = "LiveRoomPluginHelper";
  private static boolean violaSoLoaded = false;
  
  public static void backToReadInJoy(Context paramContext)
  {
    ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchReadInJoyTab(paramContext, 11);
  }
  
  public static LiveRoomWebViewBuilder createWebView(Activity paramActivity, Intent paramIntent)
  {
    LiveRoomInterfaceProxy localLiveRoomInterfaceProxy = LiveRoomHelper.getLiveRoomInterface();
    if (localLiveRoomInterfaceProxy != null)
    {
      paramIntent.putExtra("window_no_title", false);
      paramIntent.putExtra("webview_hide_progress", true);
      paramActivity = new LiveRoomWebViewBuilder(paramActivity, paramActivity, paramIntent, localLiveRoomInterfaceProxy);
      new WebViewDirector(paramActivity).a(null, localLiveRoomInterfaceProxy, paramIntent);
      return paramActivity;
    }
    QLog.e("LiveRoomPluginHelper", 2, "createWebView: app should be AppInterface");
    return null;
  }
  
  public static Intent getMiniAIOIntent(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1)))
    {
      Intent localIntent = new Intent();
      localIntent.setClass(paramContext, SplashActivity.class);
      localIntent.setFlags(67108864);
      localIntent.putExtra("tab_index", FrameControllerUtil.a);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("banner_activityName", "com.tencent.gamecontent.livesdkqqplugin.plugins.QQLiveRoomPluginActivity");
      localIntent.putExtra("banner_businessCategory", "LiveRoom");
      localIntent.putExtra("banner_wording", paramString2);
      localIntent.putExtra("banner_iconIdx", 8);
      localIntent.putExtra("banner_plguinType", 1);
      localIntent.putExtra("banner_pluginId", "LiveRoomPlugin.apk");
      localIntent.putExtra("banner_pluginName", "直播SDK");
      localIntent.putExtra("banner_pluginProxyActivityName", "cooperation.liveroom.LiveRoomProxyActivity");
      localIntent.putExtra("banner_pluginIntent", LiveRoomProxyActivity.getPluginIntent(paramString1).putExtra("back_to_readinjoy", true));
      return localIntent;
    }
    return null;
  }
  
  public static void initViola(AppRuntime paramAppRuntime, String paramString, IReportDelegate paramIReportDelegate, LiveRoomPluginHelper.InitViolaListener paramInitViolaListener)
  {
    if (!violaSoLoaded)
    {
      violaSoLoaded = true;
      ((IViolaSoLoaderManager)QRoute.api(IViolaSoLoaderManager.class)).loadLibrary("LiveRoomPluginHelper", new LiveRoomPluginHelper.1(paramInitViolaListener, paramAppRuntime, paramString, paramIReportDelegate));
      return;
    }
    initViolaSDKEngine(paramAppRuntime, paramString, paramIReportDelegate, paramInitViolaListener);
  }
  
  private static void initViolaSDKEngine(AppRuntime paramAppRuntime, String paramString, IReportDelegate paramIReportDelegate, LiveRoomPluginHelper.InitViolaListener paramInitViolaListener)
  {
    if ((paramInitViolaListener != null) && (paramAppRuntime != null)) {
      paramAppRuntime.runOnUiThread(new LiveRoomPluginHelper.2(paramInitViolaListener));
    }
  }
  
  public static void open(Activity paramActivity, Bundle paramBundle)
  {
    int i = paramBundle.getInt("type");
    String str = paramBundle.getString("title");
    paramBundle = paramBundle.getString("url");
    if ((i == 1) && (!TextUtils.isEmpty(paramBundle)))
    {
      LiveRoomProxyActivity.openWebView(paramActivity, paramBundle);
      return;
    }
    if ((i == 2) && (!TextUtils.isEmpty(paramBundle))) {
      ((IViolaAccessHelper)QRoute.api(IViolaAccessHelper.class)).startViolaPage(paramActivity, str, paramBundle, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomPluginHelper
 * JD-Core Version:    0.7.0.1
 */