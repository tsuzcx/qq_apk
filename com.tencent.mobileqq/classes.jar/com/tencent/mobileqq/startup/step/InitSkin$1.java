package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.SimpleTintManager;
import com.tencent.theme.UpdateCallback;

final class InitSkin$1
  implements UpdateCallback
{
  public void a()
  {
    SimpleTintManager.instance().setThemeId(QQTheme.getCurrentThemeId());
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitSkin.1
 * JD-Core Version:    0.7.0.1
 */