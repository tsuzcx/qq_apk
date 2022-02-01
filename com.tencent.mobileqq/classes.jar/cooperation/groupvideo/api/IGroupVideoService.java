package cooperation.groupvideo.api;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGroupVideoService
  extends QRouteApi
{
  public abstract Dialog installPlugin(Activity paramActivity);
  
  public abstract void openPluginActivity(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, String paramString2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.groupvideo.api.IGroupVideoService
 * JD-Core Version:    0.7.0.1
 */