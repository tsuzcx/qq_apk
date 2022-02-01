package com.tencent.mobileqq.kandian.biz.video.danmaku.render;

import android.view.View;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.inject.DanmakuContext;
import com.tencent.mobileqq.danmaku.inject.IDanmakuCreator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJDanmakuCreator;", "Lcom/tencent/mobileqq/danmaku/inject/IDanmakuCreator;", "danmakuView", "Landroid/view/View;", "(Landroid/view/View;)V", "getDanmakuView", "()Landroid/view/View;", "createDanmaku", "Lcom/tencent/mobileqq/danmaku/data/BaseDanmaku;", "danmakuContext", "Lcom/tencent/mobileqq/danmaku/inject/DanmakuContext;", "danmakuType", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDanmakuCreator
  implements IDanmakuCreator
{
  @NotNull
  private final View a;
  
  public RIJDanmakuCreator(@NotNull View paramView)
  {
    this.a = paramView;
  }
  
  @Nullable
  public BaseDanmaku<?, ?> a(@NotNull DanmakuContext paramDanmakuContext, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramDanmakuContext, "danmakuContext");
    switch (paramInt)
    {
    default: 
      return null;
    case 20: 
      return (BaseDanmaku)new RIJAuthorMineDanmaku(paramDanmakuContext, this.a);
    case 19: 
      return (BaseDanmaku)new RIJAuthorDanmaku(paramDanmakuContext, this.a);
    case 18: 
      return (BaseDanmaku)new RIJMineDanmaku(paramDanmakuContext, this.a);
    }
    return (BaseDanmaku)new RIJSimpleDanmaku(paramDanmakuContext, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuCreator
 * JD-Core Version:    0.7.0.1
 */