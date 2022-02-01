package com.tencent.tkd.topicsdk.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/ImageInfo;", "Ljava/io/Serializable;", "()V", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "hasCompressed", "", "getHasCompressed", "()Z", "setHasCompressed", "(Z)V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "md5", "getMd5", "setMd5", "size", "", "getSize", "()J", "setSize", "(J)V", "url", "getUrl", "setUrl", "width", "getWidth", "setWidth", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class ImageInfo
  implements Serializable
{
  public static final ImageInfo.Companion Companion = new ImageInfo.Companion(null);
  private static final long serialVersionUID = 0L;
  @NotNull
  private String filePath = "";
  private boolean hasCompressed;
  private int height;
  @NotNull
  private String md5 = "";
  private long size;
  @NotNull
  private String url = "";
  private int width;
  
  @NotNull
  public final String getFilePath()
  {
    return this.filePath;
  }
  
  public final boolean getHasCompressed()
  {
    return this.hasCompressed;
  }
  
  public final int getHeight()
  {
    return this.height;
  }
  
  @NotNull
  public final String getMd5()
  {
    return this.md5;
  }
  
  public final long getSize()
  {
    return this.size;
  }
  
  @NotNull
  public final String getUrl()
  {
    return this.url;
  }
  
  public final int getWidth()
  {
    return this.width;
  }
  
  public final void setFilePath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.filePath = paramString;
  }
  
  public final void setHasCompressed(boolean paramBoolean)
  {
    this.hasCompressed = paramBoolean;
  }
  
  public final void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public final void setMd5(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.md5 = paramString;
  }
  
  public final void setSize(long paramLong)
  {
    this.size = paramLong;
  }
  
  public final void setUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.url = paramString;
  }
  
  public final void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.ImageInfo
 * JD-Core Version:    0.7.0.1
 */