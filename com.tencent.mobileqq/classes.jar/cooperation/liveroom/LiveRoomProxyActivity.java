package cooperation.liveroom;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.open.appcommon.Common;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginInfo;

public class LiveRoomProxyActivity
  extends PluginProxyActivity
  implements WebUiBaseInterface, WebViewPluginContainer
{
  public static final String PLUGIN_ACTIVITY_NAME = "com.tencent.gamecontent.livesdkqqplugin.plugins.QQLiveRoomPluginActivity";
  public static final String PROXY_ACTIVITY_NAME = "cooperation.liveroom.LiveRoomProxyActivity";
  private static final String TAG = "LiveRoomProxyActivity";
  private static long clickTime = -1L;
  
  public static Intent getPluginIntent(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    Object localObject1 = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = paramString;
      if (!paramString.contains("sonic_live=1"))
      {
        Object localObject2;
        if (paramString.contains("?"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString);
          localObject2 = "&sonic_live=1";
          paramString = (String)localObject1;
          localObject1 = localObject2;
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString);
          localObject1 = "?sonic_live=1";
          paramString = (String)localObject2;
        }
        paramString.append((String)localObject1);
        localObject1 = paramString.toString();
      }
    }
    localIntent.putExtra("url", (String)localObject1);
    localIntent.putExtra("startOpenPageTime", clickTime);
    localIntent.putExtra("pluginFinished", System.currentTimeMillis());
    if ("com.tencent.mobileqq:tool".equals(Common.x()))
    {
      paramString = LiveRoomHelper.getPluginVersionInTool();
    }
    else
    {
      paramString = LiveRoomHelper.getPluginInfoInQQ();
      if (paramString != null) {
        paramString = paramString.mVersion;
      } else {
        paramString = "";
      }
    }
    localIntent.putExtra("version", paramString);
    localIntent.putExtra("param_plugin_gesturelock", true);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    return localIntent;
  }
  
  private static void launchPlugin(Activity paramActivity, String paramString)
  {
    QLog.d("LiveRoomProxyActivity", 1, "launchPlugin");
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.d = "LiveRoomPlugin.apk";
    localPluginParams.g = "直播SDK";
    localPluginParams.h = "com.tencent.gamecontent.livesdkqqplugin.plugins.QQLiveRoomPluginActivity";
    localPluginParams.i = LiveRoomProxyActivity.class;
    localPluginParams.k = 1011;
    localPluginParams.j = getPluginIntent(paramString);
    IPluginManager.a(paramActivity, localPluginParams);
  }
  
  public static void open(Activity paramActivity, String paramString1, String paramString2)
  {
    clickTime = System.currentTimeMillis();
    boolean bool = "com.tencent.mobileqq:tool".equals(Common.x());
    if (bool ? LiveRoomHelper.getPluginInstalledInTool() : LiveRoomHelper.isPluginInstalledInQQ())
    {
      if (QLog.isColorLevel()) {
        QLog.i("LiveRoomProxyActivity", 2, "plugin is installed, launching plugin");
      }
      launchPlugin(paramActivity, paramString1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LiveRoomProxyActivity", 2, "plugin is NOT installed, opening loading page");
    }
    openWebView(paramActivity, paramString1);
    if (bool)
    {
      LiveRoomPluginInstaller.getInstance().installFromTool(paramActivity, paramString2);
      return;
    }
    LiveRoomPluginInstaller.getInstance().installFromQQ(null, paramString2);
  }
  
  public static void openWebView(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("url", paramString);
    paramActivity.startActivity(localIntent);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    LiveRoomHelper.startTime = NetConnInfoCenter.getServerTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("load:");
    localStringBuilder.append(LiveRoomHelper.isSDKLoaded);
    LiveRoomHelper.report("proxyActivity", "launch", localStringBuilder.toString(), 0L);
    LiveRoomHelper.isSDKLoaded = true;
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    LiveRoomHelper.cleanStaticParam();
    super.onDestroy();
  }
  
  public int pluginStartActivityForResult(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    startActivityForResult(paramIntent, paramByte);
    return 0;
  }
  
  public int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomProxyActivity
 * JD-Core Version:    0.7.0.1
 */