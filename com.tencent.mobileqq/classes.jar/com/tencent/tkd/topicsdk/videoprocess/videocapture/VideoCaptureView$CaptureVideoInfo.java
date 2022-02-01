package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;", "", "filePath", "", "(Ljava/lang/String;)V", "coverRatio", "", "getCoverRatio", "()F", "setCoverRatio", "(F)V", "value", "", "endTime", "getEndTime", "()I", "setEndTime", "(I)V", "getFilePath", "()Ljava/lang/String;", "startTime", "getStartTime", "setStartTime", "videoHeight", "getVideoHeight", "setVideoHeight", "videoWidth", "getVideoWidth", "setVideoWidth", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoCaptureView$CaptureVideoInfo
{
  private int a;
  private int b;
  private int c;
  private int d;
  private float e;
  @NotNull
  private final String f;
  
  public VideoCaptureView$CaptureVideoInfo(@NotNull String paramString)
  {
    this.f = paramString;
    this.b = 2147483647;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final void a(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt <= 0) {
      paramInt = 0;
    }
    this.a = paramInt;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final void b(int paramInt)
  {
    if (paramInt > this.a)
    {
      this.b = paramInt;
      return;
    }
    a(0);
    this.b = 2147483647;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final int d()
  {
    return this.d;
  }
  
  public final void d(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final float e()
  {
    return this.e;
  }
  
  @NotNull
  public final String f()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCaptureView.CaptureVideoInfo
 * JD-Core Version:    0.7.0.1
 */