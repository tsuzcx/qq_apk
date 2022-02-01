package dov.com.tencent.mobileqq.shortvideo.mediadevice;

import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import dov.com.tencent.mobileqq.shortvideo.common.TCTimer;
import dov.com.tencent.mobileqq.shortvideo.error.ErrorCenter;

public class RecordManager
{
  public static RecordManager a;
  public static String a;
  private TCTimer a;
  
  static
  {
    jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceRecordManager = new RecordManager();
  }
  
  private RecordManager()
  {
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  public static RecordManager a()
  {
    return jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceRecordManager;
  }
  
  public AVCodec a()
  {
    return AVCodec.get();
  }
  
  public TCTimer a()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoCommonTCTimer == null) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoCommonTCTimer = new TCTimer(40, CodecParam.RECORD_MAX_TIME);
    }
    return this.jdField_a_of_type_DovComTencentMobileqqShortvideoCommonTCTimer;
  }
  
  public ErrorCenter a()
  {
    return ErrorCenter.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.mediadevice.RecordManager
 * JD-Core Version:    0.7.0.1
 */