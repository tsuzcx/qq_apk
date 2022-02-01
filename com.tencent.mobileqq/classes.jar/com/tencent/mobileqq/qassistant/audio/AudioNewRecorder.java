package com.tencent.mobileqq.qassistant.audio;

import android.content.Context;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.listener.IRecordEventListener;
import com.tencent.mobileqq.qassistant.listener.IRecordStreamListener;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class AudioNewRecorder
{
  public static int a = -1;
  public AtomicLong b = new AtomicLong(0L);
  public AtomicBoolean c = new AtomicBoolean(false);
  private volatile int d;
  private volatile AudioRecord e;
  private volatile IRecordEventListener f;
  private AcousticEchoCanceler g;
  private Context h = BaseApplication.getContext();
  
  public AudioNewRecorder()
  {
    this(1, 16000, 16, 2, 3200);
  }
  
  private AudioNewRecorder(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == -1) {
      this.d = AudioRecord.getMinBufferSize(paramInt2, paramInt3, paramInt3);
    } else {
      this.d = paramInt5;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AudioNewRecorder, inited bufferSizeInBytes:");
    ((StringBuilder)localObject).append(this.d);
    AssistantUtils.a("AudioNewRecorder", ((StringBuilder)localObject).toString());
    this.e = new AudioRecord(paramInt1, paramInt2, paramInt3, paramInt4, this.d);
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = this.e.getAudioSessionId();
      if (this.g != null)
      {
        AssistantUtils.a("AudioNewRecorder", "echo canceler not null, release it");
        this.g.release();
        this.g = null;
      }
      if (AcousticEchoCanceler.isAvailable())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("create echo canceler, set enable true, session id:");
        ((StringBuilder)localObject).append(a);
        AssistantUtils.a("AudioNewRecorder", ((StringBuilder)localObject).toString());
        this.g = AcousticEchoCanceler.create(a);
      }
      else
      {
        AssistantUtils.a(false);
      }
      localObject = this.g;
      if (localObject != null) {
        ((AcousticEchoCanceler)localObject).setEnabled(true);
      } else {
        AssistantUtils.a("AudioNewRecorder", "echo canceler not available");
      }
    }
    this.c.set(true);
  }
  
  public AudioNewRecorder(RecordParams.RecorderParam paramRecorderParam)
  {
    this(7, 16000, 16, 2, 6400);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject = new byte[this.d];
    System.currentTimeMillis();
    QQAudioUtils.a(this.h, true);
    long l2 = 0L;
    double d1 = 0.0D;
    long l1 = 0L;
    while (this.c.get())
    {
      paramInt1 = this.e.read((byte[])localObject, 0, this.d);
      if (paramInt1 <= 0)
      {
        if (this.f != null) {
          this.f.a("readsize invalid...");
        }
        Thread.sleep(10L);
      }
      else
      {
        if (this.f != null) {
          this.f.a((byte[])localObject, this.b.get());
        }
        l2 += 1L;
        long l3 = paramInt1;
        l1 += l3;
        d1 += ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).getMillisecond(16000, 2, 2, l3);
        this.b.set(d1);
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("record finished, slice index:");
    ((StringBuilder)localObject).append(l2);
    ((StringBuilder)localObject).append(", total size:");
    ((StringBuilder)localObject).append(l1);
    AssistantUtils.a("AudioNewRecorder", ((StringBuilder)localObject).toString());
  }
  
  public void a()
  {
    AssistantUtils.a("AudioNewRecorder", "stop recorder...");
    try
    {
      if (this.g != null) {
        this.g.setEnabled(false);
      }
      if (this.e != null)
      {
        this.e.stop();
        return;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      AssistantUtils.a("AudioNewRecorder", localIllegalStateException.getMessage());
    }
  }
  
  public void a(int paramInt, RecordParams.RecorderParam paramRecorderParam)
  {
    if (this.e.getState() != 1)
    {
      if (this.f != null) {
        this.f.a("AudioRecorder init state failure");
      }
      return;
    }
    ThreadManagerV2.excute(new AudioNewRecorder.2(this), 16, null, false);
  }
  
  public void a(IRecordEventListener paramIRecordEventListener)
  {
    this.f = paramIRecordEventListener;
  }
  
  public boolean a(IRecordStreamListener paramIRecordStreamListener)
  {
    try
    {
      if ((this.e.getState() == 1) && (paramIRecordStreamListener != null))
      {
        ThreadManagerV2.excute(new AudioNewRecorder.1(this, paramIRecordStreamListener), 16, null, false);
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public void b()
  {
    AssistantUtils.a("AudioNewRecorder", "release recorder...");
    try
    {
      if (this.e != null) {
        this.e.stop();
      }
      if (this.e != null) {
        this.e.release();
      }
      if (this.e != null) {
        this.e = null;
      }
      if (this.g != null)
      {
        this.g.release();
        this.g = null;
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("release err:");
      localStringBuilder.append(localException.getMessage());
      AssistantUtils.a("AudioNewRecorder", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.AudioNewRecorder
 * JD-Core Version:    0.7.0.1
 */