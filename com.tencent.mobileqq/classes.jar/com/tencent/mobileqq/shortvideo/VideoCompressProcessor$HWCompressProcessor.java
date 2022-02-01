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
    if (paramString2 == null) {
      throw new IllegalArgumentException("null == outputFilePath");
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressConfig$CompressInfo = paramCompressInfo;
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
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$HWCompressUpdateListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$HWCompressUpdateListener.a(3);
    }
  }
  
  public void onFail(Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onFailed");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$HWCompressUpdateListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$HWCompressUpdateListener.a(2);
    }
  }
  
  public void onProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onProgress:" + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$HWCompressUpdateListener != null) && (paramInt >= 0) && (paramInt <= 10000)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$HWCompressUpdateListener.a(paramInt / 10000.0F);
    }
  }
  
  public void onSuccess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onSucceed");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$HWCompressUpdateListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$HWCompressUpdateListener.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.VideoCompressProcessor.HWCompressProcessor
 * JD-Core Version:    0.7.0.1
 */