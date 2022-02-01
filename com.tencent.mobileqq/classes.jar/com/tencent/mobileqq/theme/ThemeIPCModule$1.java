package com.tencent.mobileqq.theme;

import android.os.RemoteException;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.qphone.base.util.QLog;

class ThemeIPCModule$1
  extends ThemeSwitchCallback
{
  ThemeIPCModule$1(ThemeIPCModule paramThemeIPCModule, ISwitchCallback paramISwitchCallback) {}
  
  public boolean beforeSwitch(ThemeLocator paramThemeLocator)
  {
    try
    {
      this.val$remote.doSwitch(paramThemeLocator.a(), paramThemeLocator.d());
      return true;
    }
    catch (RemoteException paramThemeLocator)
    {
      QLog.e("ThemeIPCModule", 1, "beforeSwitch: ", paramThemeLocator);
    }
    return true;
  }
  
  public void beginSwitch()
  {
    try
    {
      this.val$remote.beginSwitch();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("ThemeIPCModule", 1, "beginSwitch: ", localRemoteException);
    }
  }
  
  public boolean postSwitch(int paramInt)
  {
    try
    {
      this.val$remote.postSwitch(paramInt);
      return super.postSwitch(paramInt);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        QLog.e("ThemeIPCModule", 1, "postSwitch: ", localRemoteException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeIPCModule.1
 * JD-Core Version:    0.7.0.1
 */