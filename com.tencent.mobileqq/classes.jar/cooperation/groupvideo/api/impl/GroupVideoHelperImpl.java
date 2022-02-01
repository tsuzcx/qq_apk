package cooperation.groupvideo.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.groupvideo.GroupVideoHelper;
import cooperation.groupvideo.api.IGroupVideoHelper;
import mqq.app.AppRuntime;

public class GroupVideoHelperImpl
  implements IGroupVideoHelper
{
  public void bindService(AppRuntime paramAppRuntime, Class paramClass, ServiceConnection paramServiceConnection, String paramString)
  {
    GroupVideoHelper.a(paramAppRuntime, paramClass, paramServiceConnection, paramString);
  }
  
  public AppRuntime createAppInterface(Object paramObject, String paramString)
  {
    return GroupVideoHelper.a((BaseApplicationImpl)paramObject, paramString);
  }
  
  public boolean enterTroopVideo(AppInterface paramAppInterface, Activity paramActivity, Intent paramIntent, int paramInt)
  {
    return GroupVideoHelper.a(paramAppInterface, paramActivity, paramIntent, paramInt);
  }
  
  public boolean enterTroopVideoByPlugin(AppInterface paramAppInterface, Context paramContext, Intent paramIntent, int paramInt)
  {
    return GroupVideoHelper.a((QQAppInterface)paramAppInterface, paramContext, paramIntent, paramInt);
  }
  
  public boolean isGvideoExist(Context paramContext)
  {
    return GroupVideoHelper.a(paramContext);
  }
  
  public void unbindService(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    GroupVideoHelper.a(paramAppRuntime, paramServiceConnection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.groupvideo.api.impl.GroupVideoHelperImpl
 * JD-Core Version:    0.7.0.1
 */