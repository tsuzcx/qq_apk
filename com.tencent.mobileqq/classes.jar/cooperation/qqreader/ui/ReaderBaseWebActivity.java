package cooperation.qqreader.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqreader.helper.GrayUpdateManager;
import cooperation.qqreader.helper.ReaderUrlConfigDataHelper;
import cooperation.qqreader.host.ChannelIdHelper;
import cooperation.qqreader.js.ReaderJsPlugin;
import cooperation.qqreader.shadow.ReaderPluginHelper;
import cooperation.qqreader.utils.Log;
import cooperation.qqreader.utils.QRDebugEnvUrlUtils;
import cooperation.qqreader.utils.Utility;

public class ReaderBaseWebActivity
  extends QQBrowserActivity
{
  private static boolean jdField_a_of_type_Boolean = false;
  private ReaderJsPlugin jdField_a_of_type_CooperationQqreaderJsReaderJsPlugin;
  
  private void a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      Utility.a(this);
      ChannelIdHelper.initChannelId(getIntent());
      if ((!Utility.jdField_a_of_type_Boolean) && (!"Meizu_M040".equals(Build.MANUFACTURER + "_" + Build.MODEL)))
      {
        Log.d("WebLog_QQBrowserActivity", "HardAcc true");
        getWindow().addFlags(16777216);
      }
      if (QRDebugEnvUrlUtils.isDebugEnv()) {
        QRDebugEnvUrlUtils.initTestEnv(this);
      }
      Utility.a(this);
    }
  }
  
  @Nullable
  public ReaderJsPlugin a(TouchWebView paramTouchWebView)
  {
    if ((this.jdField_a_of_type_CooperationQqreaderJsReaderJsPlugin == null) && (paramTouchWebView != null) && (paramTouchWebView.getPluginEngine() != null))
    {
      paramTouchWebView = paramTouchWebView.getPluginEngine();
      if (paramTouchWebView != null)
      {
        paramTouchWebView = paramTouchWebView.a(WebViewUtil.a("JSRoot"), true);
        if ((paramTouchWebView instanceof ReaderJsPlugin)) {
          this.jdField_a_of_type_CooperationQqreaderJsReaderJsPlugin = ((ReaderJsPlugin)paramTouchWebView);
        }
      }
    }
    return this.jdField_a_of_type_CooperationQqreaderJsReaderJsPlugin;
  }
  
  protected void a(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      Log.a("WebLog_QQBrowserActivity", "[putReaderExtra] intent = null");
      return;
    }
    paramIntent.putExtra("fragmentStyle", 4);
    paramIntent.putExtra("tabBarStyle", 2);
    paramIntent.putExtra("titleBarStyle", 3);
    paramIntent.putExtra("hide_more_button", true);
    paramIntent.putExtra("isScreenOrientationPortrait", true);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    disableSwipeLayout();
    a();
    if (!GrayUpdateManager.a())
    {
      paramBundle = new Intent(this, ForceUserUpdateActivity.class);
      paramBundle.putExtra("origin_intent", getIntent());
      paramBundle.putExtra("key_click_leba_start_time", getIntent().getLongExtra("key_click_leba_start_time", 0L));
      startActivity(paramBundle);
      finish();
      return true;
    }
    super.doOnCreate(paramBundle);
    new ReaderUrlConfigDataHelper(this).a();
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    a(getIntent());
    ReaderPluginHelper.a(this, true);
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderBaseWebActivity
 * JD-Core Version:    0.7.0.1
 */