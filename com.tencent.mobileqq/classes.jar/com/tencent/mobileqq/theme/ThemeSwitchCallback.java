package com.tencent.mobileqq.theme;

import com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;

public class ThemeSwitchCallback
  implements IThemeSwitchCallback
{
  public boolean beforeSwitch(ThemeLocator paramThemeLocator)
  {
    return false;
  }
  
  public void beginSwitch() {}
  
  public void onProgress(long paramLong1, long paramLong2) {}
  
  public boolean postSwitch(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitchCallback
 * JD-Core Version:    0.7.0.1
 */