package com.tencent.mobileqq.videocodec.mediacodec.recorder;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeInputSurface;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.HWVideoEncoder;
import com.tencent.mobileqq.videocodec.mediacodec.util.ThumbnailUtil;
import com.tencent.qphone.base.util.QLog;

@TargetApi(18)
public class HWVideoRecorder
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("recode_thread");
  private EncodeConfig jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig;
  private EncodeInputSurface jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface;
  private HWVideoEncoder jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderHWVideoEncoder;
  private HWEncodeListener jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener;
  private HWEncodeNextListener jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeNextListener;
  protected HWVideoRecorder.RecodeHandler a;
  private HWVideoRecorderBuffer jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorderBuffer;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  private boolean c;
  private boolean d = false;
  
  public HWVideoRecorder()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder$RecodeHandler = a(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderHWVideoEncoder = new HWVideoEncoder();
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface = new EncodeInputSurface();
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorderBuffer = new HWVideoRecorderBuffer();
  }
  
  private void a(HWVideoRecorder.RecordingObj paramRecordingObj)
  {
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener = paramRecordingObj.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeNextListener = paramRecordingObj.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeNextListener;
    paramRecordingObj = paramRecordingObj.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("handleStartRecording EGLContext = ");
      localStringBuilder1.append(paramRecordingObj.a());
      QLog.w("HWVideoRecorder", 2, localStringBuilder1.toString());
    }
    if (this.jdField_a_of_type_Boolean) {
      d();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig = paramRecordingObj;
    this.jdField_a_of_type_JavaLangString = paramRecordingObj.jdField_a_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderHWVideoEncoder.a(paramRecordingObj);
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface.a(paramRecordingObj, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderHWVideoEncoder.a());
      paramRecordingObj = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener;
      if (paramRecordingObj != null) {
        paramRecordingObj.onEncodeStart();
      }
      this.b = true;
      this.c = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("handleStartRecording: exception at start. encodeConfig = ");
        localStringBuilder2.append(paramRecordingObj);
        QLog.w("HWVideoRecorder", 2, localStringBuilder2.toString(), localThrowable);
      }
      paramRecordingObj = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener;
      if (paramRecordingObj != null) {
        paramRecordingObj.onEncodeError(1, localThrowable);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "handleStopRecording");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderHWVideoEncoder.b();
        if (QLog.isColorLevel()) {
          QLog.w("HWVideoRecorder", 2, "handleStopRecording complete");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener != null)
        {
          EncodeConfig localEncodeConfig = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig;
          if ((localEncodeConfig != null) && (localEncodeConfig.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper == null))
          {
            this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener.onEncodeFinish(this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener = null;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface.a();
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeNextListener = null;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleStopRecording: exception. config = ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig);
          QLog.e("HWVideoRecorder", 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener;
        if (localObject != null) {
          ((HWEncodeListener)localObject).onEncodeError(2, localException);
        }
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderHWVideoEncoder.c();
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface.a();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "handleStopRecording: is not recording.");
    }
  }
  
  public MediaFormat a()
  {
    HWVideoEncoder localHWVideoEncoder = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderHWVideoEncoder;
    if (localHWVideoEncoder != null) {
      return localHWVideoEncoder.a;
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("frameAvailable timestampNanos = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" ; textureId = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" ; EGLContext = ");
      ((StringBuilder)localObject).append(EGL14.eglGetCurrentContext());
      QLog.d("HWVideoRecorder", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool;
    if (this.d)
    {
      bool = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorderBuffer.a(paramInt2);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder$RecodeHandler.removeMessages(2);
      bool = false;
    }
    if ((!this.d) || (bool))
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 2;
      ((Message)localObject).obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder$RecodeHandler.sendMessage((Message)localObject);
    }
  }
  
  public void a(EncodeConfig paramEncodeConfig, HWEncodeListener paramHWEncodeListener)
  {
    a(paramEncodeConfig, paramHWEncodeListener, null);
  }
  
  public void a(EncodeConfig paramEncodeConfig, HWEncodeListener paramHWEncodeListener, HWEncodeNextListener paramHWEncodeNextListener)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startRecording EGLContext = ");
      ((StringBuilder)localObject).append(paramEncodeConfig.a());
      QLog.w("HWVideoRecorder", 2, ((StringBuilder)localObject).toString());
    }
    if (this.d) {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorderBuffer.a(paramEncodeConfig.jdField_a_of_type_Int, paramEncodeConfig.b);
    }
    Object localObject = Message.obtain();
    HWVideoRecorder.RecordingObj localRecordingObj = new HWVideoRecorder.RecordingObj(this, null);
    localRecordingObj.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener = paramHWEncodeListener;
    localRecordingObj.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeNextListener = paramHWEncodeNextListener;
    localRecordingObj.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig = paramEncodeConfig;
    ((Message)localObject).obj = localRecordingObj;
    ((Message)localObject).what = 0;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder$RecodeHandler.sendMessage((Message)localObject);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean ^ true;
  }
  
  public void b()
  {
    if (this.d) {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorderBuffer.a();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder$RecodeHandler.sendMessage(localMessage);
  }
  
  public void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig == null)
    {
      QLog.d("HWVideoRecorder", 1, "handleFrameAvailable fail, encodeConfig null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoRecorder", 2, new Object[] { "handleFrameAvailable timestampNanos = ", Long.valueOf(paramLong), "; textureId = ", Integer.valueOf(paramInt2), "; EGLContext = ", this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.a() });
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfFloat1 = new StringBuilder();
        paramArrayOfFloat1.append("handleFrameAvailable mIsRecording = ");
        paramArrayOfFloat1.append(this.jdField_a_of_type_Boolean);
        QLog.d("HWVideoRecorder", 2, paramArrayOfFloat1.toString());
      }
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderHWVideoEncoder.a();
      if ((this.b) && (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_a_of_type_Boolean))
      {
        this.b = false;
        ThumbnailUtil.a(paramInt2, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.b, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig, new HWVideoRecorder.1(this));
      }
      if (this.d) {
        paramInt2 = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorderBuffer.a();
      }
      if (paramInt2 != -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
        if (this.d) {
          this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorderBuffer.a(false, 1);
        }
        paramArrayOfFloat1 = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener;
        if (paramArrayOfFloat1 != null) {
          paramArrayOfFloat1.onEncodeFrame();
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("HWVideoRecorder", 2, new Object[] { "ignore frame: ", Long.valueOf(paramLong) });
      }
      return;
    }
    catch (Exception paramArrayOfFloat1)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfFloat2 = new StringBuilder();
        paramArrayOfFloat2.append("frameAvailable: exception. config = ");
        paramArrayOfFloat2.append(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig);
        QLog.e("HWVideoRecorder", 2, paramArrayOfFloat2.toString(), paramArrayOfFloat1);
      }
      paramArrayOfFloat2 = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener;
      if (paramArrayOfFloat2 != null) {
        paramArrayOfFloat2.onEncodeError(2, paramArrayOfFloat1);
      }
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderHWVideoEncoder.c();
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeInputSurface.a();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void c()
  {
    HandlerThread localHandlerThread = this.jdField_a_of_type_AndroidOsHandlerThread;
    if (localHandlerThread != null)
    {
      localHandlerThread.quitSafely();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener = null;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeNextListener = null;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.recorder.HWVideoRecorder
 * JD-Core Version:    0.7.0.1
 */