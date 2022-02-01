package com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder.EncodeConfig;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder.EncodeInputSurface;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder.HWVideoEncoder;
import org.jetbrains.annotations.NotNull;

@TargetApi(18)
public class HWVideoRecorder
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("recode_thread");
  private EncodeConfig jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeConfig;
  private EncodeInputSurface jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeInputSurface;
  private HWVideoEncoder jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderHWVideoEncoder;
  private HWEncodeListener jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener;
  private HWEncodeNextListener jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeNextListener;
  private HWVideoRecorder.RecodeHandler jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorder$RecodeHandler;
  private HWVideoRecorderBuffer jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorderBuffer;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public HWVideoRecorder()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorder$RecodeHandler = a(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderHWVideoEncoder = new HWVideoEncoder();
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeInputSurface = new EncodeInputSurface();
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorderBuffer = new HWVideoRecorderBuffer();
  }
  
  private HWVideoRecorder.RecodeHandler a(Looper paramLooper)
  {
    return new HWVideoRecorder.RecodeHandler(this, paramLooper, this);
  }
  
  private void a(@NotNull HWVideoRecorder.RecordingObj paramRecordingObj)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener = paramRecordingObj.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener;
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeNextListener = paramRecordingObj.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeNextListener;
    paramRecordingObj = paramRecordingObj.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeConfig;
    TLog.c("HWVideoRecorder", "handleStartRecording EGLContext = " + paramRecordingObj.a());
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeConfig = paramRecordingObj;
    this.jdField_a_of_type_JavaLangString = paramRecordingObj.jdField_a_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderHWVideoEncoder.a(paramRecordingObj);
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeInputSurface.a(paramRecordingObj, this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderHWVideoEncoder.a());
      if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener != null) {
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener.e();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      TLog.b("HWVideoRecorder", "handleStartRecording: exception at start. encodeConfig = " + paramRecordingObj, localThrowable);
      if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener != null) {
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener.b(1, localThrowable);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void b()
  {
    TLog.c("HWVideoRecorder", "handleStopRecording");
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      try
      {
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderHWVideoEncoder.b();
        TLog.c("HWVideoRecorder", "handleStopRecording complete");
        if ((this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener != null) && (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeConfig.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper == null))
        {
          this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener = null;
        }
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeInputSurface.a();
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeNextListener = null;
        return;
      }
      catch (Exception localException)
      {
        TLog.d("HWVideoRecorder", "handleStopRecording: exception. config = " + this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeConfig);
        if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener != null) {
          this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener.b(2, localException);
        }
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderHWVideoEncoder.c();
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeInputSurface.a();
        return;
      }
    }
    TLog.c("HWVideoRecorder", "handleStopRecording: is not recording.");
  }
  
  private void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    TLog.b("HWVideoRecorder", "handleFrameAvailable timestampNanos = " + paramLong + " ; textureId = " + paramInt2 + " ; EGLContext = " + this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeConfig.a());
    if (!this.jdField_a_of_type_Boolean)
    {
      TLog.b("HWVideoRecorder", "handleFrameAvailable mIsRecording = " + this.jdField_a_of_type_Boolean);
      return;
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderHWVideoEncoder.a();
        if (this.b)
        {
          paramInt2 = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorderBuffer.a();
          if (paramInt2 == -1) {
            break label228;
          }
          this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeInputSurface.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
          if (this.b) {
            this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorderBuffer.a(false, 1);
          }
          if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener.f();
          return;
        }
      }
      catch (Exception paramArrayOfFloat1)
      {
        TLog.c("HWVideoRecorder", "frameAvailable: exception. config = " + this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeConfig, paramArrayOfFloat1);
        if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener != null) {
          this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener.b(2, paramArrayOfFloat1);
        }
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderHWVideoEncoder.c();
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeInputSurface.a();
        this.jdField_a_of_type_Boolean = false;
        return;
      }
    }
    label228:
    TLog.b("HWVideoRecorder", "ignore frame: " + paramLong);
  }
  
  public void a()
  {
    if (this.b) {
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorderBuffer.a();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorder$RecodeHandler.sendMessage(localMessage);
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    TLog.b("HWVideoRecorder", "frameAvailable timestampNanos = " + paramLong + " ; textureId = " + paramInt2 + " ; EGLContext = " + EGL14.eglGetCurrentContext());
    if (this.b) {}
    for (boolean bool = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorderBuffer.a(paramInt2);; bool = false)
    {
      if ((!this.b) || (bool))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2;
        localMessage.obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorder$RecodeHandler.sendMessage(localMessage);
      }
      return;
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorder$RecodeHandler.removeMessages(2);
    }
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder.HWVideoRecorder
 * JD-Core Version:    0.7.0.1
 */