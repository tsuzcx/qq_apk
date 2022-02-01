package com.tencent.mobileqq.theme;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

final class ThemeUtil$2
  extends ThemeSwitchCallback
{
  ThemeUtil$2(QQAppInterface paramQQAppInterface) {}
  
  public boolean postSwitch(int paramInt)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new ThemeUtil.2.1(this), 1000L);
    return super.postSwitch(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeUtil.2
 * JD-Core Version:    0.7.0.1
 */