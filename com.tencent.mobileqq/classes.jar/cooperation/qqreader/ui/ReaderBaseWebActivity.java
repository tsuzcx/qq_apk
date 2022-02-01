package cooperation.qqreader.ui;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.Window;
import bmpi;
import bmpn;
import bmpr;
import bmqg;
import bmqw;
import bmrb;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqreader.host.ChannelIdHelper;
import cooperation.qqreader.utils.QRDebugEnvUrlUtils;

public class ReaderBaseWebActivity
  extends QQBrowserActivity
{
  private static boolean jdField_a_of_type_Boolean;
  private bmpr jdField_a_of_type_Bmpr;
  
  private void a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      bmrb.a(this);
      ChannelIdHelper.initChannelId(getIntent());
      if ((!bmrb.jdField_a_of_type_Boolean) && (!"Meizu_M040".equals(Build.MANUFACTURER + "_" + Build.MODEL)))
      {
        bmqw.d("WebLog_QQBrowserActivity", "HardAcc true");
        getWindow().addFlags(16777216);
      }
      if (QRDebugEnvUrlUtils.isDebugEnv()) {
        QRDebugEnvUrlUtils.initTestEnv(this);
      }
      bmrb.a(this);
    }
  }
  
  @Nullable
  public bmpr a(TouchWebView paramTouchWebView)
  {
    if ((this.jdField_a_of_type_Bmpr == null) && (paramTouchWebView != null) && (paramTouchWebView.getPluginEngine() != null))
    {
      paramTouchWebView = paramTouchWebView.getPluginEngine();
      if (paramTouchWebView != null)
      {
        paramTouchWebView = paramTouchWebView.a(207, true);
        if ((paramTouchWebView instanceof bmpr)) {
          this.jdField_a_of_type_Bmpr = ((bmpr)paramTouchWebView);
        }
      }
    }
    return this.jdField_a_of_type_Bmpr;
  }
  
  protected void a(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      bmqw.a("WebLog_QQBrowserActivity", "[putReaderExtra] intent = null");
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
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    g();
    a();
    if (!bmpi.a())
    {
      paramBundle = new Intent(this, ForceUserUpdateActivity.class);
      paramBundle.putExtra("origin_intent", getIntent());
      paramBundle.putExtra("key_click_leba_start_time", getIntent().getLongExtra("key_click_leba_start_time", 0L));
      startActivity(paramBundle);
      finish();
      return true;
    }
    super.doOnCreate(paramBundle);
    new bmpn(this).a();
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
    bmqg.a(this, true);
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderBaseWebActivity
 * JD-Core Version:    0.7.0.1
 */