package com.tencent.mobileqq.voicechange;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.av.temp.IQavTemp;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioprocessor.AudioComponentProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor.ProcessData;
import com.tencent.mobileqq.qqaudio.silk.SilkSoLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.PipedInputStream;

public class VoiceChange
  extends AudioComponentProcessor
{
  private static boolean j = false;
  private long k;
  private int l = 0;
  private long m;
  private int n;
  private long o;
  private String p;
  
  public VoiceChange(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
    if (!j)
    {
      SilkSoLoader.a(paramContext, "codecsilk");
      j = true;
    }
    this.l = paramInt;
    try
    {
      this.p = new File(paramString).getCanonicalPath();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public native long Create(String paramString1, String paramString2);
  
  public native int Init(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int Release(long paramLong);
  
  public IAudioProcessor.ProcessData a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l1 = SystemClock.uptimeMillis();
    paramArrayOfByte = super.a(paramArrayOfByte, paramInt1, paramInt2);
    l1 = SystemClock.uptimeMillis() - l1;
    if (l1 > this.o) {
      this.o = l1;
    }
    this.m += l1;
    this.n += 1;
    return paramArrayOfByte;
  }
  
  public void a()
  {
    if ((this.m > 0L) && (this.n > 0) && (this.l > 0)) {
      ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).reportSoundProcessCost(this.m, this.n, this.o, this.l + 2);
    }
    Release(this.k);
    this.k = 0L;
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramInt1, paramInt2, paramInt3);
    this.m = 0L;
    this.n = 0;
    this.o = 0L;
    this.i = QQAudioUtils.a(paramInt1);
    Object localObject = ((IQavTemp)QRoute.api(IQavTemp.class)).getAudio3ALicenseFilename();
    boolean bool = QLog.isColorLevel();
    paramInt2 = 1;
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("voice Init getAudio3ALicenseFilename  = ");
      localStringBuilder.append((String)localObject);
      QLog.e("QQVoiceChanger", 1, localStringBuilder.toString());
    }
    this.k = Create(this.p, (String)localObject);
    if (this.k == 0L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Create voiceChanger error with:");
      ((StringBuilder)localObject).append(this.p);
      QLog.e("QQVoiceChanger", 1, ((StringBuilder)localObject).toString());
    }
    paramInt3 = this.l;
    if (paramInt3 == 1) {}
    for (;;)
    {
      paramInt3 = -1;
      break label405;
      if (paramInt3 == 2)
      {
        paramInt2 = 2;
      }
      else
      {
        if (paramInt3 == 3)
        {
          paramInt2 = 8;
          paramInt3 = 3;
          break label405;
        }
        if (paramInt3 == 4)
        {
          paramInt2 = 7;
        }
        else
        {
          if (paramInt3 == 5)
          {
            paramInt2 = -1;
            paramInt3 = 2;
            break label405;
          }
          if (paramInt3 == 6)
          {
            paramInt2 = 6;
          }
          else
          {
            if (paramInt3 == 7)
            {
              paramInt2 = 10;
              paramInt3 = 4;
              break label405;
            }
            if (paramInt3 == 8)
            {
              paramInt2 = 10;
              paramInt3 = 20;
              break label405;
            }
            if (paramInt3 == 9)
            {
              paramInt2 = 11;
            }
            else if (paramInt3 == 10)
            {
              paramInt2 = 12;
            }
            else
            {
              if (paramInt3 == 11)
              {
                paramInt2 = 9;
                paramInt3 = 51;
                break label405;
              }
              if (paramInt3 == 12)
              {
                paramInt2 = 13;
                paramInt3 = 1;
                break label405;
              }
              if (paramInt3 == 13)
              {
                paramInt2 = 536936433;
                paramInt3 = 50;
                break label405;
              }
              if (paramInt3 == 14)
              {
                paramInt2 = -1;
                paramInt3 = 5;
                break label405;
              }
              if (paramInt3 == 15)
              {
                paramInt2 = -1;
                paramInt3 = 9;
                break label405;
              }
              if (paramInt3 != 16) {
                break;
              }
              paramInt2 = 13;
            }
          }
        }
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Init Error type=");
    ((StringBuilder)localObject).append(this.l);
    QLog.e("QQVoiceChanger", 1, ((StringBuilder)localObject).toString());
    paramInt2 = 0;
    paramInt3 = 0;
    label405:
    Init(this.k, paramInt1, 1, paramInt2, paramInt3);
    this.d = new byte[this.i];
    this.e = new byte[this.i * 10];
    this.f = new byte[this.e.length * 2];
    this.g = new IAudioProcessor.ProcessData(this.f, 0);
  }
  
  public native int doChange(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.c.read(this.d, 0, this.i) == -1) {
      return -1;
    }
    paramInt2 = doChange(this.k, this.d, this.e);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("change voice type=");
      localStringBuilder.append(this.l);
      localStringBuilder.append(" changedSize=");
      localStringBuilder.append(paramInt2);
      QLog.d("QQVoiceChanger", 2, localStringBuilder.toString());
    }
    System.arraycopy(this.e, 0, paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.VoiceChange
 * JD-Core Version:    0.7.0.1
 */