package dov.com.tencent.mobileqq.richmedia.mediacodec.tracker;

import android.text.TextUtils;
import android.view.Surface;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;

public class StickerDecodePlayer
  implements TrackingDecoderListener
{
  private int jdField_a_of_type_Int = 0;
  public long a;
  private final DecodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig = new DecodeConfig();
  private SimpleVideoDecoder jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerSimpleVideoDecoder = new SimpleVideoDecoder();
  private TrackingDecoderListener jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener;
  private long b = -1L;
  
  public Surface a()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener != null) {
      return this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener.a();
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 3;
    QLog.d("DecodePlayer", 4, "onDecodeStart");
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener.a();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerSimpleVideoDecoder.a(paramInt);
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    QLog.e("DecodePlayer", 4, "onDecodeError errorCode = " + paramInt, paramThrowable);
    ShortVideoExceptionReporter.a(paramThrowable);
  }
  
  public void a(long paramLong)
  {
    this.b = System.nanoTime();
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener.a(paramLong1, paramLong2);
    }
  }
  
  public void a(Surface paramSurface, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_JavaLangString)) {
      throw new RuntimeException("startPlay failed. videoFilePath is empty.");
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerSimpleVideoDecoder.a();
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerSimpleVideoDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig, paramSurface, this, paramBoolean);
    this.b = System.nanoTime();
  }
  
  public void a(TrackingDecoderListener paramTrackingDecoderListener)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener = paramTrackingDecoderListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("DecodePlayer", 2, "setFilePath: videoFilePath = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Long = VideoCompositeHelper.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_JavaLangString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.b = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    QLog.d("DecodePlayer", 4, "onDecodeRepeat");
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener.a(paramArrayOfByte, paramLong);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 5;
    QLog.d("DecodePlayer", 4, "onDecodeFinish");
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener.b();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = 2;
    QLog.d("DecodePlayer", 4, "onDecodeCancel");
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener.c();
    }
  }
  
  public void d()
  {
    QLog.d("DecodePlayer", 4, "onDecodeRepeat");
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerTrackingDecoderListener.d();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_Int = 6;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerSimpleVideoDecoder.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.StickerDecodePlayer
 * JD-Core Version:    0.7.0.1
 */