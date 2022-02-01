package com.tencent.mobileqq.videocodec.audio;

import android.media.AudioRecord;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.utils.NoiseSuppression;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWAudioEncoder;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWAudioEncoder.AudioEncodeListener;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class AudioCapture
  implements HWAudioEncoder.AudioEncodeListener
{
  public static int a;
  private static final SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINESE);
  public static int b;
  public AudioRecord a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private NoiseSuppression jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression = null;
  private AudioCapture.AudioCaptureListener jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$AudioCaptureListener;
  private AudioCapture.RecordRunnable jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$RecordRunnable;
  public AudioDataCache a;
  HWAudioEncoder jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder;
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
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean = false;
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
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_h_of_type_Int = paramInt1;
    this.jdField_i_of_type_Int = paramInt2;
    this.j = paramInt3;
    this.k = paramInt4;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$AudioCaptureListener = paramAudioCaptureListener;
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
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        boolean bool = this.jdField_b_of_type_Boolean;
        return bool;
      }
      this.jdField_e_of_type_Int = AudioRecord.getMinBufferSize(this.jdField_i_of_type_Int, CodecParam.mAudioChannel, CodecParam.mAudioFormat);
      if ((this.jdField_e_of_type_Int != -2) && (this.jdField_e_of_type_Int != -1))
      {
        this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_e_of_type_Int];
        int m = jdField_a_of_type_Int / jdField_b_of_type_Int;
        if (this.jdField_e_of_type_Int <= m) {
          m = jdField_a_of_type_Int;
        } else {
          m = this.jdField_e_of_type_Int * jdField_b_of_type_Int;
        }
        this.jdField_f_of_type_Int = m;
        this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_f_of_type_Int];
        this.jdField_b_of_type_Boolean = true;
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMinBufferSize error. mRecBufSize = ");
      localStringBuilder.append(this.jdField_e_of_type_Int);
      QLog.e("AudioCapture", 2, localStringBuilder.toString());
      return false;
    }
    finally {}
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
    return this.jdField_i_of_type_Int;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = this.jdField_i_of_type_Boolean;
    int m = 0;
    if (!bool) {
      return 0;
    }
    int n = paramInt % NoiseSuppression.jdField_a_of_type_Int;
    while (m < paramInt - n)
    {
      NoiseSuppression localNoiseSuppression = this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression;
      if (localNoiseSuppression != null) {
        localNoiseSuppression.a(paramArrayOfByte, m, NoiseSuppression.jdField_a_of_type_Int);
      }
      m += NoiseSuppression.jdField_a_of_type_Int;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("AudioNoiseSuppression[QQ]: remainder=");
      paramArrayOfByte.append(n);
      QLog.d("AudioCapture", 2, paramArrayOfByte.toString());
    }
    return n;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$RecordRunnable == null) {
      a(true);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$RecordRunnable;
    if (localObject != null) {
      ((AudioCapture.RecordRunnable)localObject).jdField_c_of_type_Boolean = true;
    }
    f();
    localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder;
    if (localObject != null) {
      ((HWAudioEncoder)localObject).a(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  void a(int paramInt)
  {
    if (paramInt == -3)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_g_of_type_Int = -1;
      return;
    }
    StringBuilder localStringBuilder;
    if (paramInt == 0)
    {
      int m = this.jdField_c_of_type_Int;
      if (m < 5)
      {
        this.jdField_c_of_type_Int = (m + 1);
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_g_of_type_Int = -2;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkAudioPrivilage[ERR_AUDIO_INVALID_DATA_LENGTH]: result=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" mAudioInvalidCount=");
        localStringBuilder.append(this.jdField_c_of_type_Int);
        QLog.d("AudioCapture", 2, localStringBuilder.toString());
      }
    }
    else
    {
      this.jdField_c_of_type_Int = 0;
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_d_of_type_Boolean = false;
        this.jdField_d_of_type_Int += 1;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkAudioPrivilage[ERR_AUDIO_INVALID_DATA]: result=");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" mAudioInvalidData=");
          localStringBuilder.append(this.jdField_d_of_type_Int);
          QLog.d("AudioCapture", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startCaptureThead, restart:");
        localStringBuilder.append(paramBoolean);
        QLog.d("AudioCapture", 2, localStringBuilder.toString());
      }
      if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$RecordRunnable != null) && (this.jdField_a_of_type_JavaLangThread != null) && (this.jdField_a_of_type_JavaLangThread.isAlive()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AudioCapture", 2, "startCaptureThead, thread is working.");
        }
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$RecordRunnable != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$RecordRunnable.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$RecordRunnable.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_JavaLangThread != null) {
          this.jdField_a_of_type_JavaLangThread.interrupt();
        }
      }
      try
      {
        if (this.jdField_a_of_type_JavaLangThread != null) {
          this.jdField_a_of_type_JavaLangThread.join();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$RecordRunnable = new AudioCapture.RecordRunnable(this);
      this.jdField_a_of_type_JavaLangThread = ThreadManager.newFreeThread(this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$RecordRunnable, "audio_capture", 5);
      this.jdField_a_of_type_JavaLangThread.start();
      if ((this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder == null))
      {
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder = new HWAudioEncoder();
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder.a(this.jdField_i_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder.a(this);
      }
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  void a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte != null) && (paramInt > 0) && (paramInt <= paramArrayOfByte.length))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDataCache;
      if (localObject != null) {
        ((AudioDataCache)localObject).a(paramArrayOfByte, 0, paramInt);
      } else if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "AudioCapture[writeDataToAudioNewCache]: mAudioDataCache=null");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder != null)
      {
        localObject = new byte[paramInt];
        System.arraycopy(paramArrayOfByte, 0, localObject, 0, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWAudioEncoder.a((byte[])localObject, 0L);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$AudioCaptureListener;
      if (localObject != null) {
        ((AudioCapture.AudioCaptureListener)localObject).onAudioFrames(paramArrayOfByte, 0, paramInt);
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "audio pause");
    }
    AudioCapture.RecordRunnable localRecordRunnable = this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$RecordRunnable;
    if (localRecordRunnable != null) {
      localRecordRunnable.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    AudioCapture.AudioCaptureListener localAudioCaptureListener = this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$AudioCaptureListener;
    if (localAudioCaptureListener != null) {
      localAudioCaptureListener.onEncodeAudioCaptured(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void d()
  {
    AudioCapture.AudioCaptureListener localAudioCaptureListener = this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$AudioCaptureListener;
    if (localAudioCaptureListener != null) {
      localAudioCaptureListener.onAudioError(-6);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "audio queueResume");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new AudioCapture.1(this));
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "audio resume");
    }
    ??? = this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$RecordRunnable;
    if (??? != null)
    {
      ((AudioCapture.RecordRunnable)???).jdField_d_of_type_Boolean = false;
      synchronized (((AudioCapture.RecordRunnable)???).jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$RecordRunnable.jdField_a_of_type_JavaLangObject.notifyAll();
        return;
      }
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$RecordRunnable != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, new Object[] { "audio, stopRecord, isRecording:", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$RecordRunnable.jdField_a_of_type_Boolean), " mIsVoiceRecognizerStat:", Boolean.valueOf(this.jdField_f_of_type_Boolean) });
      }
      this.jdField_f_of_type_Boolean = false;
      this.jdField_g_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$RecordRunnable.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangThread.interrupt();
      this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture$RecordRunnable = null;
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "openMic");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new AudioCapture.2(this));
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "closeMic");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new AudioCapture.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.audio.AudioCapture
 * JD-Core Version:    0.7.0.1
 */