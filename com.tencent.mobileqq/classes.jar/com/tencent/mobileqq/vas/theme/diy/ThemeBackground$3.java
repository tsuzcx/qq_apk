package com.tencent.mobileqq.vas.theme.diy;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.jvm.functions.Function0;
import mqq.app.MobileQQ;

final class ThemeBackground$3
  implements Function0<Drawable>
{
  ThemeBackground$3(int paramInt) {}
  
  public Drawable a()
  {
    if (this.a > 0) {
      return MobileQQ.getContext().getResources().getDrawable(this.a);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ThemeBackground.3
 * JD-Core Version:    0.7.0.1
 */