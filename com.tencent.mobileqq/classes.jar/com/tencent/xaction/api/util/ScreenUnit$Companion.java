package com.tencent.xaction.api.util;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/util/ScreenUnit$Companion;", "", "()V", "INVALID", "", "getINVALID", "()I", "SCREEN_HEIGHT", "", "getSCREEN_HEIGHT", "()F", "setSCREEN_HEIGHT", "(F)V", "SCREEN_WIDTH", "scale", "screenHeight", "getScreenHeight", "setScreenHeight", "screenWidth", "getScreenWidth", "setScreenWidth", "getMaxHeight", "setScreen", "", "w", "h", "toPx", "value", "toPxF", "toRdp", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class ScreenUnit$Companion
{
  public final float a()
  {
    return ScreenUnit.a();
  }
  
  public final int a()
  {
    return ScreenUnit.a();
  }
  
  public final int a(float paramFloat)
  {
    return (int)(paramFloat / ScreenUnit.d() + 0.5F);
  }
  
  public final int a(int paramInt)
  {
    return (int)(paramInt / ScreenUnit.d() + 0.5F);
  }
  
  public final void a(float paramFloat)
  {
    ScreenUnit.a(paramFloat);
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    Companion localCompanion = (Companion)this;
    localCompanion.b(paramFloat1);
    localCompanion.c(paramFloat2);
    ScreenUnit.d(750.0F / localCompanion.b());
    localCompanion.a(localCompanion.c() * ScreenUnit.d());
  }
  
  public final float b()
  {
    return ScreenUnit.b();
  }
  
  public final int b(float paramFloat)
  {
    return (int)(paramFloat * ScreenUnit.d() + 0.5F);
  }
  
  public final void b(float paramFloat)
  {
    ScreenUnit.b(paramFloat);
  }
  
  public final float c()
  {
    return ScreenUnit.c();
  }
  
  public final void c(float paramFloat)
  {
    ScreenUnit.c(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.api.util.ScreenUnit.Companion
 * JD-Core Version:    0.7.0.1
 */