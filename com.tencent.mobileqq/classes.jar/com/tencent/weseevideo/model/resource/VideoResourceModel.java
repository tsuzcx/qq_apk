package com.tencent.weseevideo.model.resource;

import android.text.TextUtils;
import com.tencent.weseevideo.model.utils.FileUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/resource/VideoResourceModel;", "Ljava/io/Serializable;", "path", "", "scaleDuration", "", "type", "", "sourceTimeStartUs", "sourceTimeDurationUs", "selectTimeStartUs", "selectTimeDurationUs", "cutTimeStart", "cutTimeDuration", "width", "height", "rotate", "extraParams", "Lcom/tencent/weseevideo/model/resource/ResourceExtra;", "(Ljava/lang/String;JIJJJJJJIIILcom/tencent/weseevideo/model/resource/ResourceExtra;)V", "getCutTimeDuration", "()J", "setCutTimeDuration", "(J)V", "getCutTimeStart", "setCutTimeStart", "extraParams$annotations", "()V", "getExtraParams", "()Lcom/tencent/weseevideo/model/resource/ResourceExtra;", "setExtraParams", "(Lcom/tencent/weseevideo/model/resource/ResourceExtra;)V", "getHeight", "()I", "setHeight", "(I)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getRotate", "setRotate", "selectTimeDuration", "getSelectTimeDuration", "getSelectTimeDurationUs", "setSelectTimeDurationUs", "selectTimeStart", "getSelectTimeStart", "getSelectTimeStartUs", "setSelectTimeStartUs", "sourceTimeDuration", "getSourceTimeDuration", "getSourceTimeDurationUs", "setSourceTimeDurationUs", "sourceTimeStart", "getSourceTimeStart", "getSourceTimeStartUs", "setSourceTimeStartUs", "speed", "", "getSpeed", "()F", "getType", "setType", "getWidth", "setWidth", "checkEffective", "", "clone", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "copyBy", "equals", "other", "", "getScaleDuration", "hashCode", "setScaleDuration", "", "duration", "toString", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class VideoResourceModel
  implements Serializable
{
  private long cutTimeDuration;
  private long cutTimeStart;
  @Nullable
  private transient ResourceExtra extraParams;
  private int height;
  @Nullable
  private String path;
  private int rotate;
  private long scaleDuration;
  private long selectTimeDurationUs;
  private long selectTimeStartUs;
  private long sourceTimeDurationUs;
  private long sourceTimeStartUs;
  private int type;
  private int width;
  
  public VideoResourceModel()
  {
    this(null, 0L, 0, 0L, 0L, 0L, 0L, 0L, 0L, 0, 0, 0, null, 8191, null);
  }
  
  public VideoResourceModel(@Nullable String paramString, long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt2, int paramInt3, int paramInt4, @Nullable ResourceExtra paramResourceExtra)
  {
    this.path = paramString;
    this.scaleDuration = paramLong1;
    this.type = paramInt1;
    this.sourceTimeStartUs = paramLong2;
    this.sourceTimeDurationUs = paramLong3;
    this.selectTimeStartUs = paramLong4;
    this.selectTimeDurationUs = paramLong5;
    this.cutTimeStart = paramLong6;
    this.cutTimeDuration = paramLong7;
    this.width = paramInt2;
    this.height = paramInt3;
    this.rotate = paramInt4;
    this.extraParams = paramResourceExtra;
  }
  
  private final long component2()
  {
    return this.scaleDuration;
  }
  
  public final boolean checkEffective()
  {
    return (!TextUtils.isEmpty((CharSequence)this.path)) && (FileUtils.exists(this.path));
  }
  
  @NotNull
  public final VideoResourceModel clone()
  {
    return copy$default(this, null, 0L, 0, 0L, 0L, 0L, 0L, 0L, 0L, 0, 0, 0, null, 8191, null);
  }
  
  @Nullable
  public final String component1()
  {
    return this.path;
  }
  
  public final int component10()
  {
    return this.width;
  }
  
  public final int component11()
  {
    return this.height;
  }
  
  public final int component12()
  {
    return this.rotate;
  }
  
  @Nullable
  public final ResourceExtra component13()
  {
    return this.extraParams;
  }
  
  public final int component3()
  {
    return this.type;
  }
  
  public final long component4()
  {
    return this.sourceTimeStartUs;
  }
  
  public final long component5()
  {
    return this.sourceTimeDurationUs;
  }
  
  public final long component6()
  {
    return this.selectTimeStartUs;
  }
  
  public final long component7()
  {
    return this.selectTimeDurationUs;
  }
  
  public final long component8()
  {
    return this.cutTimeStart;
  }
  
  public final long component9()
  {
    return this.cutTimeDuration;
  }
  
  @NotNull
  public final VideoResourceModel copy(@Nullable String paramString, long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt2, int paramInt3, int paramInt4, @Nullable ResourceExtra paramResourceExtra)
  {
    return new VideoResourceModel(paramString, paramLong1, paramInt1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramInt2, paramInt3, paramInt4, paramResourceExtra);
  }
  
  @NotNull
  public final VideoResourceModel copyBy(@Nullable String paramString)
  {
    return copy$default(this, paramString, 0L, 0, 0L, 0L, 0L, 0L, 0L, 0L, 0, 0, 0, null, 8190, null);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VideoResourceModel))
      {
        paramObject = (VideoResourceModel)paramObject;
        if ((Intrinsics.areEqual(this.path, paramObject.path)) && (this.scaleDuration == paramObject.scaleDuration) && (this.type == paramObject.type) && (this.sourceTimeStartUs == paramObject.sourceTimeStartUs) && (this.sourceTimeDurationUs == paramObject.sourceTimeDurationUs) && (this.selectTimeStartUs == paramObject.selectTimeStartUs) && (this.selectTimeDurationUs == paramObject.selectTimeDurationUs) && (this.cutTimeStart == paramObject.cutTimeStart) && (this.cutTimeDuration == paramObject.cutTimeDuration) && (this.width == paramObject.width) && (this.height == paramObject.height) && (this.rotate == paramObject.rotate) && (Intrinsics.areEqual(this.extraParams, paramObject.extraParams))) {}
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
  
  @Nullable
  public final ResourceExtra getExtraParams()
  {
    return this.extraParams;
  }
  
  public final int getHeight()
  {
    return this.height;
  }
  
  @Nullable
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
    long l2 = this.scaleDuration;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = getSelectTimeDuration();
    }
    return l1;
  }
  
  public final long getSelectTimeDuration()
  {
    return this.selectTimeDurationUs / 1000;
  }
  
  public final long getSelectTimeDurationUs()
  {
    return this.selectTimeDurationUs;
  }
  
  public final long getSelectTimeStart()
  {
    return this.selectTimeStartUs / 1000;
  }
  
  public final long getSelectTimeStartUs()
  {
    return this.selectTimeStartUs;
  }
  
  public final long getSourceTimeDuration()
  {
    return this.sourceTimeDurationUs / 1000;
  }
  
  public final long getSourceTimeDurationUs()
  {
    return this.sourceTimeDurationUs;
  }
  
  public final long getSourceTimeStart()
  {
    return this.sourceTimeStartUs / 1000;
  }
  
  public final long getSourceTimeStartUs()
  {
    return this.sourceTimeStartUs;
  }
  
  public final float getSpeed()
  {
    if (getScaleDuration() == 0L) {
      return 1.0F;
    }
    return (float)getSelectTimeDuration() / (float)getScaleDuration();
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
    Object localObject = this.path;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    long l = this.scaleDuration;
    int k = (int)(l ^ l >>> 32);
    int m = this.type;
    l = this.sourceTimeStartUs;
    int n = (int)(l ^ l >>> 32);
    l = this.sourceTimeDurationUs;
    int i1 = (int)(l ^ l >>> 32);
    l = this.selectTimeStartUs;
    int i2 = (int)(l ^ l >>> 32);
    l = this.selectTimeDurationUs;
    int i3 = (int)(l ^ l >>> 32);
    l = this.cutTimeStart;
    int i4 = (int)(l ^ l >>> 32);
    l = this.cutTimeDuration;
    int i5 = (int)(l ^ l >>> 32);
    int i6 = this.width;
    int i7 = this.height;
    int i8 = this.rotate;
    localObject = this.extraParams;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return (((((((((((i * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + j;
  }
  
  public final void setCutTimeDuration(long paramLong)
  {
    this.cutTimeDuration = paramLong;
  }
  
  public final void setCutTimeStart(long paramLong)
  {
    this.cutTimeStart = paramLong;
  }
  
  public final void setExtraParams(@Nullable ResourceExtra paramResourceExtra)
  {
    this.extraParams = paramResourceExtra;
  }
  
  public final void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public final void setPath(@Nullable String paramString)
  {
    this.path = paramString;
  }
  
  public final void setRotate(int paramInt)
  {
    this.rotate = paramInt;
  }
  
  public final void setScaleDuration(long paramLong)
  {
    this.scaleDuration = paramLong;
  }
  
  public final void setSelectTimeDurationUs(long paramLong)
  {
    this.selectTimeDurationUs = paramLong;
  }
  
  public final void setSelectTimeStartUs(long paramLong)
  {
    this.selectTimeStartUs = paramLong;
  }
  
  public final void setSourceTimeDurationUs(long paramLong)
  {
    this.sourceTimeDurationUs = paramLong;
  }
  
  public final void setSourceTimeStartUs(long paramLong)
  {
    this.sourceTimeStartUs = paramLong;
  }
  
  public final void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public final void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoResourceModel(path=");
    localStringBuilder.append(this.path);
    localStringBuilder.append(", scaleDuration=");
    localStringBuilder.append(this.scaleDuration);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", sourceTimeStartUs=");
    localStringBuilder.append(this.sourceTimeStartUs);
    localStringBuilder.append(", sourceTimeDurationUs=");
    localStringBuilder.append(this.sourceTimeDurationUs);
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
    localStringBuilder.append(", extraParams=");
    localStringBuilder.append(this.extraParams);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.resource.VideoResourceModel
 * JD-Core Version:    0.7.0.1
 */