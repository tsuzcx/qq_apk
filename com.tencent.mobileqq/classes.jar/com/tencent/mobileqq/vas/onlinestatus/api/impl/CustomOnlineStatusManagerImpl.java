package com.tencent.mobileqq.vas.onlinestatus.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager.Utils;
import com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager;

public class CustomOnlineStatusManagerImpl
  implements ICustomOnlineStatusManager
{
  public boolean featureEnable()
  {
    return CustomOnlineStatusManager.a().b();
  }
  
  public String getOwnerOnlineStatus()
  {
    return CustomOnlineStatusManager.a().c();
  }
  
  public void openH5(Activity paramActivity, String paramString)
  {
    CustomOnlineStatusManager.Utils.a(paramActivity, paramString);
  }
  
  public void registerChangeWeakListener(Runnable paramRunnable)
  {
    CustomOnlineStatusManager.a().a(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.onlinestatus.api.impl.CustomOnlineStatusManagerImpl
 * JD-Core Version:    0.7.0.1
 */