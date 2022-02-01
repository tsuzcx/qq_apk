package com.tencent.tkd.topicsdk.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "Ljava/io/Serializable;", "media", "Lcom/tencent/tkd/topicsdk/bean/Media;", "(Lcom/tencent/tkd/topicsdk/bean/Media;)V", "coverPath", "", "getCoverPath", "()Ljava/lang/String;", "setCoverPath", "(Ljava/lang/String;)V", "endMergeTime", "", "getEndMergeTime", "()I", "setEndMergeTime", "(I)V", "filterType", "getFilterType", "setFilterType", "fromPage", "getFromPage", "setFromPage", "initialProgress", "", "getInitialProgress", "()F", "setInitialProgress", "(F)V", "getMedia", "()Lcom/tencent/tkd/topicsdk/bean/Media;", "setMedia", "mergeDuration", "", "getMergeDuration", "()J", "mergePath", "getMergePath", "setMergePath", "realDuration", "getRealDuration", "realPath", "getRealPath", "speedMode", "getSpeedMode", "setSpeedMode", "startMergeTime", "getStartMergeTime", "setStartMergeTime", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class DisplayItem
  implements Serializable
{
  public static final DisplayItem.Companion Companion = new DisplayItem.Companion(null);
  private static final long serialVersionUID = 0L;
  @NotNull
  private String coverPath;
  private int endMergeTime;
  private int filterType;
  private int fromPage;
  private float initialProgress;
  @NotNull
  private Media media;
  @NotNull
  private String mergePath;
  private int speedMode;
  private int startMergeTime;
  
  public DisplayItem(@NotNull Media paramMedia)
  {
    this.media = paramMedia;
    this.coverPath = "";
    this.mergePath = "";
    this.endMergeTime = ((int)this.media.getDuration());
  }
  
  @NotNull
  public final String getCoverPath()
  {
    return this.coverPath;
  }
  
  public final int getEndMergeTime()
  {
    return this.endMergeTime;
  }
  
  public final int getFilterType()
  {
    return this.filterType;
  }
  
  public final int getFromPage()
  {
    return this.fromPage;
  }
  
  public final float getInitialProgress()
  {
    return this.initialProgress;
  }
  
  @NotNull
  public final Media getMedia()
  {
    return this.media;
  }
  
  public final long getMergeDuration()
  {
    if (this.startMergeTime > this.endMergeTime) {
      return this.media.getDuration();
    }
    return this.endMergeTime - this.startMergeTime;
  }
  
  @NotNull
  public final String getMergePath()
  {
    return this.mergePath;
  }
  
  public final long getRealDuration()
  {
    if ((getMergeDuration() > 0L) && (getMergeDuration() < this.media.getDuration())) {
      return getMergeDuration();
    }
    return this.media.getDuration();
  }
  
  @NotNull
  public final String getRealPath()
  {
    if (((CharSequence)this.mergePath).length() > 0) {}
    for (int i = 1; i != 0; i = 0) {
      return this.mergePath;
    }
    return this.media.getFilePath();
  }
  
  public final int getSpeedMode()
  {
    return this.speedMode;
  }
  
  public final int getStartMergeTime()
  {
    return this.startMergeTime;
  }
  
  public final void setCoverPath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.coverPath = paramString;
  }
  
  public final void setEndMergeTime(int paramInt)
  {
    this.endMergeTime = paramInt;
  }
  
  public final void setFilterType(int paramInt)
  {
    this.filterType = paramInt;
  }
  
  public final void setFromPage(int paramInt)
  {
    this.fromPage = paramInt;
  }
  
  public final void setInitialProgress(float paramFloat)
  {
    this.initialProgress = paramFloat;
  }
  
  public final void setMedia(@NotNull Media paramMedia)
  {
    Intrinsics.checkParameterIsNotNull(paramMedia, "<set-?>");
    this.media = paramMedia;
  }
  
  public final void setMergePath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.mergePath = paramString;
  }
  
  public final void setSpeedMode(int paramInt)
  {
    this.speedMode = paramInt;
  }
  
  public final void setStartMergeTime(int paramInt)
  {
    this.startMergeTime = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.DisplayItem
 * JD-Core Version:    0.7.0.1
 */