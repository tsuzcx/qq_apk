package cooperation.groupvideo;

import ajjy;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import bbms;
import bfcf;
import bfcg;
import bfcz;
import bfdi;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import cooperation.plugin.PluginInfo;

public class GVideoProxyActivity
  extends PluginProxyActivity
{
  public FlingHandler a;
  
  public static Dialog a(Activity paramActivity)
  {
    paramActivity = new bbms(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131167766));
    paramActivity.a(ajjy.a(2131639641));
    paramActivity.setOnDismissListener(new bfcf());
    return paramActivity;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, String paramString2, int paramInt)
  {
    bfdi localbfdi = new bfdi(1);
    localbfdi.jdField_b_of_type_JavaLangString = "group_video_plugin.apk";
    localbfdi.d = PluginInfo.k;
    localbfdi.jdField_a_of_type_JavaLangString = paramString2;
    localbfdi.e = paramString1;
    localbfdi.jdField_a_of_type_JavaLangClass = GVideoProxyActivity.class;
    paramString1 = paramIntent;
    if (paramIntent == null) {
      paramString1 = new Intent();
    }
    localbfdi.jdField_a_of_type_AndroidContentIntent = paramString1;
    localbfdi.jdField_a_of_type_AndroidAppDialog = paramDialog;
    localbfdi.jdField_a_of_type_AndroidContentIntent.putExtra("userQqResources", 2);
    localbfdi.jdField_a_of_type_AndroidContentIntent.putExtra("param_plugin_gesturelock", true);
    localbfdi.jdField_b_of_type_Int = paramInt;
    localbfdi.c = 20000;
    localbfdi.f = null;
    bfcz.a(paramActivity, localbfdi);
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
      this.a = new bfcg(this);
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