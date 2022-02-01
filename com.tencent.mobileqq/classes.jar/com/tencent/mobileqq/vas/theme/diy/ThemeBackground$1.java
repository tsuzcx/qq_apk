package com.tencent.mobileqq.vas.theme.diy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.vas.VasApngUtil;
import kotlin.jvm.functions.Function0;
import mqq.app.AppRuntime;

final class ThemeBackground$1
  implements Function0<Drawable>
{
  ThemeBackground$1(Context paramContext, AppRuntime paramAppRuntime, ThemeBackground paramThemeBackground, String paramString) {}
  
  public Drawable a()
  {
    Drawable localDrawable = this.a.getResources().getDrawable(2130847705);
    AppRuntime localAppRuntime = this.b;
    String str1 = this.c.a;
    String str2 = this.d;
    return VasApngUtil.getApngDrawable(localAppRuntime, str1, "-setting-", localDrawable, new int[] { 1 }, str2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ThemeBackground.1
 * JD-Core Version:    0.7.0.1
 */