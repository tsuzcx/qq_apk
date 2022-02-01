package com.tencent.mobileqq.shortvideo.hwcodec;

import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.qphone.base.util.QLog;

public class HwEncodeHelper
  implements SVHwDataSource, SVHwOutputNotify
{
  private final String a = "HwEncodeHelper";
  private int b = 0;
  private String c;
  private String d;
  private VideoSourceHelper e;
  private byte[] f = null;
  private byte[] g = null;
  private long[] h = new long[1];
  private SVHwEncoder.HwFrame i = new SVHwEncoder.HwFrame();
  private SVHwEncoder.HwFrame j = new SVHwEncoder.HwFrame();
  private boolean k = false;
  private boolean l = false;
  
  public HwEncodeHelper(String paramString1, String paramString2, String paramString3)
  {
    this.c = paramString3;
    this.e = new VideoSourceHelper(paramString1, paramString2);
  }
  
  private boolean f()
  {
    int[] arrayOfInt = this.e.getBufferSize();
    if (arrayOfInt != null)
    {
      if (arrayOfInt.length < 2) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initMediaBuffer videosize=");
        localStringBuilder.append(arrayOfInt[0]);
        localStringBuilder.append(", audiosize=");
        localStringBuilder.append(arrayOfInt[1]);
        QLog.d("HwEncodeHelper", 4, localStringBuilder.toString());
      }
      try
      {
        if (this.f == null) {
          this.f = new byte[arrayOfInt[0]];
        }
        if (this.g == null) {
          this.g = new byte[arrayOfInt[1]];
        }
        return true;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
    return false;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("svMergeOK() path=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", totalTime=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" mergetime=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" us");
      QLog.d("HwEncodeHelper", 4, localStringBuilder.toString());
    }
    this.d = paramString;
  }
  
  public SVHwEncoder.HwFrame b(int paramInt)
  {
    Object localObject = this.e;
    if ((localObject != null) && (!this.l))
    {
      paramInt = ((VideoSourceHelper)localObject).getNextVideoFrame(this.f, this.h, paramInt);
      localObject = this.i;
      ((SVHwEncoder.HwFrame)localObject).a = this.f;
      ((SVHwEncoder.HwFrame)localObject).b = 0;
      ((SVHwEncoder.HwFrame)localObject).c = paramInt;
      boolean bool = true;
      ((SVHwEncoder.HwFrame)localObject).f = true;
      if (paramInt > 0) {
        bool = false;
      }
      ((SVHwEncoder.HwFrame)localObject).e = bool;
      localObject = this.i;
      ((SVHwEncoder.HwFrame)localObject).d = this.h[0];
      ((SVHwEncoder.HwFrame)localObject).h = -1;
      ((SVHwEncoder.HwFrame)localObject).g = -1.0F;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getVideoFrame() bufferSize=");
        ((StringBuilder)localObject).append(this.f.length);
        ((StringBuilder)localObject).append(", readSize=");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", frametime=");
        ((StringBuilder)localObject).append(this.h[0]);
        QLog.d("HwEncodeHelper", 4, ((StringBuilder)localObject).toString());
      }
      this.l = this.i.e;
      return this.i;
    }
    return null;
  }
  
  public void b() {}
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("svErrorOcured() code=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", subcode=");
      localStringBuilder.append(paramInt2);
      QLog.d("HwEncodeHelper", 4, localStringBuilder.toString());
    }
    this.b = -1;
  }
  
  public int c()
  {
    if (!HwEnvData.a()) {
      return -1;
    }
    if (this.e.initHelperParam() != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HwEncodeHelper", 4, "initHelperParam error");
      }
      return -1;
    }
    if (!f())
    {
      if (QLog.isColorLevel()) {
        QLog.d("HwEncodeHelper", 4, "initMediaBuffer error");
      }
      this.e.closeHelper();
      return -1;
    }
    SVHwEncoder localSVHwEncoder = new SVHwEncoder();
    int m = CodecParam.mAudioChannel;
    int n = 2;
    if (m == 16) {
      m = 1;
    } else {
      m = 2;
    }
    if (CodecParam.mAudioFormat != 2) {
      n = 1;
    }
    int i1 = CodecParam.mAudioSampleRate;
    localSVHwEncoder.a(CodecParam.mAudioSampleRate, m, i1 * m * n * 8, n);
    Object localObject = this.e.getSourceVideoParam();
    localSVHwEncoder.a(this.c, localObject[0], localObject[1]);
    boolean bool = localSVHwEncoder.a(CodecParam.mRecordFrames, CodecParam.mRecordTime, this.e.mOrientationDegree);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startHwEncode mRecordFrames=");
      ((StringBuilder)localObject).append(CodecParam.mRecordFrames);
      ((StringBuilder)localObject).append(", mRecordTime=");
      ((StringBuilder)localObject).append(CodecParam.mRecordTime);
      ((StringBuilder)localObject).append(" successCode=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("HwEncodeHelper", 4, ((StringBuilder)localObject).toString());
    }
    if (!bool)
    {
      this.e.closeHelper();
      return -1;
    }
    localSVHwEncoder.a(this, this, true);
    this.e.closeHelper();
    return this.b;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public SVHwEncoder.HwFrame e()
  {
    Object localObject = this.e;
    if ((localObject != null) && (!this.k))
    {
      int m = ((VideoSourceHelper)localObject).getNextAudioFrame(this.g);
      localObject = this.j;
      ((SVHwEncoder.HwFrame)localObject).a = this.g;
      boolean bool = false;
      ((SVHwEncoder.HwFrame)localObject).b = 0;
      ((SVHwEncoder.HwFrame)localObject).c = m;
      ((SVHwEncoder.HwFrame)localObject).f = false;
      if (m <= 0) {
        bool = true;
      }
      ((SVHwEncoder.HwFrame)localObject).e = bool;
      localObject = this.j;
      ((SVHwEncoder.HwFrame)localObject).h = -1;
      ((SVHwEncoder.HwFrame)localObject).d = -1;
      ((SVHwEncoder.HwFrame)localObject).g = -1.0F;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getAudioFrame() bufferSize=");
        ((StringBuilder)localObject).append(this.g.length);
        ((StringBuilder)localObject).append(", readSize=");
        ((StringBuilder)localObject).append(m);
        QLog.d("HwEncodeHelper", 4, ((StringBuilder)localObject).toString());
      }
      this.k = this.j.e;
      return this.j;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.HwEncodeHelper
 * JD-Core Version:    0.7.0.1
 */