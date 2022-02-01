package cooperation.groupvideo;

import Override;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import anvx;
import bisl;
import bltt;
import bltu;
import blvy;
import blwh;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.PluginInfo;

public class GVideoProxyActivity
  extends PluginProxyActivity
{
  public FlingHandler a;
  
  public static Dialog a(Activity paramActivity)
  {
    paramActivity = new bisl(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299080));
    paramActivity.a(anvx.a(2131704910));
    paramActivity.setOnDismissListener(new bltt());
    return paramActivity;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, String paramString2, int paramInt)
  {
    blwh localblwh = new blwh(1);
    localblwh.jdField_b_of_type_JavaLangString = "group_video_plugin.apk";
    localblwh.d = PluginInfo.k;
    localblwh.jdField_a_of_type_JavaLangString = paramString2;
    localblwh.e = paramString1;
    localblwh.jdField_a_of_type_JavaLangClass = GVideoProxyActivity.class;
    paramString1 = paramIntent;
    if (paramIntent == null) {
      paramString1 = new Intent();
    }
    localblwh.jdField_a_of_type_AndroidContentIntent = paramString1;
    localblwh.jdField_a_of_type_AndroidAppDialog = paramDialog;
    localblwh.jdField_a_of_type_AndroidContentIntent.putExtra("userQqResources", 2);
    localblwh.jdField_a_of_type_AndroidContentIntent.putExtra("param_plugin_gesturelock", true);
    localblwh.jdField_b_of_type_Int = paramInt;
    localblwh.c = 20000;
    localblwh.f = null;
    blvy.a(paramActivity, localblwh);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public String getPluginID()
  {
    return "group_video_plugin.apk";
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return GVideoProxyActivity.class;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((isWrapContent()) && (this.a != null)) {
      this.a.onConfigurationChanged(paramConfiguration);
    }
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (getIntent().getExtras() != null) {
      this.a = new bltu(this);
    }
    super.onCreate(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.groupvideo.GVideoProxyActivity
 * JD-Core Version:    0.7.0.1
 */