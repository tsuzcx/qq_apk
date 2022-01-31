package com.tencent.mobileqq.richmedia.capture.audio;

import agsw;
import agsx;
import agsy;
import android.media.AudioRecord;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.qphone.base.util.QLog;

public class AudioCapture
{
  public static int a;
  public static int b;
  private agsy jdField_a_of_type_Agsy;
  public AudioRecord a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private AudioCapture.AudioCaptureListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$AudioCaptureListener;
  public AudioDataCache a;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private Thread jdField_a_of_type_JavaLangThread;
  public volatile boolean a;
  public byte[] a;
  private boolean b;
  public byte[] b;
  public int c;
  private boolean c;
  public int d;
  private boolean d;
  public int e = 0;
  public int f = 0;
  public volatile int g;
  private int h;
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
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.h = paramInt1;
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
        this.e = AudioRecord.getMinBufferSize(CodecParam.q, CodecParam.o, CodecParam.p);
        if ((this.e == -2) || (this.e == -1))
        {
          QLog.e("AudioCapture", 2, "getMinBufferSize error. mRecBufSize = " + this.e);
          bool = false;
          continue;
        }
        this.jdField_a_of_type_ArrayOfByte = new byte[this.e];
        m = jdField_a_of_type_Int / jdField_b_of_type_Int;
        if (this.e <= m)
        {
          m = jdField_a_of_type_Int;
          this.f = m;
          this.jdField_b_of_type_ArrayOfByte = new byte[this.f];
          this.jdField_b_of_type_Boolean = true;
          continue;
        }
        m = this.e;
      }
      finally {}
      int n = jdField_b_of_type_Int;
      m *= n;
    }
  }
  
  private void g()
  {
    this.e = 0;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.f = 0;
    this.jdField_b_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Agsy == null) {
      a(true);
    }
    if (this.jdField_a_of_type_Agsy != null) {
      this.jdField_a_of_type_Agsy.jdField_c_of_type_Boolean = true;
    }
    c();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == -3)
    {
      this.jdField_a_of_type_Boolean = false;
      this.g = -1;
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "checkAudioPrivilage[ERR_AUDIO_INVALID_OPERATION]: result=" + paramInt);
      }
      return;
    }
    if (paramInt == 0)
    {
      if (this.jdField_c_of_type_Int < 5)
      {
        this.jdField_c_of_type_Int += 1;
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      this.g = -2;
      return;
    }
    this.jdField_c_of_type_Int = 0;
    if (paramInt > 128) {}
    for (int m = 128;; m = paramInt)
    {
      boolean bool;
      if (!this.jdField_c_of_type_Boolean)
      {
        bool = CameraCompatibleList.a(CameraCompatibleList.p);
        if ((!bool) || (this.jdField_d_of_type_Int >= 5)) {
          break label279;
        }
        this.jdField_d_of_type_Boolean = PreviewContext.checkIsDisablePrivilage(this.jdField_a_of_type_ArrayOfByte, m);
        label137:
        this.jdField_d_of_type_Int += 1;
        if (this.jdField_d_of_type_Boolean) {
          break label287;
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
        QLog.d("AudioCapture", 2, "checkAudioPrivilage: mDisableAudioPrivilage=" + this.jdField_d_of_type_Boolean + " limit=" + m + " mAudioCanUsed=" + this.jdField_a_of_type_Boolean);
        return;
        label279:
        this.jdField_d_of_type_Boolean = false;
        break label137;
        label287:
        if ((this.jdField_d_of_type_Boolean) && (this.jdField_d_of_type_Int >= 5))
        {
          this.jdField_c_of_type_Boolean = true;
          this.jdField_a_of_type_Boolean = false;
          this.g = -3;
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
    //   2: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 116
    //   10: iconst_2
    //   11: new 118	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   18: ldc 192
    //   20: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: iload_1
    //   34: ifne +44 -> 78
    //   37: aload_0
    //   38: getfield 86	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_Agsy	Lagsy;
    //   41: ifnull +37 -> 78
    //   44: aload_0
    //   45: getfield 91	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   48: ifnull +30 -> 78
    //   51: aload_0
    //   52: getfield 91	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   55: invokevirtual 197	java/lang/Thread:isAlive	()Z
    //   58: ifeq +20 -> 78
    //   61: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   64: ifeq +11 -> 75
    //   67: ldc 116
    //   69: iconst_2
    //   70: ldc 199
    //   72: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: aload_0
    //   79: getfield 86	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_Agsy	Lagsy;
    //   82: ifnull +33 -> 115
    //   85: aload_0
    //   86: getfield 86	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_Agsy	Lagsy;
    //   89: iconst_1
    //   90: putfield 200	agsy:jdField_b_of_type_Boolean	Z
    //   93: aload_0
    //   94: getfield 86	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_Agsy	Lagsy;
    //   97: iconst_0
    //   98: putfield 201	agsy:jdField_a_of_type_Boolean	Z
    //   101: aload_0
    //   102: getfield 91	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   105: ifnull +10 -> 115
    //   108: aload_0
    //   109: getfield 91	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   112: invokevirtual 204	java/lang/Thread:interrupt	()V
    //   115: aload_0
    //   116: getfield 91	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   119: ifnull +10 -> 129
    //   122: aload_0
    //   123: getfield 91	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   126: invokevirtual 207	java/lang/Thread:join	()V
    //   129: aload_0
    //   130: new 145	agsy
    //   133: dup
    //   134: aload_0
    //   135: aconst_null
    //   136: invokespecial 210	agsy:<init>	(Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture;Lagsw;)V
    //   139: putfield 86	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_Agsy	Lagsy;
    //   142: aload_0
    //   143: aload_0
    //   144: getfield 86	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_Agsy	Lagsy;
    //   147: ldc 212
    //   149: iconst_5
    //   150: invokestatic 216	com/tencent/mobileqq/app/ThreadManager:newFreeThread	(Ljava/lang/Runnable;Ljava/lang/String;I)Ljava/lang/Thread;
    //   153: putfield 91	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   156: aload_0
    //   157: getfield 91	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   160: invokevirtual 219	java/lang/Thread:start	()V
    //   163: goto -88 -> 75
    //   166: astore_2
    //   167: aload_0
    //   168: monitorexit
    //   169: aload_2
    //   170: athrow
    //   171: astore_2
    //   172: aload_2
    //   173: invokevirtual 222	java/lang/InterruptedException:printStackTrace	()V
    //   176: goto -47 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	AudioCapture
    //   0	179	1	paramBoolean	boolean
    //   166	4	2	localObject	Object
    //   171	2	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	33	166	finally
    //   37	75	166	finally
    //   78	115	166	finally
    //   115	129	166	finally
    //   129	163	166	finally
    //   172	176	166	finally
    //   115	129	171	java/lang/InterruptedException
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte != null) && (paramInt > 0) && (paramInt <= paramArrayOfByte.length))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioDataCache == null) {
        break label52;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioDataCache.a(paramArrayOfByte, 0, paramInt);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$AudioCaptureListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$AudioCaptureListener.a(paramArrayOfByte, 0, paramInt);
      }
      return;
      label52:
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "AudioCapture[writeDataToAudioNewCache]: mAudioDataCache=null");
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Agsy != null) {
      this.jdField_a_of_type_Agsy.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Agsy != null)
    {
      this.jdField_a_of_type_Agsy.jdField_d_of_type_Boolean = false;
      synchronized (this.jdField_a_of_type_Agsy.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_Agsy.jdField_a_of_type_JavaLangObject.notifyAll();
        return;
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Agsy != null)
    {
      this.jdField_a_of_type_Agsy.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangThread.interrupt();
      this.jdField_a_of_type_Agsy = null;
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "openMic");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new agsw(this));
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "closeMic");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new agsx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.audio.AudioCapture
 * JD-Core Version:    0.7.0.1
 */