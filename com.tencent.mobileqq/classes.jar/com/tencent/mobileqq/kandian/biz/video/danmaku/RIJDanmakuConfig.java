package com.tencent.mobileqq.kandian.biz.video.danmaku;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/RIJDanmakuConfig;", "", "lineCount", "", "lineSpace", "", "colomnSpace", "slideDurationMs", "", "maxWordCount", "textColor", "textStrokeColor", "textFontSize", "clickDuration", "(IFFJIIIFI)V", "getClickDuration", "()I", "getColomnSpace", "()F", "getLineCount", "getLineSpace", "getMaxWordCount", "getSlideDurationMs", "()J", "getTextColor", "getTextFontSize", "getTextStrokeColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDanmakuConfig
{
  private final float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private final float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int;
  private final float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int;
  private final int d;
  private final int e;
  
  public RIJDanmakuConfig()
  {
    this(0, 0.0F, 0.0F, 0L, 0, 0, 0, 0.0F, 0, 511, null);
  }
  
  public RIJDanmakuConfig(int paramInt1, float paramFloat1, float paramFloat2, long paramLong, int paramInt2, int paramInt3, int paramInt4, float paramFloat3, int paramInt5)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.d = paramInt4;
    this.jdField_c_of_type_Float = paramFloat3;
    this.e = paramInt5;
  }
  
  public final float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public final float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public final int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public final float c()
  {
    return this.jdField_c_of_type_Float;
  }
  
  public final int c()
  {
    return this.d;
  }
  
  public final int d()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof RIJDanmakuConfig))
      {
        paramObject = (RIJDanmakuConfig)paramObject;
        if ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (Float.compare(this.jdField_a_of_type_Float, paramObject.jdField_a_of_type_Float) == 0) && (Float.compare(this.jdField_b_of_type_Float, paramObject.jdField_b_of_type_Float) == 0) && (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) && (this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int) && (this.jdField_c_of_type_Int == paramObject.jdField_c_of_type_Int) && (this.d == paramObject.d) && (Float.compare(this.jdField_c_of_type_Float, paramObject.jdField_c_of_type_Float) == 0) && (this.e == paramObject.e)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int i = this.jdField_a_of_type_Int;
    int j = Float.floatToIntBits(this.jdField_a_of_type_Float);
    int k = Float.floatToIntBits(this.jdField_b_of_type_Float);
    long l = this.jdField_a_of_type_Long;
    return (((((((i * 31 + j) * 31 + k) * 31 + (int)(l ^ l >>> 32)) * 31 + this.jdField_b_of_type_Int) * 31 + this.jdField_c_of_type_Int) * 31 + this.d) * 31 + Float.floatToIntBits(this.jdField_c_of_type_Float)) * 31 + this.e;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RIJDanmakuConfig(lineCount=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", lineSpace=");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", colomnSpace=");
    localStringBuilder.append(this.jdField_b_of_type_Float);
    localStringBuilder.append(", slideDurationMs=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", maxWordCount=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", textColor=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", textStrokeColor=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", textFontSize=");
    localStringBuilder.append(this.jdField_c_of_type_Float);
    localStringBuilder.append(", clickDuration=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.RIJDanmakuConfig
 * JD-Core Version:    0.7.0.1
 */