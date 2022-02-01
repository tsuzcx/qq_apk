package cooperation.groupvideo.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IGroupVideoHelper
  extends QRouteApi
{
  public static final String API_ENTER_GROUP_VIDEO = "mqqapi://gvideo/open_plugin?src_type=app";
  public static final String CLASS_ACTIVITY = "com.gvideo.com.tencent.av.ui.GroupVideoActivity";
  public static final int REQUEST_OPEN_GROUP_VIDEO = 1;
  
  public abstract void bindService(AppRuntime paramAppRuntime, Class paramClass, ServiceConnection paramServiceConnection, String paramString);
  
  public abstract AppRuntime createAppInterface(Object paramObject, String paramString);
  
  public abstract boolean enterTroopVideo(AppInterface paramAppInterface, Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract boolean enterTroopVideoByPlugin(AppInterface paramAppInterface, Context paramContext, Intent paramIntent, int paramInt);
  
  public abstract boolean isGvideoExist(Context paramContext);
  
  public abstract void unbindService(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.groupvideo.api.IGroupVideoHelper
 * JD-Core Version:    0.7.0.1
 */