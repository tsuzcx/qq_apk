package com.tencent.mobileqq.shortvideo.mediadevice;

import android.content.Context;
import android.media.AudioRecord;
import android.os.SystemClock;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.maxvideo.common.ControlFlagEnum;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.common.Observable;
import com.tencent.mobileqq.shortvideo.error.ErrorCenter;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.HwFrame;
import com.tencent.mobileqq.shortvideo.util.AudioDataCache;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicReference;

public class AudioCapture
  extends Observable
{
  public static int b = 160768;
  public static int c = 4;
  public static boolean r = true;
  private boolean A = false;
  private boolean B = false;
  Context d;
  AudioRecord e;
  public int f = 0;
  public int g = 0;
  byte[] h = null;
  int i = 0;
  int j = 0;
  byte[] k = null;
  int l = 0;
  int m = 0;
  Object n = new Object();
  volatile boolean o = false;
  boolean p = false;
  boolean q = false;
  public volatile boolean s = true;
  public volatile int t = 0;
  public AtomicReference<SVHwEncoder> u = new AtomicReference(null);
  public AtomicReference<AudioDataCache> v = new AtomicReference(null);
  long w;
  long x;
  private boolean y = false;
  private boolean z = false;
  
  public AudioCapture(Context paramContext)
  {
    this.d = paramContext;
    this.f = 0;
    this.g = 0;
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt)
  {
    return 0;
  }
  
  public void a()
  {
    this.l = 0;
    this.m = 0;
  }
  
  public void a(AudioCapture.OnAudioRecordListener paramOnAudioRecordListener)
  {
    a(paramOnAudioRecordListener, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
  }
  
  void a(byte[] paramArrayOfByte, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    Object localObject = new AVIOStruct();
    if (paramBoolean)
    {
      i1 = this.l;
    }
    else
    {
      i1 = this.l;
      this.l = (i1 + 1);
    }
    ((AVIOStruct)localObject).pBlockIndex = i1;
    int i1 = this.m;
    this.m = (i1 + 1);
    ((AVIOStruct)localObject).pFrameIndex = i1;
    ((AVIOStruct)localObject).aBitrate = CodecParam.mDstAudioEncBitrate;
    ((AVIOStruct)localObject).pCodec = CodecParam.mCodecId;
    ((AVIOStruct)localObject).pControlFlag = ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue();
    ((AVIOStruct)localObject).aChannel = CodecParam.mAudioChannel;
    ((AVIOStruct)localObject).aFormat = CodecParam.mAudioFormat;
    ((AVIOStruct)localObject).aSampleRate = CodecParam.mAudioSampleRate;
    if ((paramArrayOfByte != null) && (paramInt1 > 0))
    {
      byte[] arrayOfByte = new byte[paramInt1];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt1);
      RecordManager.a().b().handleAudio(arrayOfByte, (AVIOStruct)localObject, (int)paramLong);
      paramArrayOfByte = (SVHwEncoder)this.u.get();
      if (paramArrayOfByte != null)
      {
        localObject = new SVHwEncoder.HwFrame();
        ((SVHwEncoder.HwFrame)localObject).a = arrayOfByte;
        ((SVHwEncoder.HwFrame)localObject).b = 0;
        ((SVHwEncoder.HwFrame)localObject).c = arrayOfByte.length;
        ((SVHwEncoder.HwFrame)localObject).d = SystemClock.elapsedRealtime();
        ((SVHwEncoder.HwFrame)localObject).e = false;
        ((SVHwEncoder.HwFrame)localObject).f = false;
        paramArrayOfByte.a((SVHwEncoder.HwFrame)localObject, false);
      }
      a(paramInt2, new Object[] { Integer.valueOf(0) });
    }
  }
  
  void b(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (paramInt == -3)
    {
      this.s = false;
      this.t = -1;
    }
    else
    {
      int i1;
      if (paramInt == 0)
      {
        i1 = this.f;
        if (i1 < 5)
        {
          this.f = (i1 + 1);
        }
        else
        {
          this.s = false;
          this.t = -2;
        }
      }
      else
      {
        this.f = 0;
        i1 = 128;
        if (paramInt <= 128) {
          i1 = paramInt;
        }
        if (!this.z)
        {
          boolean bool1 = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductFeature(CameraCompatibleConstants.p);
          if ((bool1) && (this.g < 5)) {
            this.A = PreviewContext.checkIsDisablePrivilage(this.h, i1);
          } else {
            this.A = false;
          }
          this.g += 1;
          boolean bool2 = this.A;
          if (!bool2)
          {
            this.z = true;
          }
          else if ((bool2) && (this.g >= 5))
          {
            this.z = true;
            this.s = false;
            this.t = -3;
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkAudioPrivilage[ERR_AUDIO_INVALID_DATA]: result=");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(" mDisableAudioPrivilage=");
            localStringBuilder.append(this.A);
            localStringBuilder.append(" blackPhone=");
            localStringBuilder.append(bool1);
            localStringBuilder.append(" mAudioInvalidData=");
            localStringBuilder.append(this.g);
            QLog.d("AudioCapture", 2, localStringBuilder.toString());
          }
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkAudioPrivilage: mDisableAudioPrivilage=");
          localStringBuilder.append(this.A);
          localStringBuilder.append(" limit=");
          localStringBuilder.append(i1);
          localStringBuilder.append(" mAudioCanUsed=");
          localStringBuilder.append(this.s);
          QLog.d("AudioCapture", 2, localStringBuilder.toString());
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAudioPrivilage[end]: result=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" mAudioCanUsed=");
      localStringBuilder.append(this.s);
      QLog.d("AudioCapture", 2, localStringBuilder.toString());
    }
  }
  
  public void b(AudioCapture.OnAudioRecordListener paramOnAudioRecordListener)
  {
    a(paramOnAudioRecordListener);
  }
  
  void b(byte[] paramArrayOfByte, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramInt1 > 0) && (paramInt1 <= paramArrayOfByte.length))
    {
      if (this.v.get() != null) {
        ((AudioDataCache)this.v.get()).a(paramArrayOfByte, 0, paramInt1);
      } else if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "AudioCapture[writeDataToAudioNewCache]: mAudioDataCache=null");
      }
      a(paramInt2, new Object[] { Integer.valueOf(0) });
    }
  }
  
  public boolean b()
  {
    this.o = true;
    this.z = false;
    this.A = false;
    this.B = RMVideoStateMgr.a().x();
    new AudioCapture.RecordThread2(this).start();
    return true;
  }
  
  void c(byte[] paramArrayOfByte, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    if (this.B)
    {
      b(paramArrayOfByte, paramInt1, paramLong, paramBoolean, paramInt2);
      return;
    }
    a(paramArrayOfByte, paramInt1, paramLong, paramBoolean, paramInt2);
  }
  
  public boolean c()
  {
    try
    {
      if (this.y)
      {
        boolean bool = this.y;
        return bool;
      }
      this.i = AudioRecord.getMinBufferSize(CodecParam.mAudioSampleRate, CodecParam.mAudioChannel, CodecParam.mAudioFormat);
      if ((this.i != -2) && (this.i != -1))
      {
        this.h = new byte[this.i];
        int i1 = b / c;
        if (this.i <= i1) {
          i1 = b;
        } else {
          i1 = this.i * c;
        }
        this.j = i1;
        this.k = new byte[this.j];
        this.y = true;
        a(3, new Object[] { Boolean.valueOf(true), Integer.valueOf(0) });
        return true;
      }
      if (!RecordManager.a().c().a(this, 3, "init audio failed")) {
        a(3, new Object[] { "init audio failed" });
      }
      return false;
    }
    finally {}
  }
  
  public void d()
  {
    this.i = 0;
    this.h = null;
    this.j = 0;
    this.k = null;
    this.y = false;
    this.f = 0;
    this.g = 0;
    this.A = false;
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("AudioCapture[openMic]: isCreate=");
      localStringBuilder1.append(this.p);
      localStringBuilder1.append(" isStart=");
      localStringBuilder1.append(this.q);
      localStringBuilder1.append(" mAudioRecord=");
      localStringBuilder1.append(this.e);
      QLog.d("AudioCapture", 2, localStringBuilder1.toString());
    }
    if (!this.p) {
      try
      {
        c();
        this.e = new AudioRecord(1, CodecParam.mAudioSampleRate, CodecParam.mAudioChannel, CodecParam.mAudioFormat, this.i);
        if (this.e.getState() == 0)
        {
          a(5, new Object[] { HardCodeUtil.a(2131899030) });
          return;
        }
        this.p = true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        a(5, new Object[] { HardCodeUtil.a(2131899033) });
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("AudioCapture[openMic]: isCreate=");
      localStringBuilder2.append(this.p);
      localStringBuilder2.append(" isStart=");
      localStringBuilder2.append(this.q);
      localStringBuilder2.append(" mAudioRecord=");
      localStringBuilder2.append(this.e);
      QLog.d("AudioCapture", 2, localStringBuilder2.toString());
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AudioCapture[startMic]: isCreate=");
      ((StringBuilder)localObject).append(this.p);
      ((StringBuilder)localObject).append(" isStart=");
      ((StringBuilder)localObject).append(this.q);
      ((StringBuilder)localObject).append(" mAudioRecord=");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("AudioCapture", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.e;
    if ((localObject != null) && (this.p) && (!this.q)) {
      try
      {
        ((AudioRecord)localObject).startRecording();
        this.q = true;
        a(6, new Object[] { Boolean.valueOf(true) });
      }
      catch (IllegalStateException localIllegalStateException)
      {
        this.q = false;
        localIllegalStateException.printStackTrace();
        try
        {
          this.e.release();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        a(6, new Object[] { HardCodeUtil.a(2131899034) });
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AudioCapture[startMic]: isCreate=");
      localStringBuilder.append(this.p);
      localStringBuilder.append(" isStart=");
      localStringBuilder.append(this.q);
      localStringBuilder.append(" mAudioRecord=");
      localStringBuilder.append(this.e);
      QLog.d("AudioCapture", 2, localStringBuilder.toString());
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AudioCapture[stopMic]: isCreate=");
      ((StringBuilder)localObject).append(this.p);
      ((StringBuilder)localObject).append(" isStart=");
      ((StringBuilder)localObject).append(this.q);
      ((StringBuilder)localObject).append(" mAudioRecord=");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("AudioCapture", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.e;
    if ((localObject != null) && (this.p) && (this.q))
    {
      ((AudioRecord)localObject).stop();
      this.q = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AudioCapture[stopMic]: isCreate=");
      ((StringBuilder)localObject).append(this.p);
      ((StringBuilder)localObject).append(" isStart=");
      ((StringBuilder)localObject).append(this.q);
      ((StringBuilder)localObject).append(" mAudioRecord=");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("AudioCapture", 2, ((StringBuilder)localObject).toString());
    }
    this.d = null;
  }
  
  public void h()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AudioCapture[releaseMic]: isCreate=");
      ((StringBuilder)localObject).append(this.p);
      ((StringBuilder)localObject).append(" isStart=");
      ((StringBuilder)localObject).append(this.q);
      ((StringBuilder)localObject).append(" mAudioRecord=");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("AudioCapture", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.e;
    if (localObject != null)
    {
      ((AudioRecord)localObject).release();
      this.e = null;
      this.p = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AudioCapture[releaseMic]: isCreate=");
      ((StringBuilder)localObject).append(this.p);
      ((StringBuilder)localObject).append(" isStart=");
      ((StringBuilder)localObject).append(this.q);
      ((StringBuilder)localObject).append(" mAudioRecord=");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("AudioCapture", 2, ((StringBuilder)localObject).toString());
    }
    this.d = null;
  }
  
  public void i()
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("AudioCapture[destory]: isCreate=");
      ((StringBuilder)???).append(this.p);
      ((StringBuilder)???).append(" isStart=");
      ((StringBuilder)???).append(this.q);
      ((StringBuilder)???).append(" mAudioRecord=");
      ((StringBuilder)???).append(this.e);
      QLog.d("AudioCapture", 2, ((StringBuilder)???).toString());
    }
    this.o = false;
    synchronized (this.n)
    {
      this.n.notifyAll();
      g();
      h();
      this.l = 0;
      this.m = 0;
      return;
    }
  }
  
  public void j()
  {
    if (!Lock.b) {
      return;
    }
    synchronized (this.n)
    {
      this.n.notifyAll();
      a(1, new Object[] { Integer.valueOf(0) });
      return;
    }
  }
  
  public void k()
  {
    if (Lock.b) {
      return;
    }
    a(2, new Object[] { Integer.valueOf(0) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture
 * JD-Core Version:    0.7.0.1
 */