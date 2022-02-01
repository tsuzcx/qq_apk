package com.tencent.xaction.api.util;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/util/ScreenUnit$Companion;", "", "()V", "INVALID", "", "getINVALID", "()I", "SCREEN_HEIGHT", "", "getSCREEN_HEIGHT", "()F", "setSCREEN_HEIGHT", "(F)V", "SCREEN_WIDTH", "scale", "screenHeight", "getScreenHeight", "setScreenHeight", "screenWidth", "getScreenWidth", "setScreenWidth", "getFloatValue", "stValue", "defaultValue", "getIntValue", "getMaxHeight", "getPxIntValue", "addValue", "setScreen", "", "w", "h", "toPx", "value", "toPxF", "toRdp", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class ScreenUnit$Companion
{
  public final int a()
  {
    return ScreenUnit.a();
  }
  
  public final int a(int paramInt)
  {
    return (int)(paramInt / ScreenUnit.e() + 0.5F);
  }
  
  public final int a(int paramInt1, int paramInt2)
  {
    Companion localCompanion = (Companion)this;
    if (paramInt1 != localCompanion.a()) {
      return localCompanion.a(paramInt1);
    }
    return paramInt2;
  }
  
  public final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    Companion localCompanion = (Companion)this;
    if ((paramInt1 == localCompanion.a()) && (paramInt2 == localCompanion.a())) {
      return paramInt3;
    }
    paramInt3 = paramInt1;
    if (paramInt1 == localCompanion.a()) {
      paramInt3 = 0;
    }
    paramInt1 = paramInt2;
    if (paramInt2 == localCompanion.a()) {
      paramInt1 = 0;
    }
    return localCompanion.a(paramInt3 + paramInt1);
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
    ScreenUnit.d(750.0F / localCompanion.c());
    localCompanion.a(localCompanion.d() * ScreenUnit.e());
  }
  
  public final float b()
  {
    return ScreenUnit.b();
  }
  
  public final float b(float paramFloat1, float paramFloat2)
  {
    if ((int)paramFloat1 != ((Companion)this).a()) {
      return paramFloat1;
    }
    return paramFloat2;
  }
  
  public final int b(int paramInt1, int paramInt2)
  {
    if (paramInt1 != ((Companion)this).a()) {
      return paramInt1;
    }
    return paramInt2;
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
  
  public final float d()
  {
    return ScreenUnit.d();
  }
  
  public final int d(float paramFloat)
  {
    return (int)(paramFloat / ScreenUnit.e() + 0.5F);
  }
  
  public final int e(float paramFloat)
  {
    return (int)(paramFloat * ScreenUnit.e() + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.api.util.ScreenUnit.Companion
 * JD-Core Version:    0.7.0.1
 */