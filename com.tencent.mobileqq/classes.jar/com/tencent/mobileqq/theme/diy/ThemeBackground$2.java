package com.tencent.mobileqq.theme.diy;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class ThemeBackground$2
  implements Runnable
{
  ThemeBackground$2(AppRuntime paramAppRuntime, int paramInt1, String paramString, int paramInt2, View paramView) {}
  
  public void run()
  {
    ThemeBackground localThemeBackground = ThemeBackground.getThemeBgObj(this.val$app, this.val$app.getApplication().getApplicationContext(), this.val$bgType, this.val$animateName, this.val$defaultBgResId);
    ThreadManagerV2.getUIHandlerV2().post(new ThemeBackground.2.1(this, localThemeBackground));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeBackground.2
 * JD-Core Version:    0.7.0.1
 */