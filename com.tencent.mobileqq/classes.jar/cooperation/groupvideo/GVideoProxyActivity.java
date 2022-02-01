package cooperation.groupvideo;

import Override;
import amtj;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import bhht;
import bkih;
import bkii;
import bkkq;
import bkkz;
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
    paramActivity = new bhht(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299076));
    paramActivity.a(amtj.a(2131704559));
    paramActivity.setOnDismissListener(new bkih());
    return paramActivity;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, String paramString2, int paramInt)
  {
    bkkz localbkkz = new bkkz(1);
    localbkkz.jdField_b_of_type_JavaLangString = "group_video_plugin.apk";
    localbkkz.d = PluginInfo.k;
    localbkkz.jdField_a_of_type_JavaLangString = paramString2;
    localbkkz.e = paramString1;
    localbkkz.jdField_a_of_type_JavaLangClass = GVideoProxyActivity.class;
    paramString1 = paramIntent;
    if (paramIntent == null) {
      paramString1 = new Intent();
    }
    localbkkz.jdField_a_of_type_AndroidContentIntent = paramString1;
    localbkkz.jdField_a_of_type_AndroidAppDialog = paramDialog;
    localbkkz.jdField_a_of_type_AndroidContentIntent.putExtra("userQqResources", 2);
    localbkkz.jdField_a_of_type_AndroidContentIntent.putExtra("param_plugin_gesturelock", true);
    localbkkz.jdField_b_of_type_Int = paramInt;
    localbkkz.c = 20000;
    localbkkz.f = null;
    bkkq.a(paramActivity, localbkkz);
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
      this.a = new bkii(this);
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