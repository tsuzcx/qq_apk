package com.tencent.xaction.api.util;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/util/ScreenUnit$Companion;", "", "()V", "SCREEN_WIDTH", "", "scale", "screenHeight", "getScreenHeight", "()F", "setScreenHeight", "(F)V", "screenWidth", "getScreenWidth", "setScreenWidth", "setScreen", "", "w", "h", "toPx", "", "value", "toRdp", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class ScreenUnit$Companion
{
  public final float a()
  {
    return ScreenUnit.a();
  }
  
  public final float a(float paramFloat)
  {
    return ScreenUnit.c() * paramFloat + 0.5F;
  }
  
  public final int a(float paramFloat)
  {
    return (int)(paramFloat / ScreenUnit.c() + 0.5F);
  }
  
  public final int a(int paramInt)
  {
    return (int)(paramInt / ScreenUnit.c() + 0.5F);
  }
  
  public final void a(float paramFloat)
  {
    ScreenUnit.a(paramFloat);
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    ((Companion)this).a(paramFloat1);
    ((Companion)this).b(paramFloat2);
    ScreenUnit.c(750.0F / ((Companion)this).a());
  }
  
  public final float b()
  {
    return ScreenUnit.b();
  }
  
  public final void b(float paramFloat)
  {
    ScreenUnit.b(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.util.ScreenUnit.Companion
 * JD-Core Version:    0.7.0.1
 */