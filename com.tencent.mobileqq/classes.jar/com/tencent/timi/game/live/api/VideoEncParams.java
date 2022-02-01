package com.tencent.timi.game.live.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/api/VideoEncParams;", "", "videoResolution", "", "videoResolutionMode", "videoFps", "videoBitrate", "minVideoBitrate", "enableAdjustRes", "", "(IIIIIZ)V", "getEnableAdjustRes", "()Z", "setEnableAdjustRes", "(Z)V", "getMinVideoBitrate", "()I", "setMinVideoBitrate", "(I)V", "getVideoBitrate", "setVideoBitrate", "getVideoFps", "setVideoFps", "getVideoResolution", "setVideoResolution", "getVideoResolutionMode", "setVideoResolutionMode", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class VideoEncParams
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private boolean f;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VideoEncParams))
      {
        paramObject = (VideoEncParams)paramObject;
        if ((this.a == paramObject.a) && (this.b == paramObject.b) && (this.c == paramObject.c) && (this.d == paramObject.d) && (this.e == paramObject.e) && (this.f == paramObject.f)) {}
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoEncParams(videoResolution=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", videoResolutionMode=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", videoFps=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", videoBitrate=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", minVideoBitrate=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", enableAdjustRes=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.api.VideoEncParams
 * JD-Core Version:    0.7.0.1
 */