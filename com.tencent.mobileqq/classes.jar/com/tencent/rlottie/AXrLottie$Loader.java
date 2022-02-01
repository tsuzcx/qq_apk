package com.tencent.rlottie;

import android.content.Context;
import java.io.File;

public class AXrLottie$Loader
{
  public static AXrLottieDrawable a(Context paramContext, File paramFile, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return AXrLottieDrawable.a(paramContext, paramFile).a(paramInt1, paramInt2).a(paramBoolean1).b(paramBoolean2).a();
  }
  
  public static AXrLottieDrawable a(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramContext, new File(paramString), paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rlottie.AXrLottie.Loader
 * JD-Core Version:    0.7.0.1
 */