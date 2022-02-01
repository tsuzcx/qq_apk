package cooperation.groupvideo.api.impl;

import android.app.Activity;
import android.content.Intent;
import cooperation.groupvideo.GVideoSmallScreenDialog;
import cooperation.groupvideo.api.IGVideoSmallScreenDialog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginInfo;

public class GVideoSmallScreenDialogImpl
  implements IGVideoSmallScreenDialog
{
  public String getPluginID()
  {
    return "group_video_plugin.apk";
  }
  
  public void openPluginActivity(Activity paramActivity, Intent paramIntent, String paramString)
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.b = "group_video_plugin.apk";
    localPluginParams.e = PluginInfo.k;
    localPluginParams.jdField_a_of_type_JavaLangString = paramString;
    localPluginParams.f = "com.gvideo.com.tencent.av.smallscreen.SmallScreenDialogActivity";
    localPluginParams.jdField_a_of_type_JavaLangClass = GVideoSmallScreenDialog.class;
    paramString = paramIntent;
    if (paramIntent == null) {
      paramString = new Intent();
    }
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramString;
    localPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("userQqResources", 2);
    localPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("param_plugin_gesturelock", true);
    localPluginParams.d = 10000;
    localPluginParams.g = null;
    IPluginManager.a(paramActivity, localPluginParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.groupvideo.api.impl.GVideoSmallScreenDialogImpl
 * JD-Core Version:    0.7.0.1
 */