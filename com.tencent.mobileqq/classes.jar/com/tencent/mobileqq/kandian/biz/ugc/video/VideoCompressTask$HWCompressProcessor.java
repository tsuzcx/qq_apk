package com.tencent.mobileqq.kandian.biz.ugc.video;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter.Processor;
import com.tencent.richmedia.videocompress.VideoConverterConfig;

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
    if (paramInt2 > 0)
    {
      this.jdField_b_of_type_Int = paramInt2;
      return;
    }
    this.jdField_b_of_type_Int = 30;
  }
  
  public VideoConverterConfig getEncodeConfig(int paramInt1, int paramInt2)
  {
    VideoConverterConfig localVideoConverterConfig = new VideoConverterConfig();
    int i = paramInt1;
    if (paramInt1 <= paramInt2) {
      i = paramInt2;
    }
    localVideoConverterConfig.output = this.jdField_a_of_type_JavaLangString;
    paramInt2 = ReadInJoyConstants.jdField_a_of_type_Int;
    paramInt1 = ReadInJoyHelper.p(BaseApplicationImpl.getApplication().getRuntime());
    if (paramInt1 > 0) {
      paramInt2 = paramInt1;
    }
    paramInt1 = 960;
    String str;
    if (i >= 1280)
    {
      str = "720p";
      paramInt1 = 1280;
    }
    else if (i >= 960)
    {
      str = "640p";
    }
    else
    {
      paramInt1 = 640;
      str = "480p";
    }
    float f1 = paramInt2 * 1.0F / 640.0F;
    float f2 = paramInt1;
    localVideoConverterConfig.videoBitRate = ((int)(f1 * f2));
    localVideoConverterConfig.scaleRate = (f2 / i);
    int j = this.jdField_b_of_type_Int;
    if (j > 30) {
      j = 30;
    }
    localVideoConverterConfig.videoFrameRate = j;
    localVideoConverterConfig.beginTime = this.jdField_a_of_type_Long;
    localVideoConverterConfig.endTime = this.jdField_b_of_type_Long;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CompressTask, step: getEncodeConfig()\n quality:");
      localStringBuilder.append(str);
      localStringBuilder.append(", sourceLongEdge:");
      localStringBuilder.append(i);
      localStringBuilder.append(", targetLongEdge:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", scaleRate:");
      localStringBuilder.append(localVideoConverterConfig.scaleRate);
      localStringBuilder.append("\n defaultBitRate:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", videoBitRate:");
      localStringBuilder.append(localVideoConverterConfig.videoBitRate);
      localStringBuilder.append(", videoFrameRate:");
      localStringBuilder.append(localVideoConverterConfig.videoFrameRate);
      localStringBuilder.append("\n setRotation:");
      localStringBuilder.append(localVideoConverterConfig.setRotation);
      localStringBuilder.append(", beginTime:");
      localStringBuilder.append(localVideoConverterConfig.beginTime);
      localStringBuilder.append(", endTime:");
      localStringBuilder.append(localVideoConverterConfig.endTime);
      QLog.d("ReadInJoyUploadVideoCompressTask", 2, localStringBuilder.toString());
    }
    return localVideoConverterConfig;
  }
  
  public void onCancel() {}
  
  public void onFail(Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CompressTask, step: HWCompressProcessor onFailed:");
    localStringBuilder.append(paramThrowable.getMessage());
    QLog.e("ReadInJoyUploadVideoCompressTask", 1, localStringBuilder.toString());
  }
  
  public void onProgress(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoVideoCompressTask.a != null) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoVideoCompressTask.isCancelled())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoVideoCompressTask.a.a(paramInt / 100.0F);
    }
  }
  
  public void onSuccess() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.video.VideoCompressTask.HWCompressProcessor
 * JD-Core Version:    0.7.0.1
 */