package com.tencent.mobileqq.kandian.biz.video.danmaku.render;

import android.view.View;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.tool.TouchPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJMineDanmaku;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJBaseDanmaku;", "danmakuContext", "Lcom/tencent/common/danmaku/inject/DanmakuContext;", "danmakuView", "Landroid/view/View;", "(Lcom/tencent/common/danmaku/inject/DanmakuContext;Landroid/view/View;)V", "getType", "", "isClickReport", "", "touchPoint", "Lcom/tencent/common/danmaku/tool/TouchPoint;", "onLayout", "", "x", "", "y", "playerTime", "", "drawTime", "onReLayout", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public class RIJMineDanmaku
  extends RIJBaseDanmaku
{
  public RIJMineDanmaku(@NotNull DanmakuContext paramDanmakuContext, @NotNull View paramView)
  {
    super(paramDanmakuContext, paramView);
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong1, long paramLong2)
  {
    super.a(paramFloat1, paramFloat2, paramLong1, paramLong2);
    if (p()) {
      i(t() - RIJDanmakuUIConfig.a.c());
    }
  }
  
  public boolean b(@NotNull TouchPoint paramTouchPoint)
  {
    Intrinsics.checkParameterIsNotNull(paramTouchPoint, "touchPoint");
    return false;
  }
  
  public void d(long paramLong)
  {
    super.d(paramLong);
    i(t() - RIJDanmakuUIConfig.a.c());
  }
  
  public int q()
  {
    return 18;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJMineDanmaku
 * JD-Core Version:    0.7.0.1
 */