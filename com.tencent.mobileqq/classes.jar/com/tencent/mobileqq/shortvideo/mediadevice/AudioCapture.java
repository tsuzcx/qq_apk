package com.tencent.mobileqq.shortvideo.mediadevice;

import aibz;
import android.content.Context;
import android.media.AudioRecord;
import android.os.SystemClock;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.maxvideo.common.ControlFlagEnum;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
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
  public static int a;
  public static int b;
  public static boolean d;
  public long a;
  Context a;
  public AudioRecord a;
  public Object a;
  public AtomicReference a;
  public volatile boolean a;
  public byte[] a;
  public long b;
  public AtomicReference b;
  boolean b;
  public byte[] b;
  public int c;
  boolean c;
  public int d;
  public int e;
  public volatile boolean e;
  public int f;
  private boolean f;
  int jdField_g_of_type_Int = 0;
  private boolean jdField_g_of_type_Boolean;
  int jdField_h_of_type_Int = 0;
  private boolean jdField_h_of_type_Boolean;
  public volatile int i;
  private boolean i;
  
  static
  {
    jdField_a_of_type_Int = 160768;
    jdField_b_of_type_Int = 4;
    jdField_d_of_type_Boolean = true;
  }
  
  public AudioCapture(Context paramContext)
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_b_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference(null);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference(null);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
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
    int j;
    if (paramBoolean) {
      j = this.jdField_g_of_type_Int;
    }
    for (;;)
    {
      ((AVIOStruct)localObject).pBlockIndex = j;
      j = this.jdField_h_of_type_Int;
      this.jdField_h_of_type_Int = (j + 1);
      ((AVIOStruct)localObject).pFrameIndex = j;
      ((AVIOStruct)localObject).aBitrate = CodecParam.n;
      ((AVIOStruct)localObject).pCodec = CodecParam.jdField_b_of_type_Int;
      ((AVIOStruct)localObject).pControlFlag = ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue();
      ((AVIOStruct)localObject).aChannel = CodecParam.o;
      ((AVIOStruct)localObject).aFormat = CodecParam.p;
      ((AVIOStruct)localObject).aSampleRate = CodecParam.q;
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
      return;
      j = this.jdField_g_of_type_Int;
      this.jdField_g_of_type_Int = (j + 1);
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = RMVideoStateMgr.a().b(6);
    new aibz(this).start();
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
    this.jdField_d_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
  }
  
  public void b(int paramInt)
  {
    if (paramInt == -3)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_i_of_type_Int = -1;
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "checkAudioPrivilage[ERR_AUDIO_INVALID_OPERATION]: result=" + paramInt);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "checkAudioPrivilage[end]: result=" + paramInt + " mAudioCanUsed=" + this.jdField_e_of_type_Boolean);
      }
      return;
      if (paramInt != 0) {
        break;
      }
      if (this.jdField_c_of_type_Int < 5)
      {
        this.jdField_c_of_type_Int += 1;
      }
      else
      {
        this.jdField_e_of_type_Boolean = false;
        this.jdField_i_of_type_Int = -2;
      }
    }
    this.jdField_c_of_type_Int = 0;
    if (paramInt > 128) {}
    for (int j = 128;; j = paramInt)
    {
      boolean bool;
      if (!this.jdField_g_of_type_Boolean)
      {
        bool = CameraCompatibleList.a(CameraCompatibleList.p);
        if ((!bool) || (this.jdField_d_of_type_Int >= 5)) {
          break label334;
        }
        this.jdField_h_of_type_Boolean = PreviewContext.checkIsDisablePrivilage(this.jdField_a_of_type_ArrayOfByte, j);
        label184:
        this.jdField_d_of_type_Int += 1;
        if (this.jdField_h_of_type_Boolean) {
          break label342;
        }
        this.jdField_g_of_type_Boolean = true;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AudioCapture", 2, "checkAudioPrivilage[ERR_AUDIO_INVALID_DATA]: result=" + paramInt + " mDisableAudioPrivilage=" + this.jdField_h_of_type_Boolean + " blackPhone=" + bool + " mAudioInvalidData=" + this.jdField_d_of_type_Int);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AudioCapture", 2, "checkAudioPrivilage: mDisableAudioPrivilage=" + this.jdField_h_of_type_Boolean + " limit=" + j + " mAudioCanUsed=" + this.jdField_e_of_type_Boolean);
        break;
        label334:
        this.jdField_h_of_type_Boolean = false;
        break label184;
        label342:
        if ((this.jdField_h_of_type_Boolean) && (this.jdField_d_of_type_Int >= 5))
        {
          this.jdField_g_of_type_Boolean = true;
          this.jdField_e_of_type_Boolean = false;
          this.jdField_i_of_type_Int = -3;
        }
      }
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
      if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference.get() == null) {
        break label59;
      }
      ((AudioDataCache)this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).a(paramArrayOfByte, 0, paramInt1);
    }
    for (;;)
    {
      a(paramInt2, new Object[] { Integer.valueOf(0) });
      return;
      label59:
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "AudioCapture[writeDataToAudioNewCache]: mAudioDataCache=null");
      }
    }
  }
  
  public boolean b()
  {
    boolean bool = true;
    for (;;)
    {
      int j;
      try
      {
        if (this.jdField_f_of_type_Boolean)
        {
          bool = this.jdField_f_of_type_Boolean;
          return bool;
        }
        this.jdField_e_of_type_Int = AudioRecord.getMinBufferSize(CodecParam.q, CodecParam.o, CodecParam.p);
        if ((this.jdField_e_of_type_Int == -2) || (this.jdField_e_of_type_Int == -1))
        {
          if (RecordManager.a().a().a(this, 3, "init audio failed")) {
            break label187;
          }
          a(3, new Object[] { "init audio failed" });
          break label187;
        }
        this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_e_of_type_Int];
        j = jdField_a_of_type_Int / jdField_b_of_type_Int;
        if (this.jdField_e_of_type_Int <= j)
        {
          j = jdField_a_of_type_Int;
          this.jdField_f_of_type_Int = j;
          this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_f_of_type_Int];
          this.jdField_f_of_type_Boolean = true;
          a(3, new Object[] { Boolean.valueOf(true), Integer.valueOf(0) });
          continue;
        }
        j = this.jdField_e_of_type_Int;
      }
      finally {}
      int k = jdField_b_of_type_Int;
      j *= k;
      continue;
      label187:
      bool = false;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[openMic]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.jdField_c_of_type_Boolean + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
    }
    if (!this.jdField_b_of_type_Boolean) {}
    while (!QLog.isColorLevel())
    {
      try
      {
        b();
        this.jdField_a_of_type_AndroidMediaAudioRecord = new AudioRecord(1, CodecParam.q, CodecParam.o, CodecParam.p, this.jdField_e_of_type_Int);
        if (this.jdField_a_of_type_AndroidMediaAudioRecord.getState() == 0)
        {
          a(5, new Object[] { "打开麦克风失败" });
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        a(5, new Object[] { "打开麦克风失败" });
        return;
      }
      this.jdField_b_of_type_Boolean = true;
    }
    QLog.d("AudioCapture", 2, "AudioCapture[openMic]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.jdField_c_of_type_Boolean + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
  }
  
  public void c(byte[] paramArrayOfByte, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
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
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[startMic]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.jdField_c_of_type_Boolean + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
    }
    if ((this.jdField_a_of_type_AndroidMediaAudioRecord != null) && (this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean)) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaAudioRecord.startRecording();
        this.jdField_c_of_type_Boolean = true;
        a(6, new Object[] { Boolean.valueOf(true) });
        if (QLog.isColorLevel()) {
          QLog.d("AudioCapture", 2, "AudioCapture[startMic]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.jdField_c_of_type_Boolean + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
        }
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        this.jdField_c_of_type_Boolean = false;
        localIllegalStateException.printStackTrace();
      }
      try
      {
        this.jdField_a_of_type_AndroidMediaAudioRecord.release();
        a(6, new Object[] { "打开麦克风失败" });
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[stopMic]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.jdField_c_of_type_Boolean + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
    }
    if ((this.jdField_a_of_type_AndroidMediaAudioRecord != null) && (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidMediaAudioRecord.stop();
      this.jdField_c_of_type_Boolean = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[stopMic]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.jdField_c_of_type_Boolean + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
    }
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[releaseMic]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.jdField_c_of_type_Boolean + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
    }
    if (this.jdField_a_of_type_AndroidMediaAudioRecord != null)
    {
      this.jdField_a_of_type_AndroidMediaAudioRecord.release();
      this.jdField_a_of_type_AndroidMediaAudioRecord = null;
      this.jdField_b_of_type_Boolean = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[releaseMic]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.jdField_c_of_type_Boolean + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
    }
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[destory]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.jdField_c_of_type_Boolean + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture
 * JD-Core Version:    0.7.0.1
 */