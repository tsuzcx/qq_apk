package com.tencent.mobileqq.richmedia.mediacodec.recorder;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeInputSurface;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.HWVideoEncoder;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ThumbnailUtil;
import com.tencent.qphone.base.util.QLog;

@TargetApi(18)
public class HWVideoRecorder
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("recode_thread");
  private EncodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig;
  private EncodeInputSurface jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface;
  private HWVideoEncoder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderHWVideoEncoder;
  private HWEncodeListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener;
  private HWEncodeNextListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeNextListener;
  protected HWVideoRecorder.RecodeHandler a;
  private HWVideoRecorderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorderBuffer;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  private boolean c;
  private boolean d = false;
  
  public HWVideoRecorder()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder$RecodeHandler = a(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderHWVideoEncoder = new HWVideoEncoder();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface = new EncodeInputSurface();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorderBuffer = new HWVideoRecorderBuffer();
  }
  
  private void a(HWVideoRecorder.RecordingObj paramRecordingObj)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener = paramRecordingObj.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeNextListener = paramRecordingObj.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeNextListener;
    paramRecordingObj = paramRecordingObj.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig;
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "handleStartRecording EGLContext = " + paramRecordingObj.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      e();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig = paramRecordingObj;
    this.jdField_a_of_type_JavaLangString = paramRecordingObj.jdField_a_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderHWVideoEncoder.a(paramRecordingObj);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface.a(paramRecordingObj, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderHWVideoEncoder.a());
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener.onEncodeStart();
      }
      this.b = true;
      this.c = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("HWVideoRecorder", 2, "handleStartRecording: exception at start. encodeConfig = " + paramRecordingObj, localThrowable);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener.onEncodeError(1, localThrowable);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "handleStopRecording");
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    while (!QLog.isColorLevel()) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderHWVideoEncoder.b();
        if (QLog.isColorLevel()) {
          QLog.w("HWVideoRecorder", 2, "handleStopRecording complete");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderMediaMuxerWrapper == null))
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener.onEncodeFinish(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener = null;
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface.a();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeNextListener = null;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HWVideoRecorder", 2, "handleStopRecording: exception. config = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener.onEncodeError(2, localException);
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderHWVideoEncoder.c();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface.a();
        return;
      }
    }
    QLog.w("HWVideoRecorder", 2, "handleStopRecording: is not recording.");
  }
  
  public MediaFormat a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderHWVideoEncoder != null) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderHWVideoEncoder.a;
    }
    return null;
  }
  
  @NonNull
  protected HWVideoRecorder.RecodeHandler a(Looper paramLooper)
  {
    return new HWVideoRecorder.RecodeHandler(this, paramLooper, this);
  }
  
  public void a()
  {
    this.d = true;
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoRecorder", 2, "frameAvailable timestampNanos = " + paramLong + " ; textureId = " + paramInt2 + " ; EGLContext = " + EGL14.eglGetCurrentContext());
    }
    if (this.d) {}
    for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorderBuffer.a(paramInt2);; bool = false)
    {
      if ((!this.d) || (bool))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2;
        localMessage.obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder$RecodeHandler.sendMessage(localMessage);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder$RecodeHandler.removeMessages(2);
    }
  }
  
  public void a(EncodeConfig paramEncodeConfig, HWEncodeListener paramHWEncodeListener)
  {
    a(paramEncodeConfig, paramHWEncodeListener, null);
  }
  
  public void a(EncodeConfig paramEncodeConfig, HWEncodeListener paramHWEncodeListener, HWEncodeNextListener paramHWEncodeNextListener)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "startRecording EGLContext = " + paramEncodeConfig.a());
    }
    if (this.d) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorderBuffer.a(paramEncodeConfig.jdField_a_of_type_Int, paramEncodeConfig.b);
    }
    Message localMessage = Message.obtain();
    HWVideoRecorder.RecordingObj localRecordingObj = new HWVideoRecorder.RecordingObj(this, null);
    localRecordingObj.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener = paramHWEncodeListener;
    localRecordingObj.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeNextListener = paramHWEncodeNextListener;
    localRecordingObj.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig = paramEncodeConfig;
    localMessage.obj = localRecordingObj;
    localMessage.what = 0;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder$RecodeHandler.sendMessage(localMessage);
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder$RecodeHandler.sendEmptyMessage(3);
  }
  
  public void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig == null) {
      QLog.d("HWVideoRecorder", 1, "handleFrameAvailable fail, encodeConfig null");
    }
    label324:
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("HWVideoRecorder", 2, new Object[] { "handleFrameAvailable timestampNanos = ", Long.valueOf(paramLong), "; textureId = ", Integer.valueOf(paramInt2), "; EGLContext = ", this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.a() });
        }
        if (this.jdField_a_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("HWVideoRecorder", 2, "handleFrameAvailable mIsRecording = " + this.jdField_a_of_type_Boolean);
      return;
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderHWVideoEncoder.a();
          if ((this.b) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_a_of_type_Boolean))
          {
            this.b = false;
            ThumbnailUtil.a(paramInt2, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.b, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig, new HWVideoRecorder.1(this));
          }
          if (this.d)
          {
            paramInt2 = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorderBuffer.a();
            if (paramInt2 == -1) {
              break label324;
            }
            this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
            if (this.d) {
              this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorderBuffer.a(false, 1);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener.onEncodeFrame();
            return;
          }
        }
        catch (Exception paramArrayOfFloat1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("HWVideoRecorder", 2, "frameAvailable: exception. config = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig, paramArrayOfFloat1);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener.onEncodeError(2, paramArrayOfFloat1);
          }
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderHWVideoEncoder.c();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface.a();
          this.jdField_a_of_type_Boolean = false;
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("HWVideoRecorder", 2, new Object[] { "ignore frame: ", Long.valueOf(paramLong) });
  }
  
  public void c()
  {
    if (this.d) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorderBuffer.a();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder$RecodeHandler.sendMessage(localMessage);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener = null;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeNextListener = null;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder
 * JD-Core Version:    0.7.0.1
 */