package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/VideoTrackConfig;", "", "thumbWidth", "", "thumbHeight", "singleShowThumbWidth", "videoTrackMargin", "transitionViewWidth", "transitionViewHeight", "showTopDurationTag", "", "(FFFFFFZ)V", "getShowTopDurationTag", "()Z", "getSingleShowThumbWidth", "()F", "getThumbHeight", "getThumbWidth", "getTransitionViewHeight", "getTransitionViewWidth", "getVideoTrackMargin", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class VideoTrackConfig
{
  private final float a;
  private final float b;
  private final float c;
  private final float d;
  private final float e;
  private final float f;
  private final boolean g;
  
  public VideoTrackConfig()
  {
    this(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, false, 127, null);
  }
  
  public VideoTrackConfig(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
    this.e = paramFloat5;
    this.f = paramFloat6;
    this.g = paramBoolean;
  }
  
  public final float a()
  {
    return this.c;
  }
  
  @NotNull
  public final VideoTrackConfig a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    return new VideoTrackConfig(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramBoolean);
  }
  
  public final float b()
  {
    return this.d;
  }
  
  public final boolean c()
  {
    return this.g;
  }
  
  public final float d()
  {
    return this.a;
  }
  
  public final float e()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VideoTrackConfig))
      {
        paramObject = (VideoTrackConfig)paramObject;
        if ((Float.compare(this.a, paramObject.a) == 0) && (Float.compare(this.b, paramObject.b) == 0) && (Float.compare(this.c, paramObject.c) == 0) && (Float.compare(this.d, paramObject.d) == 0) && (Float.compare(this.e, paramObject.e) == 0) && (Float.compare(this.f, paramObject.f) == 0) && (this.g == paramObject.g)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final float f()
  {
    return this.d;
  }
  
  public final float g()
  {
    return this.e;
  }
  
  public final float h()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoTrackConfig(thumbWidth=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", thumbHeight=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", singleShowThumbWidth=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", videoTrackMargin=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", transitionViewWidth=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", transitionViewHeight=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", showTopDurationTag=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.VideoTrackConfig
 * JD-Core Version:    0.7.0.1
 */