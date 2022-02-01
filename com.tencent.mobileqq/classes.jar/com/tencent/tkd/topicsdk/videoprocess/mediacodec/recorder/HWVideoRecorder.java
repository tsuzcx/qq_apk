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
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("handleStartRecording EGLContext = ");
    localStringBuilder1.append(paramRecordingObj.a());
    TLog.c("HWVideoRecorder", localStringBuilder1.toString());
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
      paramRecordingObj = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener;
      if (paramRecordingObj != null) {
        paramRecordingObj.e();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("handleStartRecording: exception at start. encodeConfig = ");
      localStringBuilder2.append(paramRecordingObj);
      TLog.a("HWVideoRecorder", localStringBuilder2.toString(), localThrowable);
      paramRecordingObj = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener;
      if (paramRecordingObj != null) {
        paramRecordingObj.b(1, localThrowable);
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
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleStopRecording: exception. config = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeConfig);
        TLog.d("HWVideoRecorder", ((StringBuilder)localObject).toString());
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener;
        if (localObject != null) {
          ((HWEncodeListener)localObject).b(2, localException);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleFrameAvailable timestampNanos = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" ; textureId = ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" ; EGLContext = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeConfig.a());
    TLog.b("HWVideoRecorder", localStringBuilder.toString());
    if (!this.jdField_a_of_type_Boolean)
    {
      paramArrayOfFloat1 = new StringBuilder();
      paramArrayOfFloat1.append("handleFrameAvailable mIsRecording = ");
      paramArrayOfFloat1.append(this.jdField_a_of_type_Boolean);
      TLog.b("HWVideoRecorder", paramArrayOfFloat1.toString());
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderHWVideoEncoder.a();
      if (this.b) {
        paramInt2 = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorderBuffer.a();
      }
      if (paramInt2 != -1)
      {
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeInputSurface.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
        if (this.b) {
          this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorderBuffer.a(false, 1);
        }
        paramArrayOfFloat1 = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener;
        if (paramArrayOfFloat1 != null) {
          paramArrayOfFloat1.f();
        }
      }
      else
      {
        paramArrayOfFloat1 = new StringBuilder();
        paramArrayOfFloat1.append("ignore frame: ");
        paramArrayOfFloat1.append(paramLong);
        TLog.b("HWVideoRecorder", paramArrayOfFloat1.toString());
      }
      return;
    }
    catch (Exception paramArrayOfFloat1)
    {
      paramArrayOfFloat2 = new StringBuilder();
      paramArrayOfFloat2.append("frameAvailable: exception. config = ");
      paramArrayOfFloat2.append(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeConfig);
      TLog.b("HWVideoRecorder", paramArrayOfFloat2.toString(), paramArrayOfFloat1);
      paramArrayOfFloat2 = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWEncodeListener;
      if (paramArrayOfFloat2 != null) {
        paramArrayOfFloat2.b(2, paramArrayOfFloat1);
      }
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderHWVideoEncoder.c();
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEncodeInputSurface.a();
      this.jdField_a_of_type_Boolean = false;
    }
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("frameAvailable timestampNanos = ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" ; textureId = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" ; EGLContext = ");
    ((StringBuilder)localObject).append(EGL14.eglGetCurrentContext());
    TLog.b("HWVideoRecorder", ((StringBuilder)localObject).toString());
    boolean bool;
    if (this.b)
    {
      bool = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorderBuffer.a(paramInt2);
    }
    else
    {
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorder$RecodeHandler.removeMessages(2);
      bool = false;
    }
    if ((!this.b) || (bool))
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 2;
      ((Message)localObject).obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderHWVideoRecorder$RecodeHandler.sendMessage((Message)localObject);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder.HWVideoRecorder
 * JD-Core Version:    0.7.0.1
 */