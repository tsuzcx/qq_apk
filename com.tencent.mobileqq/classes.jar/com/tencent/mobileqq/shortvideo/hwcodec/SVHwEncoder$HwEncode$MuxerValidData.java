package com.tencent.mobileqq.shortvideo.hwcodec;

import android.media.MediaFormat;
import com.tencent.qphone.base.util.QLog;

class SVHwEncoder$HwEncode$MuxerValidData
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean;
  boolean c;
  boolean d;
  boolean e;
  boolean f;
  boolean g;
  
  SVHwEncoder$HwEncode$MuxerValidData(SVHwEncoder.HwEncode paramHwEncode) {}
  
  void a()
  {
    a("releaseMuxer[resetValidData]");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.d = false;
    this.e = false;
    this.f = false;
    this.g = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
  }
  
  void a(MediaFormat paramMediaFormat)
  {
    if ((paramMediaFormat.containsKey("csd-0")) && (paramMediaFormat.containsKey("csd-1"))) {
      this.d = true;
    }
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": mHasKeyFrame=");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(" mVideoFirst=");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append(" mFirstIsKey=");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" mVideoConfigOK=");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" mAudioConfigOK=");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" mVideoMuxeredframeCount=");
      localStringBuilder.append(SVHwEncoder.HwEncode.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode));
      localStringBuilder.append(" mAudioMuxeredframeCount=");
      localStringBuilder.append(SVHwEncoder.HwEncode.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode));
      localStringBuilder.append(" mVideoOrderError=");
      localStringBuilder.append(this.f);
      localStringBuilder.append(" mAudioOrderError=");
      localStringBuilder.append(this.g);
      localStringBuilder.append(" mVideoOrderErrorCnt=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" mAudioOrderErrorCnt=");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      QLog.d("SVHwEncoder", 2, localStringBuilder.toString());
    }
  }
  
  boolean a()
  {
    SVHwEncoder localSVHwEncoder = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mNeedEncodeAudio=");
    localStringBuilder.append(SVHwEncoder.HwEncode.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode));
    localStringBuilder.append(" mAudioConfigOK=");
    localStringBuilder.append(this.e);
    localSVHwEncoder.a("releaseMuxer[audioSpecOK]", localStringBuilder.toString());
    if (SVHwEncoder.HwEncode.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode)) {
      return this.e;
    }
    return true;
  }
  
  boolean a(long paramLong, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Long > paramLong)
      {
        this.f = true;
        this.jdField_a_of_type_Int += 1;
        paramBoolean = bool1;
      }
      else
      {
        paramBoolean = false;
      }
      this.jdField_a_of_type_Long = paramLong;
      return paramBoolean;
    }
    if (this.jdField_b_of_type_Long > paramLong)
    {
      this.g = true;
      this.jdField_b_of_type_Int += 1;
      paramBoolean = bool2;
    }
    else
    {
      paramBoolean = false;
    }
    this.jdField_b_of_type_Long = paramLong;
    return paramBoolean;
  }
  
  void b(MediaFormat paramMediaFormat)
  {
    if (paramMediaFormat.containsKey("csd-0")) {
      this.e = true;
    }
  }
  
  boolean b()
  {
    SVHwEncoder localSVHwEncoder = this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mNeedEncodeVideo=");
    localStringBuilder.append(SVHwEncoder.HwEncode.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode));
    localStringBuilder.append(" mVideoConfigOK=");
    localStringBuilder.append(this.d);
    localSVHwEncoder.a("releaseMuxer[videoSpecOK]", localStringBuilder.toString());
    boolean bool2 = SVHwEncoder.HwEncode.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode);
    boolean bool1 = true;
    if (bool2)
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.c) && (this.d) && (!this.f)) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  boolean c()
  {
    return (a()) && (b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.HwEncode.MuxerValidData
 * JD-Core Version:    0.7.0.1
 */