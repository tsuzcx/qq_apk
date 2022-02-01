package com.tencent.mobileqq.theme.diy;

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
  
  public Drawable invoke()
  {
    Drawable localDrawable = this.val$context.getResources().getDrawable(2130845954);
    AppRuntime localAppRuntime = this.val$app;
    String str1 = this.val$themeBackground.path;
    String str2 = this.val$animateName;
    return VasApngUtil.getApngDrawable(localAppRuntime, str1, "-setting-", localDrawable, new int[] { 1 }, str2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeBackground.1
 * JD-Core Version:    0.7.0.1
 */