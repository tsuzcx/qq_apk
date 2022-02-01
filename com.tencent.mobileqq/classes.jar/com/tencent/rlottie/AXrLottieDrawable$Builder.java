package com.tencent.rlottie;

import android.content.Context;
import java.io.File;

public class AXrLottieDrawable$Builder
  extends AXrLottieOptions
{
  private final AXrLottieDrawable.BuilderType p;
  private final File q;
  private final String r;
  private final Context s;
  
  public AXrLottieDrawable$Builder(Context paramContext, File paramFile)
  {
    if (paramFile != null)
    {
      this.s = paramContext;
      this.q = paramFile;
      this.r = null;
      this.p = AXrLottieDrawable.BuilderType.FILE;
      a(paramFile.getAbsolutePath());
      return;
    }
    throw new NullPointerException("lottie file can't be null!");
  }
  
  public AXrLottieDrawable a()
  {
    return new AXrLottieDrawable(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rlottie.AXrLottieDrawable.Builder
 * JD-Core Version:    0.7.0.1
 */