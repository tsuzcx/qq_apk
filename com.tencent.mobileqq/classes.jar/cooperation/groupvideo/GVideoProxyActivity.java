package cooperation.groupvideo;

import alud;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import bety;
import bips;
import bipt;
import biqn;
import biqw;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import cooperation.plugin.PluginInfo;

public class GVideoProxyActivity
  extends PluginProxyActivity
{
  public FlingHandler a;
  
  public static Dialog a(Activity paramActivity)
  {
    paramActivity = new bety(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131298914));
    paramActivity.a(alud.a(2131705821));
    paramActivity.setOnDismissListener(new bips());
    return paramActivity;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, String paramString2, int paramInt)
  {
    biqw localbiqw = new biqw(1);
    localbiqw.jdField_b_of_type_JavaLangString = "group_video_plugin.apk";
    localbiqw.d = PluginInfo.k;
    localbiqw.jdField_a_of_type_JavaLangString = paramString2;
    localbiqw.e = paramString1;
    localbiqw.jdField_a_of_type_JavaLangClass = GVideoProxyActivity.class;
    paramString1 = paramIntent;
    if (paramIntent == null) {
      paramString1 = new Intent();
    }
    localbiqw.jdField_a_of_type_AndroidContentIntent = paramString1;
    localbiqw.jdField_a_of_type_AndroidAppDialog = paramDialog;
    localbiqw.jdField_a_of_type_AndroidContentIntent.putExtra("userQqResources", 2);
    localbiqw.jdField_a_of_type_AndroidContentIntent.putExtra("param_plugin_gesturelock", true);
    localbiqw.jdField_b_of_type_Int = paramInt;
    localbiqw.c = 20000;
    localbiqw.f = null;
    biqn.a(paramActivity, localbiqw);
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
      this.a = new bipt(this);
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