package com.tencent.mobileqq.kandian.biz.viola.barrage;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageConfig;", "", "()V", "barrageLoop", "", "getBarrageLoop", "()Z", "setBarrageLoop", "(Z)V", "barrageSpace", "", "getBarrageSpace", "()I", "setBarrageSpace", "(I)V", "barrageTransparent", "", "getBarrageTransparent", "()F", "setBarrageTransparent", "(F)V", "lineCount", "getLineCount", "setLineCount", "orderOfAscending", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageConfig$AscendingOrder;", "getOrderOfAscending", "()Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageConfig$AscendingOrder;", "setOrderOfAscending", "(Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageConfig$AscendingOrder;)V", "slideDuration", "getSlideDuration", "setSlideDuration", "AscendingOrder", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BarrageConfig
{
  private int a = 3;
  private int b = 8;
  @NotNull
  private BarrageConfig.AscendingOrder c = BarrageConfig.AscendingOrder.TimeAsc;
  private float d = 5.5F;
  private boolean e = true;
  private float f = 0.2F;
  
  public final int a()
  {
    return this.a;
  }
  
  public final void a(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void a(@NotNull BarrageConfig.AscendingOrder paramAscendingOrder)
  {
    Intrinsics.checkParameterIsNotNull(paramAscendingOrder, "<set-?>");
    this.c = paramAscendingOrder;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final void b(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public final void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final float c()
  {
    return this.d;
  }
  
  public final boolean d()
  {
    return this.e;
  }
  
  public final float e()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageConfig
 * JD-Core Version:    0.7.0.1
 */