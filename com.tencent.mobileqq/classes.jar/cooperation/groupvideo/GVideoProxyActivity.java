package cooperation.groupvideo;

import alpo;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import bepp;
import bill;
import bilm;
import bimg;
import bimp;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import cooperation.plugin.PluginInfo;

public class GVideoProxyActivity
  extends PluginProxyActivity
{
  public FlingHandler a;
  
  public static Dialog a(Activity paramActivity)
  {
    paramActivity = new bepp(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131298914));
    paramActivity.a(alpo.a(2131705809));
    paramActivity.setOnDismissListener(new bill());
    return paramActivity;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, String paramString2, int paramInt)
  {
    bimp localbimp = new bimp(1);
    localbimp.jdField_b_of_type_JavaLangString = "group_video_plugin.apk";
    localbimp.d = PluginInfo.k;
    localbimp.jdField_a_of_type_JavaLangString = paramString2;
    localbimp.e = paramString1;
    localbimp.jdField_a_of_type_JavaLangClass = GVideoProxyActivity.class;
    paramString1 = paramIntent;
    if (paramIntent == null) {
      paramString1 = new Intent();
    }
    localbimp.jdField_a_of_type_AndroidContentIntent = paramString1;
    localbimp.jdField_a_of_type_AndroidAppDialog = paramDialog;
    localbimp.jdField_a_of_type_AndroidContentIntent.putExtra("userQqResources", 2);
    localbimp.jdField_a_of_type_AndroidContentIntent.putExtra("param_plugin_gesturelock", true);
    localbimp.jdField_b_of_type_Int = paramInt;
    localbimp.c = 20000;
    localbimp.f = null;
    bimg.a(paramActivity, localbimp);
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
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (getIntent().getExtras() != null) {
      this.a = new bilm(this);
    }
    super.onCreate(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.groupvideo.GVideoProxyActivity
 * JD-Core Version:    0.7.0.1
 */