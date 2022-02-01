package com.tencent.mobileqq.vas.theme.diy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.mobileqq.vas.VasApngUtil;
import kotlin.jvm.functions.Function0;
import mqq.app.AppRuntime;

final class ThemeBackground$2
  implements Function0<Drawable>
{
  ThemeBackground$2(boolean paramBoolean, Context paramContext, AppRuntime paramAppRuntime, ThemeBackground paramThemeBackground, String paramString) {}
  
  public Drawable a()
  {
    if (this.a) {
      ThemeBackground.i.c();
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_use_rect", true);
    Drawable localDrawable = this.b.getResources().getDrawable(2130838959);
    return VasApngUtil.getApngDrawable(this.c, this.d.a, "-conversation-", localDrawable, VasApngUtil.converstionTag, this.e, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ThemeBackground.2
 * JD-Core Version:    0.7.0.1
 */