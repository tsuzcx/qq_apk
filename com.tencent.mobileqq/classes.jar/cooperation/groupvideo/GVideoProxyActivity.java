package cooperation.groupvideo;

import Override;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import anzj;
import bjbs;
import bmek;
import bmel;
import bmgk;
import bmgt;
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
    paramActivity = new bjbs(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299011));
    paramActivity.a(anzj.a(2131704329));
    paramActivity.setOnDismissListener(new bmek());
    return paramActivity;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, String paramString2, int paramInt)
  {
    bmgt localbmgt = new bmgt(1);
    localbmgt.jdField_b_of_type_JavaLangString = "group_video_plugin.apk";
    localbmgt.d = PluginInfo.k;
    localbmgt.jdField_a_of_type_JavaLangString = paramString2;
    localbmgt.e = paramString1;
    localbmgt.jdField_a_of_type_JavaLangClass = GVideoProxyActivity.class;
    paramString1 = paramIntent;
    if (paramIntent == null) {
      paramString1 = new Intent();
    }
    localbmgt.jdField_a_of_type_AndroidContentIntent = paramString1;
    localbmgt.jdField_a_of_type_AndroidAppDialog = paramDialog;
    localbmgt.jdField_a_of_type_AndroidContentIntent.putExtra("userQqResources", 2);
    localbmgt.jdField_a_of_type_AndroidContentIntent.putExtra("param_plugin_gesturelock", true);
    localbmgt.jdField_b_of_type_Int = paramInt;
    localbmgt.c = 20000;
    localbmgt.f = null;
    bmgk.a(paramActivity, localbmgt);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
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
      this.a = new bmel(this);
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