package com.tencent.mobileqq.videocodec.audio;

import android.media.AudioRecord;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWAudioEncoder;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWAudioEncoder.AudioEncodeListener;
import com.tencent.qphone.base.util.QLog;

public class AudioCapture
  implements HWAudioEncoder.AudioEncodeListener
{
  public static int a = 16384;
  public static int b = 4;
  private AudioCapture.AudioCaptureListener A;
  private AudioCapture.RecordRunnable B;
  private Thread C;
  private Handler D;
  public int c;
  public int d;
  public AudioRecord e;
  byte[] f = null;
  int g = 0;
  int h = 0;
  byte[] i = null;
  public volatile boolean j = true;
  public volatile int k = 0;
  public AudioDataCache l;
  HWAudioEncoder m;
  private String n;
  private boolean o = false;
  private boolean p;
  private boolean q;
  private boolean r = false;
  private boolean s = false;
  private boolean t = true;
  private boolean u = false;
  private String v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public AudioCapture(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, AudioCapture.AudioCaptureListener paramAudioCaptureListener, Handler paramHandler)
  {
    this.n = paramString;
    this.w = paramInt1;
    this.x = paramInt2;
    this.y = paramInt3;
    this.z = paramInt4;
    this.A = paramAudioCaptureListener;
    this.D = paramHandler;
    if (paramHandler == null) {
      this.D = new Handler(ThreadManager.getSubThreadLooper());
    }
    this.c = 0;
    this.d = 0;
    this.p = false;
    this.q = false;
  }
  
  private boolean k()
  {
    try
    {
      if (this.o)
      {
        boolean bool = this.o;
        return bool;
      }
      this.g = AudioRecord.getMinBufferSize(this.x, CodecParam.mAudioChannel, CodecParam.mAudioFormat);
      if ((this.g != -2) && (this.g != -1))
      {
        this.f = new byte[this.g];
        int i1 = a / b;
        if (this.g <= i1) {
          i1 = a;
        } else {
          i1 = this.g * b;
        }
        this.h = i1;
        this.i = new byte[this.h];
        this.o = true;
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMinBufferSize error. mRecBufSize = ");
      localStringBuilder.append(this.g);
      QLog.e("AudioCapture", 2, localStringBuilder.toString());
      return false;
    }
    finally {}
  }
  
  private void l()
  {
    this.g = 0;
    this.f = null;
    this.h = 0;
    this.i = null;
    this.o = false;
    this.c = 0;
    this.d = 0;
    this.q = false;
  }
  
  public int a()
  {
    return this.x;
  }
  
  void a(int paramInt)
  {
    if (paramInt == -3)
    {
      this.j = false;
      this.k = -1;
      return;
    }
    StringBuilder localStringBuilder;
    if (paramInt == 0)
    {
      int i1 = this.c;
      if (i1 < 5)
      {
        this.c = (i1 + 1);
        return;
      }
      this.j = false;
      this.k = -2;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkAudioPrivilage[ERR_AUDIO_INVALID_DATA_LENGTH]: result=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" mAudioInvalidCount=");
        localStringBuilder.append(this.c);
        QLog.d("AudioCapture", 2, localStringBuilder.toString());
      }
    }
    else
    {
      this.c = 0;
      if (!this.p)
      {
        this.p = true;
        this.q = false;
        this.d += 1;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkAudioPrivilage[ERR_AUDIO_INVALID_DATA]: result=");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" mAudioInvalidData=");
          localStringBuilder.append(this.d);
          QLog.d("AudioCapture", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startCaptureThead, restart:");
        localStringBuilder.append(paramBoolean);
        QLog.d("AudioCapture", 2, localStringBuilder.toString());
      }
      if ((!paramBoolean) && (this.B != null) && (this.C != null) && (this.C.isAlive()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AudioCapture", 2, "startCaptureThead, thread is working.");
        }
        return;
      }
      if (this.B != null)
      {
        this.B.b = true;
        this.B.a = false;
        if (this.C != null) {
          this.C.interrupt();
        }
      }
      try
      {
        if (this.C != null) {
          this.C.join();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      this.B = new AudioCapture.RecordRunnable(this);
      this.C = ThreadManager.newFreeThread(this.B, "audio_capture", 5);
      this.C.start();
      if ((this.u) && (this.m == null))
      {
        this.m = new HWAudioEncoder();
        this.m.a(this.x);
        this.m.a(this);
      }
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.u = paramBoolean;
    this.v = paramString;
  }
  
  void a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte != null) && (paramInt > 0) && (paramInt <= paramArrayOfByte.length))
    {
      Object localObject = this.l;
      if (localObject != null) {
        ((AudioDataCache)localObject).a(paramArrayOfByte, 0, paramInt);
      } else if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "AudioCapture[writeDataToAudioNewCache]: mAudioDataCache=null");
      }
      if (this.m != null)
      {
        localObject = new byte[paramInt];
        System.arraycopy(paramArrayOfByte, 0, localObject, 0, paramInt);
        this.m.a((byte[])localObject, 0L);
      }
      localObject = this.A;
      if (localObject != null) {
        ((AudioCapture.AudioCaptureListener)localObject).onAudioFrames(paramArrayOfByte, 0, paramInt);
      }
    }
  }
  
  public void b()
  {
    if (this.B == null) {
      a(true);
    }
    Object localObject = this.B;
    if (localObject != null) {
      ((AudioCapture.RecordRunnable)localObject).c = true;
    }
    g();
    localObject = this.m;
    if (localObject != null) {
      ((HWAudioEncoder)localObject).a(this.v);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "audio pause");
    }
    AudioCapture.RecordRunnable localRecordRunnable = this.B;
    if (localRecordRunnable != null) {
      localRecordRunnable.d = true;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void d()
  {
    AudioCapture.AudioCaptureListener localAudioCaptureListener = this.A;
    if (localAudioCaptureListener != null) {
      localAudioCaptureListener.onEncodeAudioCaptured(this.v);
    }
  }
  
  public void e()
  {
    AudioCapture.AudioCaptureListener localAudioCaptureListener = this.A;
    if (localAudioCaptureListener != null) {
      localAudioCaptureListener.onAudioError(-6);
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "audio queueResume");
    }
    this.D.post(new AudioCapture.1(this));
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "audio resume");
    }
    ??? = this.B;
    if (??? != null)
    {
      ((AudioCapture.RecordRunnable)???).d = false;
      synchronized (((AudioCapture.RecordRunnable)???).e)
      {
        this.B.e.notifyAll();
        return;
      }
    }
  }
  
  public void h()
  {
    if (this.B != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, new Object[] { "audio, stopRecord, isRecording:", Boolean.valueOf(this.B.a), " mIsVoiceRecognizerStat:", Boolean.valueOf(this.s) });
      }
      this.s = false;
      this.t = false;
      this.B.a = false;
      this.C.interrupt();
      this.B = null;
    }
    this.r = false;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "openMic");
    }
    this.D.post(new AudioCapture.2(this));
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "closeMic");
    }
    this.D.post(new AudioCapture.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.audio.AudioCapture
 * JD-Core Version:    0.7.0.1
 */