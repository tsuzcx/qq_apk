package cooperation.groupvideo.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGVideoSmallScreenDialog
  extends QRouteApi
{
  public abstract String getPluginID();
  
  public abstract void openPluginActivity(Activity paramActivity, Intent paramIntent, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.groupvideo.api.IGVideoSmallScreenDialog
 * JD-Core Version:    0.7.0.1
 */