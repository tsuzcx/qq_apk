package com.tencent.mobileqq.kandian.base.video.compress;

import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter.Processor;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import java.io.File;

class VideoCompressTask$HWCompressProcessor
  implements VideoConverter.Processor
{
  final int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  final String jdField_a_of_type_JavaLangString;
  final int jdField_b_of_type_Int;
  final long jdField_b_of_type_Long;
  
  VideoCompressTask$HWCompressProcessor(VideoCompressTask paramVideoCompressTask, String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    if (paramInt2 > 0) {
      this.jdField_b_of_type_Int = paramInt2;
    } else {
      this.jdField_b_of_type_Int = 30;
    }
    if (paramString != null) {
      return;
    }
    throw new IllegalArgumentException("null == outputFilePath");
  }
  
  private void a()
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
  }
  
  public VideoConverterConfig getEncodeConfig(int paramInt1, int paramInt2)
  {
    VideoConverterConfig localVideoConverterConfig = new VideoConverterConfig();
    localVideoConverterConfig.output = this.jdField_a_of_type_JavaLangString;
    long l = VideoCompressUtil.a(paramInt1, paramInt2);
    int i = VideoCompressUtil.a(paramInt1, paramInt2);
    localVideoConverterConfig.videoBitRate = ((int)l);
    paramInt2 = Math.min(paramInt1, paramInt2);
    localVideoConverterConfig.scaleRate = (i / paramInt2);
    paramInt1 = this.jdField_b_of_type_Int;
    if (paramInt1 > 30) {
      paramInt1 = 30;
    }
    localVideoConverterConfig.videoFrameRate = paramInt1;
    localVideoConverterConfig.beginTime = this.jdField_a_of_type_Long;
    localVideoConverterConfig.endTime = this.jdField_b_of_type_Long;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CompressTask, step: getEncodeConfig()\n  sourceShortEdge:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", dstResolution:");
      localStringBuilder.append(i);
      localStringBuilder.append(", scaleRate:");
      localStringBuilder.append(localVideoConverterConfig.scaleRate);
      localStringBuilder.append("\n  targetVideoBitRate:");
      localStringBuilder.append(localVideoConverterConfig.videoBitRate);
      localStringBuilder.append(", videoFrameRate:");
      localStringBuilder.append(localVideoConverterConfig.videoFrameRate);
      localStringBuilder.append("\n setRotation:");
      localStringBuilder.append(localVideoConverterConfig.setRotation);
      localStringBuilder.append(", beginTime:");
      localStringBuilder.append(localVideoConverterConfig.beginTime);
      localStringBuilder.append(", endTime:");
      localStringBuilder.append(localVideoConverterConfig.endTime);
      QLog.d("VideoCompressTask", 2, localStringBuilder.toString());
    }
    return localVideoConverterConfig;
  }
  
  public void onCancel()
  {
    QLog.e("VideoCompressTask", 1, "CompressTask, step: HWCompressProcessor onCanceled:");
    a();
    if (VideoCompressTask.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoCompressTask) != null) {
      VideoCompressTask.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoCompressTask).a(6, null, null);
    }
  }
  
  public void onFail(Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CompressTask, step: HWCompressProcessor onFailed:");
    localStringBuilder.append(paramThrowable.getMessage());
    QLog.e("VideoCompressTask", 1, localStringBuilder.toString());
  }
  
  public void onProgress(int paramInt)
  {
    if ((VideoCompressTask.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoCompressTask) != null) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoCompressTask.isCancelled())) {
      VideoCompressTask.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoCompressTask).a(paramInt / 100.0F);
    }
  }
  
  public void onSuccess() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.compress.VideoCompressTask.HWCompressProcessor
 * JD-Core Version:    0.7.0.1
 */