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
  private Context jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  private volatile AudioRecord jdField_a_of_type_AndroidMediaAudioRecord;
  private AcousticEchoCanceler jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler;
  private volatile IRecordEventListener jdField_a_of_type_ComTencentMobileqqQassistantListenerIRecordEventListener;
  public AtomicBoolean a;
  public AtomicLong a;
  private volatile int b;
  
  public AudioNewRecorder()
  {
    this(1, 16000, 16, 2, 3200);
  }
  
  private AudioNewRecorder(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    if (paramInt5 == -1) {
      this.b = AudioRecord.getMinBufferSize(paramInt2, paramInt3, paramInt3);
    } else {
      this.b = paramInt5;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AudioNewRecorder, inited bufferSizeInBytes:");
    ((StringBuilder)localObject).append(this.b);
    AssistantUtils.a("AudioNewRecorder", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_AndroidMediaAudioRecord = new AudioRecord(paramInt1, paramInt2, paramInt3, paramInt4, this.b);
    if (Build.VERSION.SDK_INT >= 16)
    {
      jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioRecord.getAudioSessionId();
      if (this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler != null)
      {
        AssistantUtils.a("AudioNewRecorder", "echo canceler not null, release it");
        this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler.release();
        this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler = null;
      }
      if (AcousticEchoCanceler.isAvailable())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("create echo canceler, set enable true, session id:");
        ((StringBuilder)localObject).append(jdField_a_of_type_Int);
        AssistantUtils.a("AudioNewRecorder", ((StringBuilder)localObject).toString());
        this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler = AcousticEchoCanceler.create(jdField_a_of_type_Int);
      }
      else
      {
        AssistantUtils.a(false);
      }
      localObject = this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler;
      if (localObject != null) {
        ((AcousticEchoCanceler)localObject).setEnabled(true);
      } else {
        AssistantUtils.a("AudioNewRecorder", "echo canceler not available");
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public AudioNewRecorder(RecordParams.RecorderParam paramRecorderParam)
  {
    this(7, 16000, 16, 2, 6400);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject = new byte[this.b];
    System.currentTimeMillis();
    QQAudioUtils.a(this.jdField_a_of_type_AndroidContentContext, true);
    long l2 = 0L;
    double d = 0.0D;
    long l1 = 0L;
    while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      paramInt1 = this.jdField_a_of_type_AndroidMediaAudioRecord.read((byte[])localObject, 0, this.b);
      if (paramInt1 <= 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIRecordEventListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIRecordEventListener.a("readsize invalid...");
        }
        Thread.sleep(10L);
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIRecordEventListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIRecordEventListener.a((byte[])localObject, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get());
        }
        l2 += 1L;
        long l3 = paramInt1;
        l1 += l3;
        d += ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).getMillisecond(16000, 2, 2, l3);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(d);
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
      if (this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler != null) {
        this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler.setEnabled(false);
      }
      if (this.jdField_a_of_type_AndroidMediaAudioRecord != null)
      {
        this.jdField_a_of_type_AndroidMediaAudioRecord.stop();
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
    if (this.jdField_a_of_type_AndroidMediaAudioRecord.getState() != 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIRecordEventListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIRecordEventListener.a("AudioRecorder init state failure");
      }
      return;
    }
    ThreadManagerV2.excute(new AudioNewRecorder.2(this), 16, null, false);
  }
  
  public void a(IRecordEventListener paramIRecordEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQassistantListenerIRecordEventListener = paramIRecordEventListener;
  }
  
  public boolean a(IRecordStreamListener paramIRecordStreamListener)
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidMediaAudioRecord.getState() == 1) && (paramIRecordStreamListener != null))
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
      if (this.jdField_a_of_type_AndroidMediaAudioRecord != null) {
        this.jdField_a_of_type_AndroidMediaAudioRecord.stop();
      }
      if (this.jdField_a_of_type_AndroidMediaAudioRecord != null) {
        this.jdField_a_of_type_AndroidMediaAudioRecord.release();
      }
      if (this.jdField_a_of_type_AndroidMediaAudioRecord != null) {
        this.jdField_a_of_type_AndroidMediaAudioRecord = null;
      }
      if (this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler != null)
      {
        this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler.release();
        this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.AudioNewRecorder
 * JD-Core Version:    0.7.0.1
 */