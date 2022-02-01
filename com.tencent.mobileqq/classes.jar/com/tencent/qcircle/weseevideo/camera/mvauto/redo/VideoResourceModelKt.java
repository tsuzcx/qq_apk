package com.tencent.qcircle.weseevideo.camera.mvauto.redo;

import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/weseevideo/camera/mvauto/redo/VideoResourceModelKt;", "", "path", "", "type", "", "scaleDuration", "", "sourceTimeStart", "sourceTimeDuration", "sourceTimeStartUs", "sourceTimeDurationUs", "selectTimeStart", "selectTimeDuration", "selectTimeStartUs", "selectTimeDurationUs", "cutTimeStart", "cutTimeDuration", "width", "height", "rotate", "(Ljava/lang/String;IJJJJJJJJJJJIII)V", "getCutTimeDuration", "()J", "getCutTimeStart", "getHeight", "()I", "getPath", "()Ljava/lang/String;", "getRotate", "getScaleDuration", "scaleSpeed", "", "getScaleSpeed", "()F", "getSelectTimeDuration", "getSelectTimeDurationUs", "selectTimeEndUs", "getSelectTimeEndUs", "getSelectTimeStart", "getSelectTimeStartUs", "getSourceTimeDuration", "getSourceTimeDurationUs", "getSourceTimeStart", "getSourceTimeStartUs", "getType", "getWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "convert", "Lcom/tencent/qcircle/weseevideo/model/resource/VideoResourceModel;", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class VideoResourceModelKt
{
  public static final VideoResourceModelKt.Companion Companion = new VideoResourceModelKt.Companion(null);
  private final long cutTimeDuration;
  private final long cutTimeStart;
  private final int height;
  @NotNull
  private final String path;
  private final int rotate;
  private final long scaleDuration;
  private final float scaleSpeed;
  private final long selectTimeDuration;
  private final long selectTimeDurationUs;
  private final long selectTimeEndUs;
  private final long selectTimeStart;
  private final long selectTimeStartUs;
  private final long sourceTimeDuration;
  private final long sourceTimeDurationUs;
  private final long sourceTimeStart;
  private final long sourceTimeStartUs;
  private final int type;
  private final int width;
  
  public VideoResourceModelKt(@NotNull String paramString, int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, int paramInt2, int paramInt3, int paramInt4)
  {
    this.path = paramString;
    this.type = paramInt1;
    this.scaleDuration = paramLong1;
    this.sourceTimeStart = paramLong2;
    this.sourceTimeDuration = paramLong3;
    this.sourceTimeStartUs = paramLong4;
    this.sourceTimeDurationUs = paramLong5;
    this.selectTimeStart = paramLong6;
    this.selectTimeDuration = paramLong7;
    this.selectTimeStartUs = paramLong8;
    this.selectTimeDurationUs = paramLong9;
    this.cutTimeStart = paramLong10;
    this.cutTimeDuration = paramLong11;
    this.width = paramInt2;
    this.height = paramInt3;
    this.rotate = paramInt4;
    paramLong1 = this.selectTimeDuration;
    float f = 1.0F;
    if (paramLong1 != 0L) {
      f = (float)paramLong1 * 1.0F / (float)this.scaleDuration;
    }
    this.scaleSpeed = f;
    this.selectTimeEndUs = (((float)(this.selectTimeStartUs + this.selectTimeDurationUs) / this.scaleSpeed));
  }
  
  @NotNull
  public final String component1()
  {
    return this.path;
  }
  
  public final long component10()
  {
    return this.selectTimeStartUs;
  }
  
  public final long component11()
  {
    return this.selectTimeDurationUs;
  }
  
  public final long component12()
  {
    return this.cutTimeStart;
  }
  
  public final long component13()
  {
    return this.cutTimeDuration;
  }
  
  public final int component14()
  {
    return this.width;
  }
  
  public final int component15()
  {
    return this.height;
  }
  
  public final int component16()
  {
    return this.rotate;
  }
  
  public final int component2()
  {
    return this.type;
  }
  
  public final long component3()
  {
    return this.scaleDuration;
  }
  
  public final long component4()
  {
    return this.sourceTimeStart;
  }
  
  public final long component5()
  {
    return this.sourceTimeDuration;
  }
  
  public final long component6()
  {
    return this.sourceTimeStartUs;
  }
  
  public final long component7()
  {
    return this.sourceTimeDurationUs;
  }
  
  public final long component8()
  {
    return this.selectTimeStart;
  }
  
  public final long component9()
  {
    return this.selectTimeDuration;
  }
  
  @NotNull
  public final VideoResourceModel convert()
  {
    String str = this.path;
    int i = this.type;
    return new VideoResourceModel(str, this.scaleDuration, i, this.sourceTimeStartUs, this.sourceTimeDurationUs, this.selectTimeStartUs, this.selectTimeDurationUs, this.cutTimeStart, this.cutTimeDuration, this.width, this.height, this.rotate, null, 4096, null);
  }
  
  @NotNull
  public final VideoResourceModelKt copy(@NotNull String paramString, int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, int paramInt2, int paramInt3, int paramInt4)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    return new VideoResourceModelKt(paramString, paramInt1, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramLong8, paramLong9, paramLong10, paramLong11, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VideoResourceModelKt))
      {
        paramObject = (VideoResourceModelKt)paramObject;
        if ((Intrinsics.areEqual(this.path, paramObject.path)) && (this.type == paramObject.type) && (this.scaleDuration == paramObject.scaleDuration) && (this.sourceTimeStart == paramObject.sourceTimeStart) && (this.sourceTimeDuration == paramObject.sourceTimeDuration) && (this.sourceTimeStartUs == paramObject.sourceTimeStartUs) && (this.sourceTimeDurationUs == paramObject.sourceTimeDurationUs) && (this.selectTimeStart == paramObject.selectTimeStart) && (this.selectTimeDuration == paramObject.selectTimeDuration) && (this.selectTimeStartUs == paramObject.selectTimeStartUs) && (this.selectTimeDurationUs == paramObject.selectTimeDurationUs) && (this.cutTimeStart == paramObject.cutTimeStart) && (this.cutTimeDuration == paramObject.cutTimeDuration) && (this.width == paramObject.width) && (this.height == paramObject.height) && (this.rotate == paramObject.rotate)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final long getCutTimeDuration()
  {
    return this.cutTimeDuration;
  }
  
  public final long getCutTimeStart()
  {
    return this.cutTimeStart;
  }
  
  public final int getHeight()
  {
    return this.height;
  }
  
  @NotNull
  public final String getPath()
  {
    return this.path;
  }
  
  public final int getRotate()
  {
    return this.rotate;
  }
  
  public final long getScaleDuration()
  {
    return this.scaleDuration;
  }
  
  public final float getScaleSpeed()
  {
    return this.scaleSpeed;
  }
  
  public final long getSelectTimeDuration()
  {
    return this.selectTimeDuration;
  }
  
  public final long getSelectTimeDurationUs()
  {
    return this.selectTimeDurationUs;
  }
  
  public final long getSelectTimeEndUs()
  {
    return this.selectTimeEndUs;
  }
  
  public final long getSelectTimeStart()
  {
    return this.selectTimeStart;
  }
  
  public final long getSelectTimeStartUs()
  {
    return this.selectTimeStartUs;
  }
  
  public final long getSourceTimeDuration()
  {
    return this.sourceTimeDuration;
  }
  
  public final long getSourceTimeDurationUs()
  {
    return this.sourceTimeDurationUs;
  }
  
  public final long getSourceTimeStart()
  {
    return this.sourceTimeStart;
  }
  
  public final long getSourceTimeStartUs()
  {
    return this.sourceTimeStartUs;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public final int getWidth()
  {
    return this.width;
  }
  
  public int hashCode()
  {
    String str = this.path;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    int j = this.type;
    long l = this.scaleDuration;
    int k = (int)(l ^ l >>> 32);
    l = this.sourceTimeStart;
    int m = (int)(l ^ l >>> 32);
    l = this.sourceTimeDuration;
    int n = (int)(l ^ l >>> 32);
    l = this.sourceTimeStartUs;
    int i1 = (int)(l ^ l >>> 32);
    l = this.sourceTimeDurationUs;
    int i2 = (int)(l ^ l >>> 32);
    l = this.selectTimeStart;
    int i3 = (int)(l ^ l >>> 32);
    l = this.selectTimeDuration;
    int i4 = (int)(l ^ l >>> 32);
    l = this.selectTimeStartUs;
    int i5 = (int)(l ^ l >>> 32);
    l = this.selectTimeDurationUs;
    int i6 = (int)(l ^ l >>> 32);
    l = this.cutTimeStart;
    int i7 = (int)(l ^ l >>> 32);
    l = this.cutTimeDuration;
    return ((((((((((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + (int)(l ^ l >>> 32)) * 31 + this.width) * 31 + this.height) * 31 + this.rotate;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoResourceModelKt(path=");
    localStringBuilder.append(this.path);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", scaleDuration=");
    localStringBuilder.append(this.scaleDuration);
    localStringBuilder.append(", sourceTimeStart=");
    localStringBuilder.append(this.sourceTimeStart);
    localStringBuilder.append(", sourceTimeDuration=");
    localStringBuilder.append(this.sourceTimeDuration);
    localStringBuilder.append(", sourceTimeStartUs=");
    localStringBuilder.append(this.sourceTimeStartUs);
    localStringBuilder.append(", sourceTimeDurationUs=");
    localStringBuilder.append(this.sourceTimeDurationUs);
    localStringBuilder.append(", selectTimeStart=");
    localStringBuilder.append(this.selectTimeStart);
    localStringBuilder.append(", selectTimeDuration=");
    localStringBuilder.append(this.selectTimeDuration);
    localStringBuilder.append(", selectTimeStartUs=");
    localStringBuilder.append(this.selectTimeStartUs);
    localStringBuilder.append(", selectTimeDurationUs=");
    localStringBuilder.append(this.selectTimeDurationUs);
    localStringBuilder.append(", cutTimeStart=");
    localStringBuilder.append(this.cutTimeStart);
    localStringBuilder.append(", cutTimeDuration=");
    localStringBuilder.append(this.cutTimeDuration);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append(", rotate=");
    localStringBuilder.append(this.rotate);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.camera.mvauto.redo.VideoResourceModelKt
 * JD-Core Version:    0.7.0.1
 */