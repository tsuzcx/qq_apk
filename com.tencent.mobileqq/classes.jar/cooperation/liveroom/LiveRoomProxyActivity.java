package cooperation.liveroom;

import Override;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import bifb;
import bifx;
import bjht;
import blvy;
import blwh;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.PluginInfo;

public class LiveRoomProxyActivity
  extends PluginProxyActivity
  implements bifb, bifx
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
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString;
      if (!paramString.contains("sonic_live=1"))
      {
        if (!paramString.contains("?")) {
          break label156;
        }
        paramString = paramString + "&sonic_live=1";
        localObject = paramString;
      }
    }
    localIntent.putExtra("url", (String)localObject);
    localIntent.putExtra("startOpenPageTime", clickTime);
    localIntent.putExtra("pluginFinished", System.currentTimeMillis());
    paramString = "";
    if ("com.tencent.mobileqq:tool".equals(bjht.r())) {
      paramString = LiveRoomHelper.getPluginVersionInTool();
    }
    for (;;)
    {
      localIntent.putExtra("version", paramString);
      localIntent.putExtra("param_plugin_gesturelock", true);
      localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      return localIntent;
      label156:
      paramString = paramString + "?sonic_live=1";
      break;
      localObject = LiveRoomHelper.getPluginInfoInQQ();
      if (localObject != null) {
        paramString = ((PluginInfo)localObject).mVersion;
      }
    }
  }
  
  private static void launchPlugin(Activity paramActivity, String paramString)
  {
    QLog.d("LiveRoomProxyActivity", 1, "launchPlugin");
    blwh localblwh = new blwh(1);
    localblwh.jdField_b_of_type_JavaLangString = "LiveRoomPlugin.apk";
    localblwh.d = "直播SDK";
    localblwh.e = "com.tencent.gamecontent.livesdkqqplugin.plugins.QQLiveRoomPluginActivity";
    localblwh.jdField_a_of_type_JavaLangClass = LiveRoomProxyActivity.class;
    localblwh.jdField_b_of_type_Int = 1011;
    localblwh.jdField_a_of_type_AndroidContentIntent = getPluginIntent(paramString);
    blvy.a(paramActivity, localblwh);
  }
  
  public static void open(Activity paramActivity, String paramString1, String paramString2)
  {
    clickTime = System.currentTimeMillis();
    boolean bool = "com.tencent.mobileqq:tool".equals(bjht.r());
    if (bool)
    {
      if (!LiveRoomHelper.getPluginInstalledInTool()) {}
    }
    else {
      while (LiveRoomHelper.isPluginInstalledInQQ())
      {
        if (QLog.isColorLevel()) {
          QLog.i("LiveRoomProxyActivity", 2, "plugin is installed, launching plugin");
        }
        launchPlugin(paramActivity, paramString1);
        return;
      }
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
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    LiveRoomHelper.startTime = NetConnInfoCenter.getServerTimeMillis();
    LiveRoomHelper.report("proxyActivity", "launch", "load:" + LiveRoomHelper.isSDKLoaded, 0L);
    LiveRoomHelper.isSDKLoaded = true;
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomProxyActivity
 * JD-Core Version:    0.7.0.1
 */