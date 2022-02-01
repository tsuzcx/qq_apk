package com.tencent.mobileqq.qqlive.view;

import android.annotation.SuppressLint;
import android.content.Context;

public class TPViewFactory
{
  @SuppressLint({"ObsoleteSdkInt"})
  public static ITPViewBase a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1) {
      return new TPTextureView(paramContext);
    }
    return new TPSurfaceView(paramContext, paramBoolean2, paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.view.TPViewFactory
 * JD-Core Version:    0.7.0.1
 */