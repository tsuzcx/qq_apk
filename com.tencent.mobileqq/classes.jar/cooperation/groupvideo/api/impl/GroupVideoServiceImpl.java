package cooperation.groupvideo.api.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import cooperation.groupvideo.GVideoProxyActivity;
import cooperation.groupvideo.api.IGroupVideoService;

public class GroupVideoServiceImpl
  implements IGroupVideoService
{
  public Dialog installPlugin(Activity paramActivity)
  {
    return GVideoProxyActivity.a(paramActivity);
  }
  
  public void openPluginActivity(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, String paramString2, int paramInt)
  {
    GVideoProxyActivity.a(paramActivity, paramIntent, paramDialog, paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.groupvideo.api.impl.GroupVideoServiceImpl
 * JD-Core Version:    0.7.0.1
 */