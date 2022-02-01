package com.tencent.tkd.topicsdk.bean;

import com.tencent.tkd.topicsdk.common.TimeUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/Media;", "Ljava/io/Serializable;", "type", "Lcom/tencent/tkd/topicsdk/bean/MediaType;", "(Lcom/tencent/tkd/topicsdk/bean/MediaType;)V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "durationStr", "", "getDurationStr", "()Ljava/lang/String;", "filePath", "getFilePath", "setFilePath", "(Ljava/lang/String;)V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "size", "getSize", "setSize", "getType", "()Lcom/tencent/tkd/topicsdk/bean/MediaType;", "setType", "width", "getWidth", "setWidth", "Companion", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class Media
  implements Serializable
{
  public static final Media.Companion Companion = new Media.Companion(null);
  private static final long serialVersionUID = 0L;
  private long duration;
  @NotNull
  private String filePath;
  private int height;
  private long size;
  @NotNull
  private MediaType type;
  private int width;
  
  public Media(@NotNull MediaType paramMediaType)
  {
    this.type = paramMediaType;
    this.filePath = "";
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  @NotNull
  public final String getDurationStr()
  {
    return TimeUtils.a.a(this.duration / 1000);
  }
  
  @NotNull
  public final String getFilePath()
  {
    return this.filePath;
  }
  
  public final int getHeight()
  {
    return this.height;
  }
  
  public final long getSize()
  {
    return this.size;
  }
  
  @NotNull
  public final MediaType getType()
  {
    return this.type;
  }
  
  public final int getWidth()
  {
    return this.width;
  }
  
  public final void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public final void setFilePath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.filePath = paramString;
  }
  
  public final void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public final void setSize(long paramLong)
  {
    this.size = paramLong;
  }
  
  public final void setType(@NotNull MediaType paramMediaType)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaType, "<set-?>");
    this.type = paramMediaType;
  }
  
  public final void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.Media
 * JD-Core Version:    0.7.0.1
 */