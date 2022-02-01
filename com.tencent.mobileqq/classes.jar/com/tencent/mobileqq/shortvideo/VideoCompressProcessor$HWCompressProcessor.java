package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter.Processor;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import java.lang.ref.WeakReference;

class VideoCompressProcessor$HWCompressProcessor
  implements VideoConverter.Processor
{
  VideoCompressConfig.CompressInfo jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressConfig$CompressInfo;
  VideoCompressProcessor.HWCompressUpdateListener jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$HWCompressUpdateListener;
  final String jdField_a_of_type_JavaLangString;
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  final String b;
  
  VideoCompressProcessor$HWCompressProcessor(WeakReference<QQAppInterface> paramWeakReference, String paramString1, String paramString2, VideoCompressConfig.CompressInfo paramCompressInfo, VideoCompressProcessor.HWCompressUpdateListener paramHWCompressUpdateListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$HWCompressUpdateListener = paramHWCompressUpdateListener;
    if (paramString2 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressConfig$CompressInfo = paramCompressInfo;
      return;
    }
    throw new IllegalArgumentException("null == outputFilePath");
  }
  
  public VideoConverterConfig getEncodeConfig(int paramInt1, int paramInt2)
  {
    VideoConverterConfig localVideoConverterConfig = new VideoConverterConfig();
    localVideoConverterConfig.output = this.jdField_a_of_type_JavaLangString;
    localVideoConverterConfig.scaleRate = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressConfig$CompressInfo.jdField_a_of_type_Float;
    localVideoConverterConfig.videoFrameRate = ((int)this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressConfig$CompressInfo.b);
    localVideoConverterConfig.videoBitRate = ((int)this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressConfig$CompressInfo.jdField_a_of_type_Long);
    return localVideoConverterConfig;
  }
  
  public void onCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onCanceled!");
    }
    VideoCompressProcessor.HWCompressUpdateListener localHWCompressUpdateListener = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$HWCompressUpdateListener;
    if (localHWCompressUpdateListener != null) {
      localHWCompressUpdateListener.a(3);
    }
  }
  
  public void onFail(Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onFailed");
    }
    paramThrowable = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$HWCompressUpdateListener;
    if (paramThrowable != null) {
      paramThrowable.a(2);
    }
  }
  
  public void onProgress(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CompressTask, step: HWCompressProcessor onProgress:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("VideoCompressProcessor", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$HWCompressUpdateListener;
    if ((localObject != null) && (paramInt >= 0) && (paramInt <= 10000)) {
      ((VideoCompressProcessor.HWCompressUpdateListener)localObject).a(paramInt / 10000.0F);
    }
  }
  
  public void onSuccess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onSucceed");
    }
    VideoCompressProcessor.HWCompressUpdateListener localHWCompressUpdateListener = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$HWCompressUpdateListener;
    if (localHWCompressUpdateListener != null) {
      localHWCompressUpdateListener.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.VideoCompressProcessor.HWCompressProcessor
 * JD-Core Version:    0.7.0.1
 */