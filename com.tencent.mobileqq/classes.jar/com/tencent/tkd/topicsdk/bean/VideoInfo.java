package com.tencent.tkd.topicsdk.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/VideoInfo;", "Ljava/io/Serializable;", "()V", "backupCoverPath", "", "getBackupCoverPath", "()Ljava/lang/String;", "setBackupCoverPath", "(Ljava/lang/String;)V", "compressPath", "getCompressPath", "setCompressPath", "compressProgress", "", "getCompressProgress", "()I", "setCompressProgress", "(I)V", "coverFrom", "getCoverFrom", "setCoverFrom", "coverHeight", "getCoverHeight", "setCoverHeight", "coverPath", "getCoverPath", "setCoverPath", "coverProgress", "getCoverProgress", "setCoverProgress", "coverUrl", "getCoverUrl", "setCoverUrl", "coverWidth", "getCoverWidth", "setCoverWidth", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "fileMd5", "getFileMd5", "setFileMd5", "filePath", "getFilePath", "setFilePath", "fileSha1", "getFileSha1", "setFileSha1", "fileSize", "getFileSize", "setFileSize", "height", "getHeight", "setHeight", "needCompress", "", "getNeedCompress", "()Z", "setNeedCompress", "(Z)V", "progress", "getProgress", "url", "getUrl", "setUrl", "videoProgress", "getVideoProgress", "setVideoProgress", "width", "getWidth", "setWidth", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoInfo
  implements Serializable
{
  public static final int COVER_FROM_DEFAULT = 1;
  public static final int COVER_FROM_SELECT = 2;
  public static final VideoInfo.Companion Companion = new VideoInfo.Companion(null);
  private static int a = 3;
  private static int b;
  private static int c = 1;
  private static int d = 2;
  private static int e = 3;
  private static int f = 4;
  private static int g;
  private static int h = 1;
  private static int i = 2;
  private static final long serialVersionUID = 0L;
  @NotNull
  private String backupCoverPath = "";
  @NotNull
  private String compressPath = "";
  private int compressProgress;
  private int coverFrom = 1;
  private int coverHeight;
  @NotNull
  private String coverPath = "";
  private int coverProgress;
  @NotNull
  private String coverUrl = "";
  private int coverWidth;
  private long duration;
  @NotNull
  private String fileMd5 = "";
  @NotNull
  private String filePath = "";
  @NotNull
  private String fileSha1 = "";
  private long fileSize;
  private int height;
  private boolean needCompress;
  @NotNull
  private String url = "";
  private long videoProgress;
  private int width;
  
  @NotNull
  public final String getBackupCoverPath()
  {
    return this.backupCoverPath;
  }
  
  @NotNull
  public final String getCompressPath()
  {
    return this.compressPath;
  }
  
  public final int getCompressProgress()
  {
    return this.compressProgress;
  }
  
  public final int getCoverFrom()
  {
    return this.coverFrom;
  }
  
  public final int getCoverHeight()
  {
    return this.coverHeight;
  }
  
  @NotNull
  public final String getCoverPath()
  {
    return this.coverPath;
  }
  
  public final int getCoverProgress()
  {
    return this.coverProgress;
  }
  
  @NotNull
  public final String getCoverUrl()
  {
    return this.coverUrl;
  }
  
  public final int getCoverWidth()
  {
    return this.coverWidth;
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  @NotNull
  public final String getFileMd5()
  {
    return this.fileMd5;
  }
  
  @NotNull
  public final String getFilePath()
  {
    return this.filePath;
  }
  
  @NotNull
  public final String getFileSha1()
  {
    return this.fileSha1;
  }
  
  public final long getFileSize()
  {
    return this.fileSize;
  }
  
  public final int getHeight()
  {
    return this.height;
  }
  
  public final boolean getNeedCompress()
  {
    return this.needCompress;
  }
  
  public final long getProgress()
  {
    long l1;
    long l2;
    if (this.needCompress)
    {
      l1 = this.coverProgress * 5 / 100 + this.compressProgress * 45 / 100;
      l2 = this.videoProgress * 50 / 100;
    }
    else
    {
      l1 = this.coverProgress * 5 / 100;
      l2 = this.videoProgress * 95 / 100;
    }
    return l1 + l2;
  }
  
  @NotNull
  public final String getUrl()
  {
    return this.url;
  }
  
  public final long getVideoProgress()
  {
    return this.videoProgress;
  }
  
  public final int getWidth()
  {
    return this.width;
  }
  
  public final void setBackupCoverPath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.backupCoverPath = paramString;
  }
  
  public final void setCompressPath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.compressPath = paramString;
  }
  
  public final void setCompressProgress(int paramInt)
  {
    this.compressProgress = paramInt;
  }
  
  public final void setCoverFrom(int paramInt)
  {
    this.coverFrom = paramInt;
  }
  
  public final void setCoverHeight(int paramInt)
  {
    this.coverHeight = paramInt;
  }
  
  public final void setCoverPath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.coverPath = paramString;
  }
  
  public final void setCoverProgress(int paramInt)
  {
    this.coverProgress = paramInt;
  }
  
  public final void setCoverUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.coverUrl = paramString;
  }
  
  public final void setCoverWidth(int paramInt)
  {
    this.coverWidth = paramInt;
  }
  
  public final void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public final void setFileMd5(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.fileMd5 = paramString;
  }
  
  public final void setFilePath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.filePath = paramString;
  }
  
  public final void setFileSha1(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.fileSha1 = paramString;
  }
  
  public final void setFileSize(long paramLong)
  {
    this.fileSize = paramLong;
  }
  
  public final void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public final void setNeedCompress(boolean paramBoolean)
  {
    this.needCompress = paramBoolean;
  }
  
  public final void setUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.url = paramString;
  }
  
  public final void setVideoProgress(long paramLong)
  {
    this.videoProgress = paramLong;
  }
  
  public final void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.VideoInfo
 * JD-Core Version:    0.7.0.1
 */