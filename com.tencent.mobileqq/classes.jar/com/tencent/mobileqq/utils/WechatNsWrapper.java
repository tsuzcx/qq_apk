package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioprocessor.AudioComponentProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor.ProcessData;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.PipedInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.HashMap;

public final class WechatNsWrapper
  extends AudioComponentProcessor
{
  public static boolean j = false;
  int k;
  short[] l;
  private int m = 0;
  private boolean n = false;
  
  public WechatNsWrapper()
  {
    super(BaseApplication.getContext());
    c();
  }
  
  public WechatNsWrapper(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  private void c()
  {
    if (!j) {
      try
      {
        boolean bool1 = SoLoadUtil.a(this.a, "stlport_shared", 0, false);
        boolean bool2 = QLog.isColorLevel();
        StringBuilder localStringBuilder;
        if (bool2)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("load stlport_shared ");
          localStringBuilder.append(bool1);
          QLog.d("SilkCodecWrapper", 2, localStringBuilder.toString());
        }
        bool1 = SoLoadUtilNew.loadSoByName(this.a, "voicemessagedenoise");
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("load voicemessagedenoise ");
          localStringBuilder.append(bool1);
          QLog.d("SilkCodecWrapper", 2, localStringBuilder.toString());
        }
        bool1 = SoLoadUtilNew.loadSoByName(this.a, "wechatns");
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("load wechatns ");
          localStringBuilder.append(bool1);
          QLog.d("SilkCodecWrapper", 2, localStringBuilder.toString());
        }
        j = true;
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        HashMap localHashMap = new HashMap();
        localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        localHashMap.put("throwable", localThrowable.getMessage());
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actWechatNsLoadFail", false, 0L, 0L, localHashMap, "");
      }
    }
  }
  
  public void a()
  {
    super.a();
    b();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramInt1, paramInt2, paramInt3);
    if (this.k == 0) {}
    for (;;)
    {
      try
      {
        this.k = nsNew();
        StringBuilder localStringBuilder1;
        if (QLog.isColorLevel())
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("silkEncoderNew =");
          localStringBuilder1.append(this.k);
          QLog.d("SilkCodecWrapper", 2, localStringBuilder1.toString());
        }
        paramInt2 = nsInit(this.k, paramInt1);
        if (paramInt2 != 0) {
          break label281;
        }
        bool = true;
        this.n = bool;
        if (QLog.isColorLevel())
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("silkEncoderInit =");
          localStringBuilder1.append(paramInt2);
          QLog.d("SilkCodecWrapper", 2, localStringBuilder1.toString());
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("init silk codec =");
          localStringBuilder2.append(localException.toString());
          QLog.d("SilkCodecWrapper", 2, localStringBuilder2.toString());
        }
        this.k = 0;
        j = false;
      }
      this.i = QQAudioUtils.a(paramInt1);
      this.l = new short[this.i / 2];
      this.d = new byte[this.i];
      this.e = new byte[this.i];
      paramInt2 = this.i;
      paramInt1 = 960;
      if (paramInt2 * 2 > 960) {
        paramInt1 = this.i * 2;
      }
      this.f = new byte[paramInt1];
      this.g = new IAudioProcessor.ProcessData(this.f, 0);
      return;
      label281:
      boolean bool = false;
    }
  }
  
  public void a(byte[] paramArrayOfByte, short[] paramArrayOfShort)
  {
    ByteBuffer.wrap(paramArrayOfByte, 0, paramArrayOfByte.length).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(paramArrayOfShort, 0, paramArrayOfByte.length / 2);
  }
  
  public void a(short[] paramArrayOfShort, byte[] paramArrayOfByte)
  {
    ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(paramArrayOfShort);
  }
  
  public void b()
  {
    int i = this.k;
    if (i != 0)
    {
      i = nsDelete(i);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("deleteCodec =");
        localStringBuilder.append(i);
        QLog.d("SilkCodecWrapper", 2, localStringBuilder.toString());
      }
    }
    this.k = 0;
  }
  
  public void close()
  {
    super.close();
    b();
  }
  
  public native int nsDelete(int paramInt);
  
  public native int nsInit(int paramInt1, int paramInt2);
  
  public native int nsNew();
  
  public native int nsProcess(int paramInt1, short[] paramArrayOfShort, int paramInt2);
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((this.k != 0) && (this.n))
    {
      if (this.c.read(this.d, 0, this.i) == -1) {
        return -1;
      }
      a(this.d, this.l);
      nsProcess(this.k, this.l, this.d.length);
      a(this.l, this.d);
      System.arraycopy(this.d, 0, paramArrayOfByte, paramInt1, this.i);
      return this.i;
    }
    if (this.c.read(this.d, 0, this.i) == -1) {
      return -1;
    }
    System.arraycopy(this.d, 0, paramArrayOfByte, paramInt1, this.i);
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.WechatNsWrapper
 * JD-Core Version:    0.7.0.1
 */