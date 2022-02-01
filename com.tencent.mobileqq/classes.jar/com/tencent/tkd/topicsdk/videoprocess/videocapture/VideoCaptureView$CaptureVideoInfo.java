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
  
  public final int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCaptureView.CaptureVideoInfo
 * JD-Core Version:    0.7.0.1
 */