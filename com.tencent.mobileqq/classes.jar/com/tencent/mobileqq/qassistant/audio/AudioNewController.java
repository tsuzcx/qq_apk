package com.tencent.mobileqq.qassistant.audio;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.data.ConfirmSendInfo;
import com.tencent.mobileqq.qassistant.data.VoiceBean;
import com.tencent.mobileqq.qassistant.data.VoiceEncodeResult;
import com.tencent.mobileqq.qassistant.data.VoicePttInfo;
import com.tencent.mobileqq.qassistant.listener.IAudio2TextResultCallBack;
import com.tencent.mobileqq.qassistant.listener.IRecordEventListener;
import com.tencent.mobileqq.qassistant.listener.IRecordStreamListener;
import com.tencent.mobileqq.qassistant.listener.IVoiceMessageListener;
import com.tencent.mobileqq.qassistant.listener.IVoiceVadListener;
import com.tencent.mobileqq.qassistant.wake.WakeManager;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import mqq.os.MqqHandler;

public class AudioNewController
  implements IVoiceMessageListener
{
  public volatile int a = -1;
  public volatile boolean b;
  protected volatile VoiceBeanProcessor c;
  protected volatile AudioUploadThread d;
  protected volatile VoiceCacheHolder e = new VoiceCacheHolder();
  protected volatile RecordParams.RecorderParam f = new RecordParams.RecorderParam(16000, 16000, 1);
  protected AtomicLong g = new AtomicLong(0L);
  protected AtomicLong h = new AtomicLong(0L);
  protected IVoiceVadListener i;
  protected AudioNewRecorder j;
  private IAudio2TextResultCallBack k;
  
  public AudioNewController()
  {
    VoiceTimeTraceUtil.a().a(this.e);
    this.b = WakeManager.a().b;
  }
  
  protected int a(byte[] paramArrayOfByte)
  {
    if ((this.e != null) && (this.c != null))
    {
      VoiceBean localVoiceBean = new VoiceBean(AssistantUtils.e());
      VoiceTimeTraceUtil.a().a(localVoiceBean);
      boolean bool = this.c.b(paramArrayOfByte);
      VoiceTimeTraceUtil.a().b(localVoiceBean);
      Object localObject = this.i;
      if (localObject != null) {
        ((IVoiceVadListener)localObject).a(bool);
      }
      localObject = this.c.a(paramArrayOfByte);
      localVoiceBean.a(((VoiceEncodeResult)localObject).a, bool, this.g.get(), paramArrayOfByte.length);
      VoiceTimeTraceUtil.a().c(localVoiceBean);
      AtomicLong localAtomicLong = this.g;
      localAtomicLong.set(localAtomicLong.get() + paramArrayOfByte.length);
      this.e.a(paramArrayOfByte, localVoiceBean);
      return ((VoiceEncodeResult)localObject).b;
    }
    return 2000;
  }
  
  public void a()
  {
    try
    {
      if ((e()) || (this.j != null)) {
        c();
      }
      if (this.d != null)
      {
        AssistantUtils.a("AudioNewController", "quit voice transfer thread");
        this.d.a(null);
        this.d.a();
        this.d = null;
      }
      if (this.e != null)
      {
        AssistantUtils.a("AudioNewController", "force clear voice cache");
        this.e.a(this.a, this.c);
      }
      if (this.c != null)
      {
        AssistantUtils.a("AudioNewController", "exit release silk encoder");
        this.c.a();
        this.c = null;
      }
      this.a = -1;
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    try
    {
      if ((e()) || (this.j != null)) {
        c();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invoked assistant recorder, type:");
      localStringBuilder.append(paramInt);
      AssistantUtils.a("AudioNewController", localStringBuilder.toString());
      this.a = paramInt;
      this.b = false;
      this.g.set(0L);
      this.h.set(0L);
      this.e.a();
      if (this.d == null)
      {
        this.d = new AudioUploadThread(this.a, this.e);
        this.d.a(this.k);
        this.d.start();
      }
      if (this.c == null) {
        this.c = new VoiceBeanProcessor(this.f);
      }
      this.j = new AudioNewRecorder(this.f);
      this.j.a(d());
      this.j.a(this.a, this.f);
      return;
    }
    finally {}
  }
  
  public void a(IAudio2TextResultCallBack paramIAudio2TextResultCallBack)
  {
    this.k = paramIAudio2TextResultCallBack;
  }
  
  public void a(IVoiceVadListener paramIVoiceVadListener)
  {
    this.i = paramIVoiceVadListener;
  }
  
  protected void a(RecordParams.RecorderParam paramRecorderParam, int paramInt)
  {
    if ((paramRecorderParam != null) && (paramRecorderParam.h != null))
    {
      paramRecorderParam.h[paramRecorderParam.g] = paramInt;
      if (paramRecorderParam.g < paramRecorderParam.h.length - 1) {
        paramRecorderParam.g += 1;
      }
    }
  }
  
  public void a(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ConfirmSendInfo))
    {
      paramObject = (ConfirmSendInfo)paramObject;
      this.e.a(paramObject);
    }
    AssistantUtils.a("AudioNewController", "message on finish, invoke session");
    a();
    b(1);
  }
  
  public boolean a(IRecordStreamListener paramIRecordStreamListener)
  {
    if ((e()) || (this.j != null)) {
      c();
    }
    AssistantUtils.a("AudioNewController", "invoke wake recorder");
    this.a = 3;
    this.b = true;
    this.j = new AudioNewRecorder();
    return this.j.a(paramIRecordStreamListener);
  }
  
  public void b()
  {
    if (this.b)
    {
      AssistantUtils.a("AudioNewController", "finishWakeRecorder..");
      c();
    }
  }
  
  public void b(int paramInt)
  {
    ThreadManager.getUIHandler().post(new AudioNewController.1(this, paramInt));
  }
  
  protected void b(RecordParams.RecorderParam paramRecorderParam, int paramInt)
  {
    if (paramRecorderParam != null)
    {
      paramRecorderParam.h = new int[paramInt / 1000 * 10];
      paramRecorderParam.g = 0;
    }
  }
  
  protected void c()
  {
    try
    {
      if (this.j != null)
      {
        AssistantUtils.a("AudioNewController", "force release recorder...");
        this.j.a(null);
        this.j.c.set(false);
        this.j.a();
        this.j.b();
        this.j = null;
        this.b = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected IRecordEventListener d()
  {
    return new AudioNewController.2(this);
  }
  
  public boolean e()
  {
    AudioNewRecorder localAudioNewRecorder = this.j;
    if (localAudioNewRecorder != null) {
      return localAudioNewRecorder.c.get();
    }
    return false;
  }
  
  public void f()
  {
    AssistantUtils.a("AudioNewController", "session on finish, invoke message");
    a();
    b(2);
  }
  
  public void g()
  {
    AssistantUtils.a("AudioNewController", "message on finish, invoke session");
    a();
    b(1);
  }
  
  public void h()
  {
    this.e.a(null);
    AssistantUtils.a("AudioNewController", "message on finish, invoke session");
    a();
    b(1);
  }
  
  public VoicePttInfo i()
  {
    long l2 = this.e.c();
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = this.h.get();
    }
    return new VoicePttInfo(this.e.b(), l1, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.AudioNewController
 * JD-Core Version:    0.7.0.1
 */