package com.tencent.mobileqq.kandian.biz.video.danmaku.render;

import android.graphics.Color;
import com.tencent.mobileqq.danmaku.inject.IDanmakuUIConfig;
import com.tencent.mobileqq.kandian.biz.video.danmaku.RIJDanmakuConfig;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/render/RIJDanmakuUIConfig;", "Lcom/tencent/mobileqq/danmaku/inject/IDanmakuUIConfig;", "config", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/RIJDanmakuConfig;", "(Lcom/tencent/mobileqq/kandian/biz/video/danmaku/RIJDanmakuConfig;)V", "textColor", "", "getTextColor", "()I", "setTextColor", "(I)V", "textSize", "", "getTextSize", "()F", "setTextSize", "(F)V", "textStrokeColor", "getTextStrokeColor", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDanmakuUIConfig
  implements IDanmakuUIConfig
{
  public static final RIJDanmakuUIConfig.Companion a;
  @NotNull
  private static final String jdField_a_of_type_JavaLangString = "举报";
  private static final float jdField_b_of_type_Float;
  private static final float jdField_c_of_type_Float;
  private static final int jdField_c_of_type_Int;
  private static final float jdField_d_of_type_Float;
  private static final int jdField_d_of_type_Int;
  private static final float jdField_e_of_type_Float;
  private static final int jdField_e_of_type_Int;
  private static final float jdField_f_of_type_Float;
  private static final int jdField_f_of_type_Int;
  private static final float jdField_g_of_type_Float;
  private static final int jdField_g_of_type_Int;
  private static final float jdField_h_of_type_Float = ViewUtils.a(14.0F);
  private static final int jdField_h_of_type_Int;
  private static final int i;
  private static final int j;
  private static final int k;
  private static final int l;
  private static final int m = ViewUtils.a(12.0F);
  private static final int n = ViewUtils.a(5.0F);
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private final int jdField_b_of_type_Int;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizVideoDanmakuRenderRIJDanmakuUIConfig$Companion = new RIJDanmakuUIConfig.Companion(null);
    jdField_b_of_type_Float = ViewUtils.a(1.0F);
    jdField_c_of_type_Int = ViewUtils.a(6.0F);
    jdField_d_of_type_Int = ViewUtils.a(4.0F);
    jdField_c_of_type_Float = ViewUtils.a(4.0F);
    jdField_e_of_type_Int = Color.parseColor("#bfffffff");
    jdField_d_of_type_Float = ViewUtils.a(1.5F);
    jdField_f_of_type_Int = ViewUtils.a(33.700001F);
    jdField_e_of_type_Float = ViewUtils.a(16.700001F);
    jdField_g_of_type_Int = ViewUtils.a(3.0F);
    jdField_a_of_type_JavaLangString = "举报";
    jdField_f_of_type_Float = ViewUtils.a(12.0F);
    jdField_h_of_type_Int = Color.parseColor("#FFFFFFFF");
    i = Color.parseColor("#b3242424");
    jdField_g_of_type_Float = ViewUtils.a(6.0F);
    j = ViewUtils.a(8.0F);
    k = ViewUtils.a(8.0F);
    l = ViewUtils.a(14.0F);
  }
  
  public RIJDanmakuUIConfig(@NotNull RIJDanmakuConfig paramRIJDanmakuConfig)
  {
    this.jdField_a_of_type_Float = ViewUtils.a(paramRIJDanmakuConfig.c());
    this.jdField_a_of_type_Int = paramRIJDanmakuConfig.b();
    this.jdField_b_of_type_Int = paramRIJDanmakuConfig.c();
  }
  
  public final float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final int b()
  {
    return this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.render.RIJDanmakuUIConfig
 * JD-Core Version:    0.7.0.1
 */