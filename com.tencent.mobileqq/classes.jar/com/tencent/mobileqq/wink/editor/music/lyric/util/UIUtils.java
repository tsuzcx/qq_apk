package com.tencent.mobileqq.wink.editor.music.lyric.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public final class UIUtils
{
  public static float a(Context paramContext)
  {
    if (paramContext == null) {
      return 0.0F;
    }
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * a(paramContext) + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.util.UIUtils
 * JD-Core Version:    0.7.0.1
 */