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
  public volatile int a;
  protected AudioNewRecorder a;
  protected volatile AudioUploadThread a;
  protected volatile VoiceBeanProcessor a;
  protected volatile VoiceCacheHolder a;
  private IAudio2TextResultCallBack a;
  protected IVoiceVadListener a;
  protected volatile RecordParams.RecorderParam a;
  protected AtomicLong a;
  public volatile boolean a;
  protected AtomicLong b = new AtomicLong(0L);
  
  public AudioNewController()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam = new RecordParams.RecorderParam(16000, 16000, 1);
    this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder = new VoiceCacheHolder();
    VoiceTimeTraceUtil.a().a(this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder);
    this.jdField_a_of_type_Boolean = WakeManager.a().b;
  }
  
  protected int a(byte[] paramArrayOfByte)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceBeanProcessor != null))
    {
      VoiceBean localVoiceBean = new VoiceBean(AssistantUtils.a());
      VoiceTimeTraceUtil.a().a(localVoiceBean);
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceBeanProcessor.a(paramArrayOfByte);
      VoiceTimeTraceUtil.a().b(localVoiceBean);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceVadListener;
      if (localObject != null) {
        ((IVoiceVadListener)localObject).a(bool);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceBeanProcessor.a(paramArrayOfByte);
      localVoiceBean.a(((VoiceEncodeResult)localObject).jdField_a_of_type_ArrayOfByte, bool, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get(), paramArrayOfByte.length);
      VoiceTimeTraceUtil.a().c(localVoiceBean);
      AtomicLong localAtomicLong = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong;
      localAtomicLong.set(localAtomicLong.get() + paramArrayOfByte.length);
      this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a(paramArrayOfByte, localVoiceBean);
      return ((VoiceEncodeResult)localObject).jdField_a_of_type_Int;
    }
    return 2000;
  }
  
  public VoicePttInfo a()
  {
    long l2 = this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a();
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = this.b.get();
    }
    return new VoicePttInfo(this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a(), l1, this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam);
  }
  
  protected IRecordEventListener a()
  {
    return new AudioNewController.2(this);
  }
  
  public void a()
  {
    try
    {
      if ((a()) || (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewRecorder != null)) {
        c();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread != null)
      {
        AssistantUtils.a("AudioNewController", "quit voice transfer thread");
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread.a(null);
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread.a();
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder != null)
      {
        AssistantUtils.a("AudioNewController", "force clear voice cache");
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceBeanProcessor);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceBeanProcessor != null)
      {
        AssistantUtils.a("AudioNewController", "exit release silk encoder");
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceBeanProcessor.a();
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceBeanProcessor = null;
      }
      this.jdField_a_of_type_Int = -1;
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    try
    {
      if ((a()) || (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewRecorder != null)) {
        c();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invoked assistant recorder, type:");
      localStringBuilder.append(paramInt);
      AssistantUtils.a("AudioNewController", localStringBuilder.toString());
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(0L);
      this.b.set(0L);
      this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a();
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread = new AudioUploadThread(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder);
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread.a(this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIAudio2TextResultCallBack);
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread.start();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceBeanProcessor == null) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceBeanProcessor = new VoiceBeanProcessor(this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam);
      }
      this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewRecorder = new AudioNewRecorder(this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam);
      this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewRecorder.a(a());
      this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewRecorder.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam);
      return;
    }
    finally {}
  }
  
  public void a(IAudio2TextResultCallBack paramIAudio2TextResultCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIAudio2TextResultCallBack = paramIAudio2TextResultCallBack;
  }
  
  public void a(IVoiceVadListener paramIVoiceVadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIVoiceVadListener = paramIVoiceVadListener;
  }
  
  protected void a(RecordParams.RecorderParam paramRecorderParam, int paramInt)
  {
    if ((paramRecorderParam != null) && (paramRecorderParam.a != null))
    {
      paramRecorderParam.a[paramRecorderParam.f] = paramInt;
      if (paramRecorderParam.f < paramRecorderParam.a.length - 1) {
        paramRecorderParam.f += 1;
      }
    }
  }
  
  public void a(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ConfirmSendInfo))
    {
      paramObject = (ConfirmSendInfo)paramObject;
      this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a(paramObject);
    }
    AssistantUtils.a("AudioNewController", "message on finish, invoke session");
    a();
    b(1);
  }
  
  public boolean a()
  {
    AudioNewRecorder localAudioNewRecorder = this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewRecorder;
    if (localAudioNewRecorder != null) {
      return localAudioNewRecorder.a.get();
    }
    return false;
  }
  
  public boolean a(IRecordStreamListener paramIRecordStreamListener)
  {
    if ((a()) || (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewRecorder != null)) {
      c();
    }
    AssistantUtils.a("AudioNewController", "invoke wake recorder");
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewRecorder = new AudioNewRecorder();
    return this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewRecorder.a(paramIRecordStreamListener);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
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
      paramRecorderParam.a = new int[paramInt / 1000 * 10];
      paramRecorderParam.f = 0;
    }
  }
  
  protected void c()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewRecorder != null)
      {
        AssistantUtils.a("AudioNewController", "force release recorder...");
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewRecorder.a(null);
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewRecorder.a.set(false);
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewRecorder.a();
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewRecorder.b();
        this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioNewRecorder = null;
        this.jdField_a_of_type_Boolean = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d()
  {
    AssistantUtils.a("AudioNewController", "session on finish, invoke message");
    a();
    b(2);
  }
  
  public void e()
  {
    AssistantUtils.a("AudioNewController", "message on finish, invoke session");
    a();
    b(1);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantAudioVoiceCacheHolder.a(null);
    AssistantUtils.a("AudioNewController", "message on finish, invoke session");
    a();
    b(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.AudioNewController
 * JD-Core Version:    0.7.0.1
 */