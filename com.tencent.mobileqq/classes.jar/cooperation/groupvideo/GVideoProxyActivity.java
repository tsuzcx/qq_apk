package cooperation.groupvideo;

import ajyc;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import bcpq;
import bgjw;
import bgjx;
import bgkq;
import bgkz;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import cooperation.plugin.PluginInfo;

public class GVideoProxyActivity
  extends PluginProxyActivity
{
  public FlingHandler a;
  
  public static Dialog a(Activity paramActivity)
  {
    paramActivity = new bcpq(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131298865));
    paramActivity.a(ajyc.a(2131705426));
    paramActivity.setOnDismissListener(new bgjw());
    return paramActivity;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, String paramString2, int paramInt)
  {
    bgkz localbgkz = new bgkz(1);
    localbgkz.jdField_b_of_type_JavaLangString = "group_video_plugin.apk";
    localbgkz.d = PluginInfo.k;
    localbgkz.jdField_a_of_type_JavaLangString = paramString2;
    localbgkz.e = paramString1;
    localbgkz.jdField_a_of_type_JavaLangClass = GVideoProxyActivity.class;
    paramString1 = paramIntent;
    if (paramIntent == null) {
      paramString1 = new Intent();
    }
    localbgkz.jdField_a_of_type_AndroidContentIntent = paramString1;
    localbgkz.jdField_a_of_type_AndroidAppDialog = paramDialog;
    localbgkz.jdField_a_of_type_AndroidContentIntent.putExtra("userQqResources", 2);
    localbgkz.jdField_a_of_type_AndroidContentIntent.putExtra("param_plugin_gesturelock", true);
    localbgkz.jdField_b_of_type_Int = paramInt;
    localbgkz.c = 20000;
    localbgkz.f = null;
    bgkq.a(paramActivity, localbgkz);
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
      this.a = new bgjx(this);
    }
    super.onCreate(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.groupvideo.GVideoProxyActivity
 * JD-Core Version:    0.7.0.1
 */