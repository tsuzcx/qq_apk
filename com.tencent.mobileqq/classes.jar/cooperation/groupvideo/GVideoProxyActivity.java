package cooperation.groupvideo;

import alvg;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

public class GVideoProxyActivity
  extends PluginProxyActivity
{
  public FlingHandler a;
  
  public static Dialog a(Activity paramActivity)
  {
    paramActivity = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131558448));
    paramActivity.a("正在加载...");
    paramActivity.setOnDismissListener(new alvg());
    return paramActivity;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, String paramString2, int paramInt)
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.jdField_b_of_type_JavaLangString = "group_video_plugin.apk";
    localPluginParams.d = "群视频";
    localPluginParams.jdField_a_of_type_JavaLangString = paramString2;
    localPluginParams.e = paramString1;
    localPluginParams.jdField_a_of_type_JavaLangClass = GVideoProxyActivity.class;
    paramString1 = paramIntent;
    if (paramIntent == null) {
      paramString1 = new Intent();
    }
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramString1;
    localPluginParams.jdField_a_of_type_AndroidAppDialog = paramDialog;
    localPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("userQqResources", 2);
    localPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("param_plugin_gesturelock", true);
    localPluginParams.jdField_b_of_type_Int = paramInt;
    localPluginParams.c = 20000;
    localPluginParams.f = null;
    IPluginManager.a(paramActivity, localPluginParams);
  }
  
  public String getPluginID()
  {
    return "group_video_plugin.apk";
  }
  
  public Class getProxyActivity(String paramString)
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
  
  protected void onCreate(Bundle paramBundle)
  {
    if (getIntent().getExtras() != null) {
      this.a = new GVideoProxyActivity.MyFlingGestureHandler(this);
    }
    super.onCreate(paramBundle);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.a.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.groupvideo.GVideoProxyActivity
 * JD-Core Version:    0.7.0.1
 */