package com.tencent.mobileqq.kandian.biz.video.danmaku.render;

import com.tencent.common.danmaku.inject.IDanmakuUIConfig;
import com.tencent.common.danmaku.inject.IDanmakuUIConfigCreator;
import com.tencent.mobileqq.kandian.biz.video.danmaku.RIJDanmakuConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJDanmakuUIConfigCreator;", "Lcom/tencent/common/danmaku/inject/IDanmakuUIConfigCreator;", "config", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/RIJDanmakuConfig;", "(Lcom/tencent/mobileqq/kandian/biz/video/danmaku/RIJDanmakuConfig;)V", "getConfig", "()Lcom/tencent/mobileqq/kandian/biz/video/danmaku/RIJDanmakuConfig;", "setConfig", "createConfig", "Lcom/tencent/common/danmaku/inject/IDanmakuUIConfig;", "danmakuType", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDanmakuUIConfigCreator
  implements IDanmakuUIConfigCreator
{
  @NotNull
  private RIJDanmakuConfig a;
  
  public RIJDanmakuUIConfigCreator(@NotNull RIJDanmakuConfig paramRIJDanmakuConfig)
  {
    this.a = paramRIJDanmakuConfig;
  }
  
  @Nullable
  public IDanmakuUIConfig a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return (IDanmakuUIConfig)new RIJDanmakuUIConfig(this.a);
  }
  
  public final void a(@NotNull RIJDanmakuConfig paramRIJDanmakuConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJDanmakuConfig, "<set-?>");
    this.a = paramRIJDanmakuConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuUIConfigCreator
 * JD-Core Version:    0.7.0.1
 */