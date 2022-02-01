package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import kotlin.jvm.functions.Function0;

final class ThemeBackground$1
  implements Function0<Drawable>
{
  ThemeBackground$1(int paramInt) {}
  
  public Drawable invoke()
  {
    if (this.val$defaultResId > 0) {
      return BaseApplicationImpl.getApplication().getBaseContext().getResources().getDrawable(this.val$defaultResId);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeBackground.1
 * JD-Core Version:    0.7.0.1
 */