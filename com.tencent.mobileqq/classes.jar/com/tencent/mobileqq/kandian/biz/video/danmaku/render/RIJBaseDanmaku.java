package com.tencent.mobileqq.kandian.biz.video.danmaku.render;

import android.view.View;
import com.tencent.common.danmaku.data.R2LDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.tool.ClickResult;
import com.tencent.common.danmaku.tool.Duration;
import com.tencent.common.danmaku.tool.TouchPoint;
import com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuDetail;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJBaseDanmaku;", "Lcom/tencent/common/danmaku/data/R2LDanmaku;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuDetail;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJDanmakuUIConfig;", "danmakuContext", "Lcom/tencent/common/danmaku/inject/DanmakuContext;", "danmakuView", "Landroid/view/View;", "(Lcom/tencent/common/danmaku/inject/DanmakuContext;Landroid/view/View;)V", "clickState", "", "getClickState", "()Z", "setClickState", "(Z)V", "getDanmakuView", "()Landroid/view/View;", "originContentHeight", "", "getOriginContentHeight", "()F", "setOriginContentHeight", "(F)V", "originContentWidth", "getOriginContentWidth", "setOriginContentWidth", "originLeft", "originTop", "reportBtnWidth", "getReportBtnWidth", "setReportBtnWidth", "afterMeasure", "", "getAccurateLeft", "currTime", "", "isClickReport", "touchPoint", "Lcom/tencent/common/danmaku/tool/TouchPoint;", "isTimeOut", "cTime", "onClick", "Lcom/tencent/common/danmaku/tool/ClickResult;", "onLayout", "x", "y", "playerTime", "drawTime", "onReLayout", "setDurationFactor", "factor", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract class RIJBaseDanmaku
  extends R2LDanmaku<DanmakuDetail, RIJDanmakuUIConfig>
{
  public static final RIJBaseDanmaku.Companion x = new RIJBaseDanmaku.Companion(null);
  private float A;
  private boolean B;
  private float C;
  private float D;
  private final DanmakuContext E;
  @NotNull
  private final View F;
  private float y;
  private float z;
  
  public RIJBaseDanmaku(@NotNull DanmakuContext paramDanmakuContext, @NotNull View paramView)
  {
    super(paramDanmakuContext);
    this.E = paramDanmakuContext;
    this.F = paramView;
  }
  
  public final float S()
  {
    return this.y;
  }
  
  public final float T()
  {
    return this.z;
  }
  
  public final boolean U()
  {
    return this.B;
  }
  
  @NotNull
  public ClickResult a(@Nullable TouchPoint paramTouchPoint)
  {
    return new ClickResult(-2);
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong1, long paramLong2)
  {
    super.a(paramFloat1, paramFloat2, paramLong1, paramLong2);
    if (p()) {
      this.C = t();
    }
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = this.t;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (paramLong - this.e >= 2000) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean b(@NotNull TouchPoint paramTouchPoint)
  {
    Intrinsics.checkParameterIsNotNull(paramTouchPoint, "touchPoint");
    return (paramTouchPoint.a() > u() - this.A) && (paramTouchPoint.a() < u());
  }
  
  public void c(float paramFloat)
  {
    if (!g()) {
      super.c(paramFloat);
    }
  }
  
  public void d(long paramLong)
  {
    g((int)(H() + this.y) / (float)this.d.a());
    if (g())
    {
      i(this.C - RIJDanmakuUIConfig.a.p());
      h((this.F.getWidth() - e()) / 2 - RIJDanmakuUIConfig.a.o());
      return;
    }
    i(this.C);
    h(super.i(paramLong));
    this.D = s();
  }
  
  public final void f(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
  
  protected float i(long paramLong)
  {
    if (g()) {
      return s();
    }
    return super.i(paramLong);
  }
  
  public final void j(float paramFloat)
  {
    this.y = paramFloat;
  }
  
  public final void k(float paramFloat)
  {
    this.z = paramFloat;
  }
  
  public final void l(float paramFloat)
  {
    this.A = paramFloat;
  }
  
  public void o()
  {
    super.o();
    g((int)(H() + this.y) / (float)this.d.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJBaseDanmaku
 * JD-Core Version:    0.7.0.1
 */