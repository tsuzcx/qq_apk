package com.tencent.mobileqq.winkpublish.util;

import android.annotation.TargetApi;
import android.graphics.Paint;
import android.view.View;

public class ReflectionUtil
{
  @TargetApi(11)
  public static void a(View paramView, int paramInt, Paint paramPaint)
  {
    if (VersionUtils.a()) {
      paramView.setLayerType(paramInt, paramPaint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.util.ReflectionUtil
 * JD-Core Version:    0.7.0.1
 */