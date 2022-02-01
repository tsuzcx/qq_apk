package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;

public class OnlineStatusInjectorImpl
  implements IOnlineStatusInjector
{
  public boolean a()
  {
    Object localObject = BaseActivity.sTopActivity;
    boolean bool3 = localObject instanceof SplashActivity;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      localObject = (SplashActivity)localObject;
      bool1 = bool2;
      if (SplashActivity.currentFragment == 1)
      {
        bool1 = bool2;
        if (((SplashActivity)localObject).getCurrentTab() == FrameControllerUtil.a) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusInjectorImpl
 * JD-Core Version:    0.7.0.1
 */