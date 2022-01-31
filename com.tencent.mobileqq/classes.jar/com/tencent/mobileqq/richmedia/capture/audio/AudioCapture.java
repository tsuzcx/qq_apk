package com.tencent.mobileqq.richmedia.capture.audio;

import android.media.AudioRecord;
import android.os.Handler;
import avrs;
import avru;
import avzh;
import avzj;
import axhq;
import axim;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.utils.NoiseSuppression;
import com.tencent.qphone.base.util.QLog;

public class AudioCapture
  implements avzj
{
  public static int a;
  public static int b;
  public AudioRecord a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private avrs jdField_a_of_type_Avrs;
  public avru a;
  avzh jdField_a_of_type_Avzh;
  private AudioCapture.RecordRunnable jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable;
  private NoiseSuppression jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression;
  private String jdField_a_of_type_JavaLangString;
  private Thread jdField_a_of_type_JavaLangThread;
  public volatile boolean a;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  byte[] jdField_b_of_type_ArrayOfByte = null;
  public int c;
  private boolean c;
  public int d;
  private boolean d;
  int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean;
  public volatile int g;
  private boolean g;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int i;
  private int j;
  private int k;
  
  static
  {
    jdField_a_of_type_Int = 16384;
    jdField_b_of_type_Int = 4;
  }
  
  public AudioCapture(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, avrs paramavrs, Handler paramHandler)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_h_of_type_Int = paramInt1;
    this.i = paramInt2;
    this.j = paramInt3;
    this.k = paramInt4;
    this.jdField_a_of_type_Avrs = paramavrs;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    if (paramHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    }
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  private boolean a()
  {
    boolean bool = true;
    for (;;)
    {
      int m;
      try
      {
        if (this.jdField_b_of_type_Boolean)
        {
          bool = this.jdField_b_of_type_Boolean;
          return bool;
        }
        this.jdField_e_of_type_Int = AudioRecord.getMinBufferSize(this.i, axim.o, axim.p);
        if ((this.jdField_e_of_type_Int == -2) || (this.jdField_e_of_type_Int == -1))
        {
          QLog.e("AudioCapture", 2, "getMinBufferSize error. mRecBufSize = " + this.jdField_e_of_type_Int);
          bool = false;
          continue;
        }
        this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_e_of_type_Int];
        m = jdField_a_of_type_Int / jdField_b_of_type_Int;
        if (this.jdField_e_of_type_Int <= m)
        {
          m = jdField_a_of_type_Int;
          this.jdField_f_of_type_Int = m;
          this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_f_of_type_Int];
          this.jdField_b_of_type_Boolean = true;
          continue;
        }
        m = this.jdField_e_of_type_Int;
      }
      finally {}
      int n = jdField_b_of_type_Int;
      m *= n;
    }
  }
  
  private void j()
  {
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_f_of_type_Int = 0;
    this.jdField_b_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public int a()
  {
    return this.i;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    int m = 0;
    if (!this.jdField_h_of_type_Boolean) {
      return 0;
    }
    int n = paramInt % NoiseSuppression.jdField_a_of_type_Int;
    while (m < paramInt - n)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression.a(paramArrayOfByte, m, NoiseSuppression.jdField_a_of_type_Int);
      }
      m += NoiseSuppression.jdField_a_of_type_Int;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioNoiseSuppression[QQ]: remainder=" + n);
    }
    return n;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable == null) {
      b(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable.jdField_c_of_type_Boolean = true;
    }
    d();
    if (this.jdField_a_of_type_Avzh != null) {
      this.jdField_a_of_type_Avzh.a(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  void a(int paramInt)
  {
    if (paramInt == -3)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_g_of_type_Int = -1;
    }
    do
    {
      return;
      if (paramInt != 0) {
        break;
      }
      if (this.jdField_c_of_type_Int < 5)
      {
        this.jdField_c_of_type_Int += 1;
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_g_of_type_Int = -2;
    } while (!QLog.isColorLevel());
    QLog.d("AudioCapture", 2, "checkAudioPrivilage[ERR_AUDIO_INVALID_DATA_LENGTH]: result=" + paramInt + " mAudioInvalidCount=" + this.jdField_c_of_type_Int);
    return;
    this.jdField_c_of_type_Int = 0;
    if (paramInt > 128) {}
    for (int m = 128;; m = paramInt)
    {
      boolean bool;
      if (!this.jdField_c_of_type_Boolean)
      {
        bool = axhq.a(axhq.p);
        if ((!bool) || (this.jdField_d_of_type_Int >= 5)) {
          break label300;
        }
        this.jdField_d_of_type_Boolean = PreviewContext.checkIsDisablePrivilage(this.jdField_a_of_type_ArrayOfByte, m);
        label149:
        this.jdField_d_of_type_Int += 1;
        if (this.jdField_d_of_type_Boolean) {
          break label308;
        }
        this.jdField_c_of_type_Boolean = true;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AudioCapture", 2, "checkAudioPrivilage[ERR_AUDIO_INVALID_DATA]: result=" + paramInt + " mDisableAudioPrivilage=" + this.jdField_d_of_type_Boolean + " blackPhone=" + bool + " mAudioInvalidData=" + this.jdField_d_of_type_Int);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AudioCapture", 2, "checkAudioPrivilage: mDisableAudioPrivilage=" + this.jdField_d_of_type_Boolean + " limit=" + m + " mAudioCanUsed=" + this.jdField_a_of_type_Boolean + " result=" + paramInt);
        return;
        label300:
        this.jdField_d_of_type_Boolean = false;
        break label149;
        label308:
        if ((this.jdField_d_of_type_Boolean) && (this.jdField_d_of_type_Int >= 5))
        {
          this.jdField_c_of_type_Boolean = true;
          this.jdField_a_of_type_Boolean = false;
          this.jdField_g_of_type_Int = -3;
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    while (!this.jdField_h_of_type_Boolean) {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression = NoiseSuppression.a(BaseApplicationImpl.getContext());
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression != null) {
            this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression.a(16000);
          }
        }
        this.jdField_h_of_type_Boolean = paramBoolean;
        this.i = 16000;
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression = null;
        return;
      }
    }
    this.jdField_h_of_type_Boolean = paramBoolean;
    this.i = axim.q;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  void a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte != null) && (paramInt > 0) && (paramInt <= paramArrayOfByte.length))
    {
      if (this.jdField_a_of_type_Avru == null) {
        break label80;
      }
      this.jdField_a_of_type_Avru.a(paramArrayOfByte, 0, paramInt);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Avzh != null)
      {
        byte[] arrayOfByte = new byte[paramInt];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt);
        this.jdField_a_of_type_Avzh.a(arrayOfByte, 0L);
      }
      if (this.jdField_a_of_type_Avrs != null) {
        this.jdField_a_of_type_Avrs.a(paramArrayOfByte, 0, paramInt);
      }
      return;
      label80:
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "AudioCapture[writeDataToAudioNewCache]: mAudioDataCache=null");
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "audio pause");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable.jdField_d_of_type_Boolean = true;
    }
  }
  
  /* Error */
  public void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +29 -> 34
    //   8: ldc 114
    //   10: iconst_2
    //   11: new 116	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 273
    //   21: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_1
    //   25: invokevirtual 206	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   28: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: iload_1
    //   35: ifne +45 -> 80
    //   38: aload_0
    //   39: getfield 88	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable;
    //   42: ifnull +38 -> 80
    //   45: aload_0
    //   46: getfield 92	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   49: ifnull +31 -> 80
    //   52: aload_0
    //   53: getfield 92	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   56: invokevirtual 278	java/lang/Thread:isAlive	()Z
    //   59: ifeq +21 -> 80
    //   62: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   65: ifeq +12 -> 77
    //   68: ldc 114
    //   70: iconst_2
    //   71: ldc_w 280
    //   74: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: aload_0
    //   81: getfield 88	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable;
    //   84: ifnull +33 -> 117
    //   87: aload_0
    //   88: getfield 88	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable;
    //   91: iconst_1
    //   92: putfield 281	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable:jdField_b_of_type_Boolean	Z
    //   95: aload_0
    //   96: getfield 88	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable;
    //   99: iconst_0
    //   100: putfield 282	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable:jdField_a_of_type_Boolean	Z
    //   103: aload_0
    //   104: getfield 92	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   107: ifnull +10 -> 117
    //   110: aload_0
    //   111: getfield 92	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   114: invokevirtual 285	java/lang/Thread:interrupt	()V
    //   117: aload_0
    //   118: getfield 92	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   121: ifnull +10 -> 131
    //   124: aload_0
    //   125: getfield 92	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   128: invokevirtual 288	java/lang/Thread:join	()V
    //   131: aload_0
    //   132: new 167	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable
    //   135: dup
    //   136: aload_0
    //   137: invokespecial 290	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable:<init>	(Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture;)V
    //   140: putfield 88	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable;
    //   143: aload_0
    //   144: aload_0
    //   145: getfield 88	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable;
    //   148: ldc_w 292
    //   151: iconst_5
    //   152: invokestatic 296	com/tencent/mobileqq/app/ThreadManager:newFreeThread	(Ljava/lang/Runnable;Ljava/lang/String;I)Ljava/lang/Thread;
    //   155: putfield 92	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   158: aload_0
    //   159: getfield 92	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   162: invokevirtual 299	java/lang/Thread:start	()V
    //   165: aload_0
    //   166: getfield 242	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_g_of_type_Boolean	Z
    //   169: ifeq -92 -> 77
    //   172: aload_0
    //   173: getfield 172	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_Avzh	Lavzh;
    //   176: ifnonnull -99 -> 77
    //   179: aload_0
    //   180: new 176	avzh
    //   183: dup
    //   184: invokespecial 300	avzh:<init>	()V
    //   187: putfield 172	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_Avzh	Lavzh;
    //   190: aload_0
    //   191: getfield 172	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_Avzh	Lavzh;
    //   194: aload_0
    //   195: getfield 56	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:i	I
    //   198: invokevirtual 302	avzh:a	(I)V
    //   201: aload_0
    //   202: getfield 172	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_Avzh	Lavzh;
    //   205: aload_0
    //   206: invokevirtual 305	avzh:a	(Lavzj;)V
    //   209: goto -132 -> 77
    //   212: astore_2
    //   213: aload_0
    //   214: monitorexit
    //   215: aload_2
    //   216: athrow
    //   217: astore_2
    //   218: aload_2
    //   219: invokevirtual 306	java/lang/InterruptedException:printStackTrace	()V
    //   222: goto -91 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	AudioCapture
    //   0	225	1	paramBoolean	boolean
    //   212	4	2	localObject	Object
    //   217	2	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	34	212	finally
    //   38	77	212	finally
    //   80	117	212	finally
    //   117	131	212	finally
    //   131	209	212	finally
    //   218	222	212	finally
    //   117	131	217	java/lang/InterruptedException
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "audio queueResume");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new AudioCapture.1(this));
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "audio resume");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable.jdField_d_of_type_Boolean = false;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable.jdField_a_of_type_JavaLangObject.notifyAll();
        return;
      }
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, new Object[] { "audio, stopRecord, isRecording:", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable.jdField_a_of_type_Boolean), " mIsVoiceRecognizerStat:", Boolean.valueOf(this.jdField_f_of_type_Boolean) });
      }
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangThread.interrupt();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable = null;
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "openMic");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new AudioCapture.2(this));
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "closeMic");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new AudioCapture.3(this));
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Avrs != null) {
      this.jdField_a_of_type_Avrs.c(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Avrs != null) {
      this.jdField_a_of_type_Avrs.a(-6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.audio.AudioCapture
 * JD-Core Version:    0.7.0.1
 */