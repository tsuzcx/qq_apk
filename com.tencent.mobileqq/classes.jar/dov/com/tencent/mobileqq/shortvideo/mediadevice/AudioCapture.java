package dov.com.tencent.mobileqq.shortvideo.mediadevice;

import alpo;
import android.content.Context;
import android.media.AudioRecord;
import android.os.SystemClock;
import azbp;
import azcw;
import azds;
import bnma;
import bnmn;
import bnms;
import bnmu;
import bnmw;
import bnnm;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.maxvideo.common.ControlFlagEnum;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import java.util.concurrent.atomic.AtomicReference;

public class AudioCapture
  extends azbp
{
  public static int a;
  public static int b;
  public static boolean d;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  AudioRecord jdField_a_of_type_AndroidMediaAudioRecord;
  Object jdField_a_of_type_JavaLangObject = new Object();
  public AtomicReference<SVHwEncoder> a;
  volatile boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  long jdField_b_of_type_Long;
  public AtomicReference<bnnm> b;
  boolean jdField_b_of_type_Boolean = false;
  byte[] jdField_b_of_type_ArrayOfByte = null;
  public int c;
  boolean c;
  public int d;
  int e;
  public volatile boolean e;
  int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean;
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
    this.jdField_e_of_type_Int = 0;
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
  
  public void a(bnms parambnms)
  {
    a(parambnms, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
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
      ((AVIOStruct)localObject).aBitrate = azds.n;
      ((AVIOStruct)localObject).pCodec = azds.jdField_b_of_type_Int;
      ((AVIOStruct)localObject).pControlFlag = ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue();
      ((AVIOStruct)localObject).aChannel = azds.o;
      ((AVIOStruct)localObject).aFormat = azds.p;
      ((AVIOStruct)localObject).aSampleRate = azds.q;
      if ((paramArrayOfByte != null) && (paramInt1 > 0))
      {
        byte[] arrayOfByte = new byte[paramInt1];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt1);
        bnmw.a().a().handleAudio(arrayOfByte, (AVIOStruct)localObject, (int)paramLong);
        paramArrayOfByte = (SVHwEncoder)this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
        if (paramArrayOfByte != null)
        {
          localObject = new bnmn();
          ((bnmn)localObject).jdField_a_of_type_ArrayOfByte = arrayOfByte;
          ((bnmn)localObject).jdField_a_of_type_Int = 0;
          ((bnmn)localObject).jdField_b_of_type_Int = arrayOfByte.length;
          ((bnmn)localObject).jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          ((bnmn)localObject).jdField_a_of_type_Boolean = false;
          ((bnmn)localObject).jdField_b_of_type_Boolean = false;
          paramArrayOfByte.a((bnmn)localObject, false);
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
    this.jdField_i_of_type_Boolean = RMVideoStateMgr.a().a(6);
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
    this.jdField_d_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
  }
  
  void b(int paramInt)
  {
    if (paramInt == -3)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_i_of_type_Int = -1;
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
        bool = azcw.a(azcw.p);
        if ((!bool) || (this.jdField_d_of_type_Int >= 5)) {
          break label303;
        }
        this.jdField_h_of_type_Boolean = PreviewContext.checkIsDisablePrivilage(this.jdField_a_of_type_ArrayOfByte, j);
        label153:
        this.jdField_d_of_type_Int += 1;
        if (this.jdField_h_of_type_Boolean) {
          break label311;
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
        label303:
        this.jdField_h_of_type_Boolean = false;
        break label153;
        label311:
        if ((this.jdField_h_of_type_Boolean) && (this.jdField_d_of_type_Int >= 5))
        {
          this.jdField_g_of_type_Boolean = true;
          this.jdField_e_of_type_Boolean = false;
          this.jdField_i_of_type_Int = -3;
        }
      }
    }
  }
  
  public void b(bnms parambnms)
  {
    a(parambnms);
  }
  
  void b(byte[] paramArrayOfByte, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramInt1 > 0) && (paramInt1 <= paramArrayOfByte.length))
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference.get() == null) {
        break label59;
      }
      ((bnnm)this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).a(paramArrayOfByte, 0, paramInt1);
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
        this.jdField_e_of_type_Int = AudioRecord.getMinBufferSize(azds.q, azds.o, azds.p);
        if ((this.jdField_e_of_type_Int == -2) || (this.jdField_e_of_type_Int == -1))
        {
          if (bnmw.a().a().a(this, 3, "init audio failed")) {
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
        a(6, new Object[] { alpo.a(2131701160) });
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
  
  void c(byte[] paramArrayOfByte, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_i_of_type_Boolean)
    {
      b(paramArrayOfByte, paramInt1, paramLong, paramBoolean, paramInt2);
      return;
    }
    a(paramArrayOfByte, paramInt1, paramLong, paramBoolean, paramInt2);
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[openMic]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.jdField_c_of_type_Boolean + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      try
      {
        b();
        this.jdField_a_of_type_AndroidMediaAudioRecord = new AudioRecord(1, azds.q, azds.o, azds.p, this.jdField_e_of_type_Int);
        if (this.jdField_a_of_type_AndroidMediaAudioRecord.getState() == 0)
        {
          a(5, new Object[] { alpo.a(2131701159) });
          return false;
        }
      }
      catch (Exception localException)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, localException, new Object[0]);
        a(5, new Object[] { alpo.a(2131701157) });
        return false;
      }
      this.jdField_b_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[openMic]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.jdField_c_of_type_Boolean + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
    }
    return true;
  }
  
  public void d()
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
  
  public void e()
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
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[destory]: isCreate=" + this.jdField_b_of_type_Boolean + " isStart=" + this.jdField_c_of_type_Boolean + " mAudioRecord=" + this.jdField_a_of_type_AndroidMediaAudioRecord);
    }
    this.jdField_a_of_type_Boolean = false;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      d();
      e();
      this.jdField_g_of_type_Int = 0;
      this.jdField_h_of_type_Int = 0;
      return;
    }
  }
  
  public void g()
  {
    if (!bnmu.jdField_a_of_type_Boolean) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      a(1, new Object[] { Integer.valueOf(0) });
      return;
    }
  }
  
  public void h()
  {
    if (bnmu.jdField_a_of_type_Boolean) {
      return;
    }
    a(2, new Object[] { Integer.valueOf(0) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture
 * JD-Core Version:    0.7.0.1
 */