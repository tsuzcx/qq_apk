package com.tencent.tkd.topicsdk.coverselect;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectData;", "Ljava/io/Serializable;", "()V", "coverFrom", "", "getCoverFrom", "()I", "setCoverFrom", "(I)V", "coverPath", "", "getCoverPath", "()Ljava/lang/String;", "setCoverPath", "(Ljava/lang/String;)V", "initialProgress", "", "getInitialProgress", "()F", "setInitialProgress", "(F)V", "videoHeight", "getVideoHeight", "setVideoHeight", "videoPath", "getVideoPath", "setVideoPath", "videoWidth", "getVideoWidth", "setVideoWidth", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CoverSelectData
  implements Serializable
{
  private int coverFrom;
  @NotNull
  private String coverPath = "";
  private float initialProgress;
  private int videoHeight;
  @NotNull
  private String videoPath = "";
  private int videoWidth;
  
  public final int getCoverFrom()
  {
    return this.coverFrom;
  }
  
  @NotNull
  public final String getCoverPath()
  {
    return this.coverPath;
  }
  
  public final float getInitialProgress()
  {
    return this.initialProgress;
  }
  
  public final int getVideoHeight()
  {
    return this.videoHeight;
  }
  
  @NotNull
  public final String getVideoPath()
  {
    return this.videoPath;
  }
  
  public final int getVideoWidth()
  {
    return this.videoWidth;
  }
  
  public final void setCoverFrom(int paramInt)
  {
    this.coverFrom = paramInt;
  }
  
  public final void setCoverPath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.coverPath = paramString;
  }
  
  public final void setInitialProgress(float paramFloat)
  {
    this.initialProgress = paramFloat;
  }
  
  public final void setVideoHeight(int paramInt)
  {
    this.videoHeight = paramInt;
  }
  
  public final void setVideoPath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.videoPath = paramString;
  }
  
  public final void setVideoWidth(int paramInt)
  {
    this.videoWidth = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.coverselect.CoverSelectData
 * JD-Core Version:    0.7.0.1
 */