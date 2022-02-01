package com.tencent.mobileqq.kandian.biz.video.danmaku;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/RIJDanmakuConfig;", "", "lineCount", "", "lineSpace", "", "colomnSpace", "slideDurationMs", "", "maxWordCount", "textColor", "textStrokeColor", "textFontSize", "clickDuration", "numShowLike", "guideDuration", "danmakuDelayTime", "(IFFJIIIFIIJJ)V", "getClickDuration", "()I", "getColomnSpace", "()F", "getDanmakuDelayTime", "()J", "getGuideDuration", "getLineCount", "getLineSpace", "getMaxWordCount", "getNumShowLike", "getSlideDurationMs", "getTextColor", "getTextFontSize", "getTextStrokeColor", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDanmakuConfig
{
  private final int a;
  private final float b;
  private final float c;
  private final long d;
  private final int e;
  private final int f;
  private final int g;
  private final float h;
  private final int i;
  private final int j;
  private final long k;
  private final long l;
  
  public RIJDanmakuConfig()
  {
    this(0, 0.0F, 0.0F, 0L, 0, 0, 0, 0.0F, 0, 0, 0L, 0L, 4095, null);
  }
  
  public RIJDanmakuConfig(int paramInt1, float paramFloat1, float paramFloat2, long paramLong1, int paramInt2, int paramInt3, int paramInt4, float paramFloat3, int paramInt5, int paramInt6, long paramLong2, long paramLong3)
  {
    this.a = paramInt1;
    this.b = paramFloat1;
    this.c = paramFloat2;
    this.d = paramLong1;
    this.e = paramInt2;
    this.f = paramInt3;
    this.g = paramInt4;
    this.h = paramFloat3;
    this.i = paramInt5;
    this.j = paramInt6;
    this.k = paramLong2;
    this.l = paramLong3;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final float b()
  {
    return this.b;
  }
  
  public final float c()
  {
    return this.c;
  }
  
  public final long d()
  {
    return this.d;
  }
  
  public final int e()
  {
    return this.f;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof RIJDanmakuConfig))
      {
        paramObject = (RIJDanmakuConfig)paramObject;
        if ((this.a == paramObject.a) && (Float.compare(this.b, paramObject.b) == 0) && (Float.compare(this.c, paramObject.c) == 0) && (this.d == paramObject.d) && (this.e == paramObject.e) && (this.f == paramObject.f) && (this.g == paramObject.g) && (Float.compare(this.h, paramObject.h) == 0) && (this.i == paramObject.i) && (this.j == paramObject.j) && (this.k == paramObject.k) && (this.l == paramObject.l)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int f()
  {
    return this.g;
  }
  
  public final float g()
  {
    return this.h;
  }
  
  public final int h()
  {
    return this.i;
  }
  
  public int hashCode()
  {
    int m = this.a;
    int n = Float.floatToIntBits(this.b);
    int i1 = Float.floatToIntBits(this.c);
    long l1 = this.d;
    int i2 = (int)(l1 ^ l1 >>> 32);
    int i3 = this.e;
    int i4 = this.f;
    int i5 = this.g;
    int i6 = Float.floatToIntBits(this.h);
    int i7 = this.i;
    int i8 = this.j;
    l1 = this.k;
    int i9 = (int)(l1 ^ l1 >>> 32);
    l1 = this.l;
    return ((((((((((m * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + (int)(l1 ^ l1 >>> 32);
  }
  
  public final long i()
  {
    return this.k;
  }
  
  public final long j()
  {
    return this.l;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RIJDanmakuConfig(lineCount=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", lineSpace=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", colomnSpace=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", slideDurationMs=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", maxWordCount=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", textColor=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", textStrokeColor=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", textFontSize=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", clickDuration=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", numShowLike=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", guideDuration=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", danmakuDelayTime=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.RIJDanmakuConfig
 * JD-Core Version:    0.7.0.1
 */