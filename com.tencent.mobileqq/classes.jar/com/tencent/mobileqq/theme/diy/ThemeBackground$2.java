package com.tencent.mobileqq.theme.diy;

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
  
  public Drawable invoke()
  {
    if (this.val$isRecent) {
      ThemeBackground.sRecentBusinessFlag.setUseApng();
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_use_rect", true);
    Drawable localDrawable = this.val$context.getResources().getDrawable(2130838912);
    return VasApngUtil.getApngDrawable(this.val$app, this.val$themeBackground.path, "-conversation-", localDrawable, VasApngUtil.converstionTag, this.val$animateName, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeBackground.2
 * JD-Core Version:    0.7.0.1
 */