package com.tencent.mobileqq.shortvideo.hwcodec;

import android.media.MediaFormat;
import com.tencent.qphone.base.util.QLog;

class SVHwEncoder$HwEncode$MuxerValidData
{
  boolean a;
  boolean b;
  boolean c;
  boolean d;
  boolean e;
  boolean f;
  boolean g;
  long h;
  long i;
  int j;
  int k;
  
  SVHwEncoder$HwEncode$MuxerValidData(SVHwEncoder.HwEncode paramHwEncode) {}
  
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
      localStringBuilder.append(this.a);
      localStringBuilder.append(" mVideoFirst=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" mFirstIsKey=");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" mVideoConfigOK=");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" mAudioConfigOK=");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" mVideoMuxeredframeCount=");
      localStringBuilder.append(SVHwEncoder.HwEncode.a(this.l));
      localStringBuilder.append(" mAudioMuxeredframeCount=");
      localStringBuilder.append(SVHwEncoder.HwEncode.b(this.l));
      localStringBuilder.append(" mVideoOrderError=");
      localStringBuilder.append(this.f);
      localStringBuilder.append(" mAudioOrderError=");
      localStringBuilder.append(this.g);
      localStringBuilder.append(" mVideoOrderErrorCnt=");
      localStringBuilder.append(this.j);
      localStringBuilder.append(" mAudioOrderErrorCnt=");
      localStringBuilder.append(this.k);
      QLog.d("SVHwEncoder", 2, localStringBuilder.toString());
    }
  }
  
  boolean a()
  {
    SVHwEncoder localSVHwEncoder = this.l.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mNeedEncodeAudio=");
    localStringBuilder.append(SVHwEncoder.HwEncode.c(this.l));
    localStringBuilder.append(" mAudioConfigOK=");
    localStringBuilder.append(this.e);
    localSVHwEncoder.a("releaseMuxer[audioSpecOK]", localStringBuilder.toString());
    if (SVHwEncoder.HwEncode.c(this.l)) {
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
      if (this.h > paramLong)
      {
        this.f = true;
        this.j += 1;
        paramBoolean = bool1;
      }
      else
      {
        paramBoolean = false;
      }
      this.h = paramLong;
      return paramBoolean;
    }
    if (this.i > paramLong)
    {
      this.g = true;
      this.k += 1;
      paramBoolean = bool2;
    }
    else
    {
      paramBoolean = false;
    }
    this.i = paramLong;
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
    SVHwEncoder localSVHwEncoder = this.l.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mNeedEncodeVideo=");
    localStringBuilder.append(SVHwEncoder.HwEncode.d(this.l));
    localStringBuilder.append(" mVideoConfigOK=");
    localStringBuilder.append(this.d);
    localSVHwEncoder.a("releaseMuxer[videoSpecOK]", localStringBuilder.toString());
    boolean bool2 = SVHwEncoder.HwEncode.d(this.l);
    boolean bool1 = true;
    if (bool2)
    {
      if ((this.a) && (this.b) && (this.c) && (this.d) && (!this.f)) {
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
  
  void d()
  {
    a("releaseMuxer[resetValidData]");
    this.a = false;
    this.b = false;
    this.c = false;
    this.d = false;
    this.e = false;
    this.f = false;
    this.g = false;
    this.j = 0;
    this.k = 0;
    this.h = 0L;
    this.i = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.HwEncode.MuxerValidData
 * JD-Core Version:    0.7.0.1
 */