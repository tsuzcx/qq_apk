package cooperation.groupvideo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginInfo;

public class GVideoProxyActivity
  extends PluginProxyActivity
{
  public FlingHandler a;
  
  public static Dialog a(Activity paramActivity)
  {
    paramActivity = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299168));
    paramActivity.a(HardCodeUtil.a(2131705526));
    paramActivity.setOnDismissListener(new GVideoProxyActivity.1());
    return paramActivity;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, String paramString2, int paramInt)
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.b = "group_video_plugin.apk";
    localPluginParams.e = PluginInfo.k;
    localPluginParams.jdField_a_of_type_JavaLangString = paramString2;
    localPluginParams.f = paramString1;
    localPluginParams.jdField_a_of_type_JavaLangClass = GVideoProxyActivity.class;
    paramString1 = paramIntent;
    if (paramIntent == null) {
      paramString1 = new Intent();
    }
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramString1;
    localPluginParams.jdField_a_of_type_AndroidAppDialog = paramDialog;
    localPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("userQqResources", 2);
    localPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("param_plugin_gesturelock", true);
    localPluginParams.c = paramInt;
    localPluginParams.d = 20000;
    localPluginParams.g = null;
    IPluginManager.a(paramActivity, localPluginParams);
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
    if (isWrapContent())
    {
      FlingHandler localFlingHandler = this.a;
      if (localFlingHandler != null) {
        localFlingHandler.onConfigurationChanged(paramConfiguration);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.groupvideo.GVideoProxyActivity
 * JD-Core Version:    0.7.0.1
 */