package com.tencent.mobileqq.vas.theme.diy;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class ThemeBackground$6
  implements Runnable
{
  ThemeBackground$6(AppRuntime paramAppRuntime, int paramInt1, String paramString, int paramInt2, View paramView) {}
  
  public void run()
  {
    Object localObject = this.a;
    localObject = ThemeBackground.a((AppRuntime)localObject, ((AppRuntime)localObject).getApplication().getApplicationContext(), this.b, this.c, this.d);
    ThreadManagerV2.getUIHandlerV2().post(new ThemeBackground.6.1(this, (ThemeBackground)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ThemeBackground.6
 * JD-Core Version:    0.7.0.1
 */