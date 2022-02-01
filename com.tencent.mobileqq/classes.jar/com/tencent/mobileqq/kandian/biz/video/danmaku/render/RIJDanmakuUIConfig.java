package com.tencent.mobileqq.kandian.biz.video.danmaku.render;

import android.graphics.Color;
import com.tencent.common.danmaku.inject.IDanmakuUIConfig;
import com.tencent.mobileqq.kandian.biz.video.danmaku.RIJDanmakuConfig;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJDanmakuUIConfig;", "Lcom/tencent/common/danmaku/inject/IDanmakuUIConfig;", "config", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/RIJDanmakuConfig;", "(Lcom/tencent/mobileqq/kandian/biz/video/danmaku/RIJDanmakuConfig;)V", "textColor", "", "getTextColor", "()I", "setTextColor", "(I)V", "textSize", "", "getTextSize", "()F", "setTextSize", "(F)V", "textStrokeColor", "getTextStrokeColor", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDanmakuUIConfig
  implements IDanmakuUIConfig
{
  public static final RIJDanmakuUIConfig.Companion a = new RIJDanmakuUIConfig.Companion(null);
  private static final float e = ViewUtils.dip2px(1.0F);
  private static final int f = ViewUtils.dip2px(6.0F);
  private static final int g = ViewUtils.dip2px(4.0F);
  private static final float h = ViewUtils.dip2px(4.0F);
  private static final int i = Color.parseColor("#bfffffff");
  private static final float j = ViewUtils.dip2px(1.5F);
  private static final int k = ViewUtils.dip2px(33.700001F);
  private static final float l = ViewUtils.dip2px(16.700001F);
  private static final int m = ViewUtils.dip2px(3.0F);
  @NotNull
  private static final String n = "举报";
  private static final float o = ViewUtils.dip2px(12.0F);
  private static final int p = Color.parseColor("#FFFFFFFF");
  private static final int q = Color.parseColor("#b3242424");
  private static final float r = ViewUtils.dip2px(6.0F);
  private static final int s = ViewUtils.dip2px(8.0F);
  private static final int t = ViewUtils.dip2px(8.0F);
  private static final int u = ViewUtils.dip2px(14.0F);
  private static final float v = ViewUtils.dip2px(14.0F);
  private static final int w = ViewUtils.dip2px(12.0F);
  private static final int x = ViewUtils.dip2px(5.0F);
  private float b;
  private int c;
  private final int d;
  
  public RIJDanmakuUIConfig(@NotNull RIJDanmakuConfig paramRIJDanmakuConfig)
  {
    this.b = ViewUtils.dip2px(paramRIJDanmakuConfig.g());
    this.c = paramRIJDanmakuConfig.e();
    this.d = paramRIJDanmakuConfig.f();
  }
  
  public final float a()
  {
    return this.b;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final int c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuUIConfig
 * JD-Core Version:    0.7.0.1
 */