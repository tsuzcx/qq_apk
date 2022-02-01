package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.qqaudio.QQAudioReporter;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioprocessor.AudioComponentProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor.ProcessData;
import com.tencent.mobileqq.qqaudio.silk.SilkSoLoader;
import com.tencent.qphone.base.util.QLog;
import java.io.PipedInputStream;

public final class SilkCodecWrapper
  extends AudioComponentProcessor
{
  private static boolean o = false;
  long j;
  boolean k;
  long l;
  int m;
  long n;
  private int p = 0;
  
  public SilkCodecWrapper(Context paramContext)
  {
    super(paramContext);
    a(true);
  }
  
  public SilkCodecWrapper(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    a(paramBoolean);
  }
  
  private void a(boolean paramBoolean)
  {
    if (!o)
    {
      SilkSoLoader.a(this.a, "codecsilk");
      o = true;
    }
    this.k = paramBoolean;
    this.l = 0L;
    this.m = 0;
    this.n = 0L;
  }
  
  public static boolean b()
  {
    return o;
  }
  
  public native long SilkDecoderNew(int paramInt1, int paramInt2);
  
  public native long SilkEncoderNew(int paramInt1, int paramInt2);
  
  public int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.j;
    if (l2 == 0L) {
      return 0;
    }
    try
    {
      paramInt1 = decode(l2, paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2);
      l1 = SystemClock.uptimeMillis() - l1;
      this.l += l1;
      if (l1 > this.n) {
        this.n = l1;
      }
      this.m += 1;
      return paramInt1;
    }
    catch (Throwable paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
    return 0;
  }
  
  public IAudioProcessor.ProcessData a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l1 = SystemClock.uptimeMillis();
    paramArrayOfByte = super.a(paramArrayOfByte, paramInt1, paramInt2);
    l1 = SystemClock.uptimeMillis() - l1;
    if (l1 > this.n) {
      this.n = l1;
    }
    this.l += l1;
    this.m += 1;
    return paramArrayOfByte;
  }
  
  public void a()
  {
    super.a();
    c();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramInt1, paramInt2, paramInt3);
    try
    {
      if (this.k) {
        this.j = SilkEncoderNew(paramInt1, paramInt2);
      } else {
        this.j = SilkDecoderNew(paramInt1, paramInt2);
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("init silk codec =");
        localStringBuilder.append(localUnsatisfiedLinkError.toString());
        QLog.d("SilkCodecWrapper", 2, localStringBuilder.toString());
      }
      this.j = 0L;
      o = false;
    }
    this.i = QQAudioUtils.a(paramInt1);
    this.d = new byte[this.i];
    this.e = new byte[this.i];
    this.f = new byte[this.i];
    this.g = new IAudioProcessor.ProcessData(this.f, 0);
  }
  
  public void c()
  {
    long l1 = this.j;
    if (l1 != 0L)
    {
      deleteCodec(l1);
      l1 = this.l;
      if (l1 > 0L)
      {
        int i = this.m;
        if (i > 0) {
          if (this.k) {
            QQAudioReporter.a(l1, i, this.n, 0);
          } else {
            QQAudioReporter.a(l1, i, this.n, 1);
          }
        }
      }
    }
    this.j = 0L;
  }
  
  public void close()
  {
    super.close();
    c();
  }
  
  public native int decode(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public native void deleteCodec(long paramLong);
  
  public native int encode(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt);
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.j == 0L) {
      return 0;
    }
    if (this.c.read(this.d, 0, this.i) == -1) {
      return -1;
    }
    if (this.k) {
      this.p = encode(this.j, this.d, this.e, this.i);
    }
    QQAudioUtils.a(this.p, paramArrayOfByte, paramInt1);
    System.arraycopy(this.e, 0, paramArrayOfByte, paramInt1 + 2, this.p);
    return this.p + 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SilkCodecWrapper
 * JD-Core Version:    0.7.0.1
 */