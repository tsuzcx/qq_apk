package com.tencent.mobileqq.kandian.biz.video.danmaku.render;

import android.view.View;
import com.tencent.mobileqq.danmaku.data.R2LDanmaku;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.tool.ClickResult;
import com.tencent.mobileqq.danmaku.tool.Duration;
import com.tencent.mobileqq.danmaku.tool.TouchPoint;
import com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuDetail;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJBaseDanmaku;", "Lcom/tencent/mobileqq/danmaku/data/R2LDanmaku;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuDetail;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJDanmakuUIConfig;", "danmakuContext", "Lcom/tencent/mobileqq/danmaku/inject/DanmakuContext;", "danmakuView", "Landroid/view/View;", "(Lcom/tencent/mobileqq/danmaku/inject/DanmakuContext;Landroid/view/View;)V", "clickState", "", "getClickState", "()Z", "setClickState", "(Z)V", "getDanmakuView", "()Landroid/view/View;", "originContentHeight", "", "getOriginContentHeight", "()F", "setOriginContentHeight", "(F)V", "originContentWidth", "getOriginContentWidth", "setOriginContentWidth", "originLeft", "originTop", "reportBtnWidth", "getReportBtnWidth", "setReportBtnWidth", "afterMeasure", "", "getAccurateLeft", "currTime", "", "isClickReport", "touchPoint", "Lcom/tencent/mobileqq/danmaku/tool/TouchPoint;", "isTimeOut", "cTime", "onClick", "Lcom/tencent/mobileqq/danmaku/tool/ClickResult;", "onLayout", "x", "y", "playerTime", "drawTime", "onReLayout", "setDurationFactor", "factor", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract class RIJBaseDanmaku
  extends R2LDanmaku<DanmakuDetail, RIJDanmakuUIConfig>
{
  public static final RIJBaseDanmaku.Companion a;
  @NotNull
  private final View a;
  private final DanmakuContext b;
  private float d;
  private float jdField_e_of_type_Float;
  private boolean jdField_e_of_type_Boolean;
  private float f;
  private float g;
  private float h;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRenderRIJBaseDanmaku$Companion = new RIJBaseDanmaku.Companion(null);
  }
  
  public RIJBaseDanmaku(@NotNull DanmakuContext paramDanmakuContext, @NotNull View paramView)
  {
    super(paramDanmakuContext);
    this.jdField_b_of_type_ComTencentMobileqqDanmakuInjectDanmakuContext = paramDanmakuContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  protected float a(long paramLong)
  {
    if (a()) {
      return d();
    }
    return super.a(paramLong);
  }
  
  @NotNull
  public ClickResult a(@Nullable TouchPoint paramTouchPoint)
  {
    return new ClickResult(-2);
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong1, long paramLong2)
  {
    super.a(paramFloat1, paramFloat2, paramLong1, paramLong2);
    if (c()) {
      this.g = e();
    }
  }
  
  public void a(long paramLong)
  {
    g((int)(f() + this.d) / (float)this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDuration.a());
    if (a())
    {
      i(this.g - RIJDanmakuUIConfig.a.i());
      h((this.jdField_a_of_type_AndroidViewView.getWidth() - b()) / 2 - RIJDanmakuUIConfig.a.h());
    }
    else
    {
      i(this.g);
      h(super.a(paramLong));
      this.h = d();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReLayout: left=");
      localStringBuilder.append(d());
      localStringBuilder.append(", speedX=");
      localStringBuilder.append(c());
      localStringBuilder.append(", drawTime=");
      localStringBuilder.append(paramLong);
      QLog.d("BaseDanmaku", 2, localStringBuilder.toString());
    }
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = this.c;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (paramLong - this.jdField_b_of_type_Long >= 2000) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean a(@NotNull TouchPoint paramTouchPoint)
  {
    Intrinsics.checkParameterIsNotNull(paramTouchPoint, "touchPoint");
    return (paramTouchPoint.a() > f() - this.f) && (paramTouchPoint.a() < f());
  }
  
  public void c(float paramFloat)
  {
    if (!a()) {
      super.c(paramFloat);
    }
  }
  
  public final void f(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void g()
  {
    super.g();
    g((int)(f() + this.d) / (float)this.jdField_a_of_type_ComTencentMobileqqDanmakuToolDuration.a());
  }
  
  public final boolean i()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public final void j(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public final void k(float paramFloat)
  {
    this.jdField_e_of_type_Float = paramFloat;
  }
  
  public final float l()
  {
    return this.d;
  }
  
  public final void l(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public final float m()
  {
    return this.jdField_e_of_type_Float;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJBaseDanmaku
 * JD-Core Version:    0.7.0.1
 */