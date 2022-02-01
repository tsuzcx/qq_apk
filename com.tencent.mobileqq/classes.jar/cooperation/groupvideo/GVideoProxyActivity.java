package cooperation.groupvideo;

import Override;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import anni;
import biau;
import bldh;
import bldi;
import blfh;
import blfq;
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
    paramActivity = new biau(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131298998));
    paramActivity.a(anni.a(2131704222));
    paramActivity.setOnDismissListener(new bldh());
    return paramActivity;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, String paramString2, int paramInt)
  {
    blfq localblfq = new blfq(1);
    localblfq.jdField_b_of_type_JavaLangString = "group_video_plugin.apk";
    localblfq.d = PluginInfo.k;
    localblfq.jdField_a_of_type_JavaLangString = paramString2;
    localblfq.e = paramString1;
    localblfq.jdField_a_of_type_JavaLangClass = GVideoProxyActivity.class;
    paramString1 = paramIntent;
    if (paramIntent == null) {
      paramString1 = new Intent();
    }
    localblfq.jdField_a_of_type_AndroidContentIntent = paramString1;
    localblfq.jdField_a_of_type_AndroidAppDialog = paramDialog;
    localblfq.jdField_a_of_type_AndroidContentIntent.putExtra("userQqResources", 2);
    localblfq.jdField_a_of_type_AndroidContentIntent.putExtra("param_plugin_gesturelock", true);
    localblfq.jdField_b_of_type_Int = paramInt;
    localblfq.c = 20000;
    localblfq.f = null;
    blfh.a(paramActivity, localblfq);
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
      this.a = new bldi(this);
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