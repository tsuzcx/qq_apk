package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;", "", "filePath", "", "(Ljava/lang/String;)V", "value", "", "endTime", "getEndTime", "()I", "setEndTime", "(I)V", "getFilePath", "()Ljava/lang/String;", "startTime", "getStartTime", "setStartTime", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoCaptureView$CaptureVideoInfo
{
  private int jdField_a_of_type_Int;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private int b;
  
  public VideoCaptureView$CaptureVideoInfo(@NotNull String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = 2147483647;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt <= 0) {
      paramInt = 0;
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final void b(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_Int)
    {
      this.b = paramInt;
      return;
    }
    a(0);
    this.b = 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCaptureView.CaptureVideoInfo
 * JD-Core Version:    0.7.0.1
 */