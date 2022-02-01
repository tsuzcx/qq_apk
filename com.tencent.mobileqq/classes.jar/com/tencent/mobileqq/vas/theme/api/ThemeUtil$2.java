package com.tencent.mobileqq.vas.theme.api;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

final class ThemeUtil$2
  implements IThemeSwitchCallback
{
  public boolean beforeSwitch(@Nullable ThemeLocator paramThemeLocator)
  {
    return false;
  }
  
  public void beginSwitch() {}
  
  public void onProgress(long paramLong1, long paramLong2) {}
  
  public boolean postSwitch(int paramInt)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ThemeUtil.2.1(this), 1000L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.api.ThemeUtil.2
 * JD-Core Version:    0.7.0.1
 */