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
  public static int a = 160768;
  public static int b = 4;
  public static boolean d = true;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  AudioRecord jdField_a_of_type_AndroidMediaAudioRecord;
  Object jdField_a_of_type_JavaLangObject = new Object();
  public AtomicReference<SVHwEncoder> a;
  volatile boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  long jdField_b_of_type_Long;
  public AtomicReference<AudioDataCache> b;
  boolean jdField_b_of_type_Boolean = false;
  byte[] jdField_b_of_type_ArrayOfByte = null;
  public int c;
  boolean c;
  public int d = 0;
  int e;
  public volatile boolean e;
  int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean = false;
  int jdField_g_of_type_Int = 0;
  private boolean jdField_g_of_type_Boolean = false;
  int jdField_h_of_type_Int = 0;
  private boolean jdField_h_of_type_Boolean = false;
  public volatile int i;
  private boolean i;
  
  public AudioCapture(Context paramContext)
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_i_of_type_Int = 0;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference(null);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference(null);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_Int = 0;
    this.d = 0;
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt)
  {
    return 0;
  }
  
  public void a()
  {
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
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
      j = this.jdField_g_of_type_Int;
    }
    else
    {
      j = this.jdField_g_of_type_Int;
      this.jdField_g_of_type_Int = (j + 1);
    }
    ((AVIOStruct)localObject).pBlockIndex = j;
    int j = this.jdField_h_of_type_Int;
    this.jdField_h_of_type_Int = (j + 1);
    ((AVIOStruct)localObject).pFrameIndex = j;
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
      RecordManager.a().a().handleAudio(arrayOfByte, (AVIOStruct)localObject, (int)paramLong);
      paramArrayOfByte = (SVHwEncoder)this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
      if (paramArrayOfByte != null)
      {
        localObject = new SVHwEncoder.HwFrame();
        ((SVHwEncoder.HwFrame)localObject).jdField_a_of_type_ArrayOfByte = arrayOfByte;
        ((SVHwEncoder.HwFrame)localObject).jdField_a_of_type_Int = 0;
        ((SVHwEncoder.HwFrame)localObject).jdField_b_of_type_Int = arrayOfByte.length;
        ((SVHwEncoder.HwFrame)localObject).jdField_a_of_type_Long = SystemClock.elapsedRealtime();
        ((SVHwEncoder.HwFrame)localObject).jdField_a_of_type_Boolean = false;
        ((SVHwEncoder.HwFrame)localObject).jdField_b_of_type_Boolean = false;
        paramArrayOfByte.a((SVHwEncoder.HwFrame)localObject, false);
      }
      a(paramInt2, new Object[] { Integer.valueOf(0) });
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = RMVideoStateMgr.a().h();
    new AudioCapture.RecordThread2(this).start();
    return true;
  }
  
  public void b()
  {
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_f_of_type_Int = 0;
    this.jdField_b_of_type_ArrayOfByte = null;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.d = 0;
    this.jdField_h_of_type_Boolean = false;
  }
  
  void b(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (paramInt == -3)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_i_of_type_Int = -1;
    }
    else
    {
      int j;
      if (paramInt == 0)
      {
        j = this.jdField_c_of_type_Int;
        if (j < 5)
        {
          this.jdField_c_of_type_Int = (j + 1);
        }
        else
        {
          this.jdField_e_of_type_Boolean = false;
          this.jdField_i_of_type_Int = -2;
        }
      }
      else
      {
        this.jdField_c_of_type_Int = 0;
        j = 128;
        if (paramInt <= 128) {
          j = paramInt;
        }
        if (!this.jdField_g_of_type_Boolean)
        {
          boolean bool1 = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductFeature(CameraCompatibleConstants.p);
          if ((bool1) && (this.d < 5)) {
            this.jdField_h_of_type_Boolean = PreviewContext.checkIsDisablePrivilage(this.jdField_a_of_type_ArrayOfByte, j);
          } else {
            this.jdField_h_of_type_Boolean = false;
          }
          this.d += 1;
          boolean bool2 = this.jdField_h_of_type_Boolean;
          if (!bool2)
          {
            this.jdField_g_of_type_Boolean = true;
          }
          else if ((bool2) && (this.d >= 5))
          {
            this.jdField_g_of_type_Boolean = true;
            this.jdField_e_of_type_Boolean = false;
            this.jdField_i_of_type_Int = -3;
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkAudioPrivilage[ERR_AUDIO_INVALID_DATA]: result=");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(" mDisableAudioPrivilage=");
            localStringBuilder.append(this.jdField_h_of_type_Boolean);
            localStringBuilder.append(" blackPhone=");
            localStringBuilder.append(bool1);
            localStringBuilder.append(" mAudioInvalidData=");
            localStringBuilder.append(this.d);
            QLog.d("AudioCapture", 2, localStringBuilder.toString());
          }
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkAudioPrivilage: mDisableAudioPrivilage=");
          localStringBuilder.append(this.jdField_h_of_type_Boolean);
          localStringBuilder.append(" limit=");
          localStringBuilder.append(j);
          localStringBuilder.append(" mAudioCanUsed=");
          localStringBuilder.append(this.jdField_e_of_type_Boolean);
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
      localStringBuilder.append(this.jdField_e_of_type_Boolean);
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
      if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null) {
        ((AudioDataCache)this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).a(paramArrayOfByte, 0, paramInt1);
      } else if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "AudioCapture[writeDataToAudioNewCache]: mAudioDataCache=null");
      }
      a(paramInt2, new Object[] { Integer.valueOf(0) });
    }
  }
  
  public boolean b()
  {
    try
    {
      if (this.jdField_f_of_type_Boolean)
      {
        boolean bool = this.jdField_f_of_type_Boolean;
        return bool;
      }
      this.jdField_e_of_type_Int = AudioRecord.getMinBufferSize(CodecParam.mAudioSampleRate, CodecParam.mAudioChannel, CodecParam.mAudioFormat);
      if ((this.jdField_e_of_type_Int != -2) && (this.jdField_e_of_type_Int != -1))
      {
        this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_e_of_type_Int];
        int j = jdField_a_of_type_Int / jdField_b_of_type_Int;
        if (this.jdField_e_of_type_Int <= j) {
          j = jdField_a_of_type_Int;
        } else {
          j = this.jdField_e_of_type_Int * jdField_b_of_type_Int;
        }
        this.jdField_f_of_type_Int = j;
        this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_f_of_type_Int];
        this.jdField_f_of_type_Boolean = true;
        a(3, new Object[] { Boolean.valueOf(true), Integer.valueOf(0) });
        return true;
      }
      if (!RecordManager.a().a().a(this, 3, "init audio failed")) {
        a(3, new Object[] { "init audio failed" });
      }
      return false;
    }
    finally {}
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("AudioCapture[openMic]: isCreate=");
      localStringBuilder1.append(this.jdField_b_of_type_Boolean);
      localStringBuilder1.append(" isStart=");
      localStringBuilder1.append(this.jdField_c_of_type_Boolean);
      localStringBuilder1.append(" mAudioRecord=");
      localStringBuilder1.append(this.jdField_a_of_type_AndroidMediaAudioRecord);
      QLog.d("AudioCapture", 2, localStringBuilder1.toString());
    }
    if (!this.jdField_b_of_type_Boolean) {
      try
      {
        b();
        this.jdField_a_of_type_AndroidMediaAudioRecord = new AudioRecord(1, CodecParam.mAudioSampleRate, CodecParam.mAudioChannel, CodecParam.mAudioFormat, this.jdField_e_of_type_Int);
        if (this.jdField_a_of_type_AndroidMediaAudioRecord.getState() == 0)
        {
          a(5, new Object[] { HardCodeUtil.a(2131701009) });
          return;
        }
        this.jdField_b_of_type_Boolean = true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        a(5, new Object[] { HardCodeUtil.a(2131701012) });
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("AudioCapture[openMic]: isCreate=");
      localStringBuilder2.append(this.jdField_b_of_type_Boolean);
      localStringBuilder2.append(" isStart=");
      localStringBuilder2.append(this.jdField_c_of_type_Boolean);
      localStringBuilder2.append(" mAudioRecord=");
      localStringBuilder2.append(this.jdField_a_of_type_AndroidMediaAudioRecord);
      QLog.d("AudioCapture", 2, localStringBuilder2.toString());
    }
  }
  
  void c(byte[] paramArrayOfByte, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_i_of_type_Boolean)
    {
      b(paramArrayOfByte, paramInt1, paramLong, paramBoolean, paramInt2);
      return;
    }
    a(paramArrayOfByte, paramInt1, paramLong, paramBoolean, paramInt2);
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AudioCapture[startMic]: isCreate=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(" isStart=");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
      ((StringBuilder)localObject).append(" mAudioRecord=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidMediaAudioRecord);
      QLog.d("AudioCapture", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidMediaAudioRecord;
    if ((localObject != null) && (this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean)) {
      try
      {
        ((AudioRecord)localObject).startRecording();
        this.jdField_c_of_type_Boolean = true;
        a(6, new Object[] { Boolean.valueOf(true) });
      }
      catch (IllegalStateException localIllegalStateException)
      {
        this.jdField_c_of_type_Boolean = false;
        localIllegalStateException.printStackTrace();
        try
        {
          this.jdField_a_of_type_AndroidMediaAudioRecord.release();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        a(6, new Object[] { HardCodeUtil.a(2131701013) });
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AudioCapture[startMic]: isCreate=");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append(" isStart=");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      localStringBuilder.append(" mAudioRecord=");
      localStringBuilder.append(this.jdField_a_of_type_AndroidMediaAudioRecord);
      QLog.d("AudioCapture", 2, localStringBuilder.toString());
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AudioCapture[stopMic]: isCreate=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(" isStart=");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
      ((StringBuilder)localObject).append(" mAudioRecord=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidMediaAudioRecord);
      QLog.d("AudioCapture", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidMediaAudioRecord;
    if ((localObject != null) && (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      ((AudioRecord)localObject).stop();
      this.jdField_c_of_type_Boolean = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AudioCapture[stopMic]: isCreate=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(" isStart=");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
      ((StringBuilder)localObject).append(" mAudioRecord=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidMediaAudioRecord);
      QLog.d("AudioCapture", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void f()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AudioCapture[releaseMic]: isCreate=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(" isStart=");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
      ((StringBuilder)localObject).append(" mAudioRecord=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidMediaAudioRecord);
      QLog.d("AudioCapture", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidMediaAudioRecord;
    if (localObject != null)
    {
      ((AudioRecord)localObject).release();
      this.jdField_a_of_type_AndroidMediaAudioRecord = null;
      this.jdField_b_of_type_Boolean = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AudioCapture[releaseMic]: isCreate=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(" isStart=");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
      ((StringBuilder)localObject).append(" mAudioRecord=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidMediaAudioRecord);
      QLog.d("AudioCapture", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void g()
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("AudioCapture[destory]: isCreate=");
      ((StringBuilder)???).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)???).append(" isStart=");
      ((StringBuilder)???).append(this.jdField_c_of_type_Boolean);
      ((StringBuilder)???).append(" mAudioRecord=");
      ((StringBuilder)???).append(this.jdField_a_of_type_AndroidMediaAudioRecord);
      QLog.d("AudioCapture", 2, ((StringBuilder)???).toString());
    }
    this.jdField_a_of_type_Boolean = false;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      e();
      f();
      this.jdField_g_of_type_Int = 0;
      this.jdField_h_of_type_Int = 0;
      return;
    }
  }
  
  public void h()
  {
    if (!Lock.jdField_a_of_type_Boolean) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      a(1, new Object[] { Integer.valueOf(0) });
      return;
    }
  }
  
  public void i()
  {
    if (Lock.jdField_a_of_type_Boolean) {
      return;
    }
    a(2, new Object[] { Integer.valueOf(0) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture
 * JD-Core Version:    0.7.0.1
 */