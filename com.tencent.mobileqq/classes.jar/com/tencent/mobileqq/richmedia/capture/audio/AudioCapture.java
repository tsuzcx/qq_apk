package com.tencent.mobileqq.richmedia.capture.audio;

import android.media.AudioRecord;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWAudioEncoder;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWAudioEncoder.AudioEncodeListener;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.utils.NoiseSuppression;
import com.tencent.qphone.base.util.QLog;

public class AudioCapture
  implements HWAudioEncoder.AudioEncodeListener
{
  public static int a;
  public static int b;
  public AudioRecord a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private AudioCapture.AudioCaptureListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$AudioCaptureListener;
  private AudioCapture.RecordRunnable jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable;
  public AudioDataCache a;
  HWAudioEncoder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioEncoder;
  private NoiseSuppression jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression = null;
  private String jdField_a_of_type_JavaLangString;
  private Thread jdField_a_of_type_JavaLangThread;
  public volatile boolean a;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  byte[] jdField_b_of_type_ArrayOfByte = null;
  public int c;
  private boolean c;
  public int d;
  private boolean d;
  int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean = false;
  public volatile int g;
  private boolean g;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean = false;
  private int i;
  private int j;
  private int k;
  
  static
  {
    jdField_a_of_type_Int = 16384;
    jdField_b_of_type_Int = 4;
  }
  
  public AudioCapture(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, AudioCapture.AudioCaptureListener paramAudioCaptureListener, Handler paramHandler)
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_g_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_h_of_type_Int = paramInt1;
    this.i = paramInt2;
    this.j = paramInt3;
    this.k = paramInt4;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$AudioCaptureListener = paramAudioCaptureListener;
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
        this.jdField_e_of_type_Int = AudioRecord.getMinBufferSize(this.i, CodecParam.mAudioChannel, CodecParam.mAudioFormat);
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
      a(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable.jdField_c_of_type_Boolean = true;
    }
    d();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioEncoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioEncoder.a(this.jdField_b_of_type_JavaLangString);
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
        bool = CameraCompatibleList.a(CameraCompatibleList.p);
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
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 126
    //   10: iconst_2
    //   11: new 128	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   18: ldc 225
    //   20: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 209	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: iload_1
    //   34: ifne +44 -> 78
    //   37: aload_0
    //   38: getfield 102	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable;
    //   41: ifnull +37 -> 78
    //   44: aload_0
    //   45: getfield 106	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   48: ifnull +30 -> 78
    //   51: aload_0
    //   52: getfield 106	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   55: invokevirtual 230	java/lang/Thread:isAlive	()Z
    //   58: ifeq +20 -> 78
    //   61: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   64: ifeq +11 -> 75
    //   67: ldc 126
    //   69: iconst_2
    //   70: ldc 232
    //   72: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: aload_0
    //   79: getfield 102	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable;
    //   82: ifnull +33 -> 115
    //   85: aload_0
    //   86: getfield 102	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable;
    //   89: iconst_1
    //   90: putfield 233	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable:jdField_b_of_type_Boolean	Z
    //   93: aload_0
    //   94: getfield 102	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable;
    //   97: iconst_0
    //   98: putfield 234	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable:jdField_a_of_type_Boolean	Z
    //   101: aload_0
    //   102: getfield 106	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   105: ifnull +10 -> 115
    //   108: aload_0
    //   109: getfield 106	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   112: invokevirtual 237	java/lang/Thread:interrupt	()V
    //   115: aload_0
    //   116: getfield 106	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   119: ifnull +10 -> 129
    //   122: aload_0
    //   123: getfield 106	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   126: invokevirtual 240	java/lang/Thread:join	()V
    //   129: aload_0
    //   130: new 171	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable
    //   133: dup
    //   134: aload_0
    //   135: invokespecial 242	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable:<init>	(Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture;)V
    //   138: putfield 102	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable;
    //   141: aload_0
    //   142: aload_0
    //   143: getfield 102	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable;
    //   146: ldc 244
    //   148: iconst_5
    //   149: invokestatic 248	com/tencent/mobileqq/app/ThreadManager:newFreeThread	(Ljava/lang/Runnable;Ljava/lang/String;I)Ljava/lang/Thread;
    //   152: putfield 106	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   155: aload_0
    //   156: getfield 106	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   159: invokevirtual 251	java/lang/Thread:start	()V
    //   162: aload_0
    //   163: getfield 68	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_g_of_type_Boolean	Z
    //   166: ifeq -91 -> 75
    //   169: aload_0
    //   170: getfield 176	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioEncoder	Lcom/tencent/mobileqq/richmedia/mediacodec/recorder/HWAudioEncoder;
    //   173: ifnonnull -98 -> 75
    //   176: aload_0
    //   177: new 180	com/tencent/mobileqq/richmedia/mediacodec/recorder/HWAudioEncoder
    //   180: dup
    //   181: invokespecial 252	com/tencent/mobileqq/richmedia/mediacodec/recorder/HWAudioEncoder:<init>	()V
    //   184: putfield 176	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioEncoder	Lcom/tencent/mobileqq/richmedia/mediacodec/recorder/HWAudioEncoder;
    //   187: aload_0
    //   188: getfield 176	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioEncoder	Lcom/tencent/mobileqq/richmedia/mediacodec/recorder/HWAudioEncoder;
    //   191: aload_0
    //   192: getfield 78	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:i	I
    //   195: invokevirtual 254	com/tencent/mobileqq/richmedia/mediacodec/recorder/HWAudioEncoder:a	(I)V
    //   198: aload_0
    //   199: getfield 176	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioEncoder	Lcom/tencent/mobileqq/richmedia/mediacodec/recorder/HWAudioEncoder;
    //   202: aload_0
    //   203: invokevirtual 257	com/tencent/mobileqq/richmedia/mediacodec/recorder/HWAudioEncoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/recorder/HWAudioEncoder$AudioEncodeListener;)V
    //   206: goto -131 -> 75
    //   209: astore_2
    //   210: aload_0
    //   211: monitorexit
    //   212: aload_2
    //   213: athrow
    //   214: astore_2
    //   215: aload_2
    //   216: invokevirtual 260	java/lang/InterruptedException:printStackTrace	()V
    //   219: goto -90 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	AudioCapture
    //   0	222	1	paramBoolean	boolean
    //   209	4	2	localObject	Object
    //   214	2	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	33	209	finally
    //   37	75	209	finally
    //   78	115	209	finally
    //   115	129	209	finally
    //   129	206	209	finally
    //   215	219	209	finally
    //   115	129	214	java/lang/InterruptedException
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
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioDataCache == null) {
        break label80;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioDataCache.a(paramArrayOfByte, 0, paramInt);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioEncoder != null)
      {
        byte[] arrayOfByte = new byte[paramInt];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWAudioEncoder.a(arrayOfByte, 0L);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$AudioCaptureListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$AudioCaptureListener.onAudioFrames(paramArrayOfByte, 0, paramInt);
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
  
  public void b(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "audio queueResume");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new AudioCapture.1(this));
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
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$AudioCaptureListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$AudioCaptureListener.onEncodeAudioCaptured(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$AudioCaptureListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$AudioCaptureListener.onAudioError(-6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.audio.AudioCapture
 * JD-Core Version:    0.7.0.1
 */