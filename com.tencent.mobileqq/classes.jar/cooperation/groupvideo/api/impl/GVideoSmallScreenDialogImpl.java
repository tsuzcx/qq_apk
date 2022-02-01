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
    localPluginParams.d = "group_video_plugin.apk";
    localPluginParams.g = PluginInfo.k;
    localPluginParams.c = paramString;
    localPluginParams.h = "com.gvideo.com.tencent.av.smallscreen.SmallScreenDialogActivity";
    localPluginParams.i = GVideoSmallScreenDialog.class;
    paramString = paramIntent;
    if (paramIntent == null) {
      paramString = new Intent();
    }
    localPluginParams.j = paramString;
    localPluginParams.j.putExtra("userQqResources", 2);
    localPluginParams.j.putExtra("param_plugin_gesturelock", true);
    localPluginParams.r = 10000;
    localPluginParams.q = null;
    IPluginManager.a(paramActivity, localPluginParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.groupvideo.api.impl.GVideoSmallScreenDialogImpl
 * JD-Core Version:    0.7.0.1
 */