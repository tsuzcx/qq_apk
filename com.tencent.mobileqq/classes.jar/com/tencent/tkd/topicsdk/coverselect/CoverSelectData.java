package com.tencent.tkd.topicsdk.coverselect;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCaptureView.CaptureVideoInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectData;", "Ljava/io/Serializable;", "()V", "captureVideoInfo", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;", "getCaptureVideoInfo", "()Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;", "setCaptureVideoInfo", "(Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;)V", "coverFrom", "", "coverFrom$annotations", "getCoverFrom", "()I", "setCoverFrom", "(I)V", "coverPath", "", "getCoverPath", "()Ljava/lang/String;", "setCoverPath", "(Ljava/lang/String;)V", "coverRatio", "", "getCoverRatio", "()F", "setCoverRatio", "(F)V", "globalPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "getGlobalPublisherConfig", "()Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "setGlobalPublisherConfig", "(Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;)V", "initialProgress", "getInitialProgress", "setInitialProgress", "selectMode", "selectMode$annotations", "getSelectMode", "setSelectMode", "videoHeight", "getVideoHeight", "setVideoHeight", "videoPath", "getVideoPath", "setVideoPath", "videoWidth", "getVideoWidth", "setVideoWidth", "Companion", "CoverSelectFromTab", "CoverSelectMode", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CoverSelectData
  implements Serializable
{
  public static final CoverSelectData.Companion Companion = new CoverSelectData.Companion(null);
  @Nullable
  private VideoCaptureView.CaptureVideoInfo captureVideoInfo;
  private int coverFrom;
  @NotNull
  private String coverPath = "";
  private float coverRatio;
  @Nullable
  private GlobalPublisherConfig globalPublisherConfig;
  private float initialProgress;
  private int selectMode;
  private int videoHeight;
  @NotNull
  private String videoPath = "";
  private int videoWidth;
  
  @Nullable
  public final VideoCaptureView.CaptureVideoInfo getCaptureVideoInfo()
  {
    return this.captureVideoInfo;
  }
  
  public final int getCoverFrom()
  {
    return this.coverFrom;
  }
  
  @NotNull
  public final String getCoverPath()
  {
    return this.coverPath;
  }
  
  public final float getCoverRatio()
  {
    return this.coverRatio;
  }
  
  @Nullable
  public final GlobalPublisherConfig getGlobalPublisherConfig()
  {
    return this.globalPublisherConfig;
  }
  
  public final float getInitialProgress()
  {
    return this.initialProgress;
  }
  
  public final int getSelectMode()
  {
    return this.selectMode;
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
  
  public final void setCaptureVideoInfo(@Nullable VideoCaptureView.CaptureVideoInfo paramCaptureVideoInfo)
  {
    this.captureVideoInfo = paramCaptureVideoInfo;
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
  
  public final void setCoverRatio(float paramFloat)
  {
    this.coverRatio = paramFloat;
  }
  
  public final void setGlobalPublisherConfig(@Nullable GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    this.globalPublisherConfig = paramGlobalPublisherConfig;
  }
  
  public final void setInitialProgress(float paramFloat)
  {
    this.initialProgress = paramFloat;
  }
  
  public final void setSelectMode(int paramInt)
  {
    this.selectMode = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.coverselect.CoverSelectData
 * JD-Core Version:    0.7.0.1
 */