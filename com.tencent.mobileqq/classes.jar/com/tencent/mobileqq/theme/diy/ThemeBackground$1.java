package com.tencent.mobileqq.theme.diy;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class ThemeBackground$1
  implements Runnable
{
  ThemeBackground$1(AppRuntime paramAppRuntime, int paramInt1, String paramString, View paramView, int paramInt2) {}
  
  public void run()
  {
    ThemeBackground localThemeBackground = ThemeBackground.getThemeBgObj(this.val$app, this.val$app.getApplication().getApplicationContext(), this.val$bgType, this.val$animateName);
    ThreadManagerV2.getUIHandlerV2().post(new ThemeBackground.1.1(this, localThemeBackground));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeBackground.1
 * JD-Core Version:    0.7.0.1
 */