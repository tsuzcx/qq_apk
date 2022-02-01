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
  private HWVideoEncoder a;
  private EncodeInputSurface b;
  private HWVideoRecorder.RecodeHandler c;
  private HandlerThread d = new HandlerThread("recode_thread");
  private HWEncodeListener e;
  private HWEncodeNextListener f;
  private String g;
  private volatile boolean h = false;
  private EncodeConfig i;
  private boolean j = false;
  private HWVideoRecorderBuffer k;
  
  public HWVideoRecorder()
  {
    this.d.start();
    this.c = a(this.d.getLooper());
    this.a = new HWVideoEncoder();
    this.b = new EncodeInputSurface();
    this.k = new HWVideoRecorderBuffer();
  }
  
  private HWVideoRecorder.RecodeHandler a(Looper paramLooper)
  {
    return new HWVideoRecorder.RecodeHandler(this, paramLooper, this);
  }
  
  private void a(@NotNull HWVideoRecorder.RecordingObj paramRecordingObj)
  {
    this.e = paramRecordingObj.a;
    this.f = paramRecordingObj.b;
    paramRecordingObj = paramRecordingObj.c;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("handleStartRecording EGLContext = ");
    localStringBuilder1.append(paramRecordingObj.a());
    TLog.c("HWVideoRecorder", localStringBuilder1.toString());
    if (this.h) {
      c();
    }
    this.h = true;
    this.i = paramRecordingObj;
    this.g = paramRecordingObj.a;
    try
    {
      this.a.a(paramRecordingObj);
      this.b.a(paramRecordingObj, this.a.d());
      paramRecordingObj = this.e;
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
      paramRecordingObj = this.e;
      if (paramRecordingObj != null) {
        paramRecordingObj.b(1, localThrowable);
      }
      this.h = false;
    }
  }
  
  private void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleFrameAvailable timestampNanos = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" ; textureId = ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" ; EGLContext = ");
    localStringBuilder.append(this.i.a());
    TLog.b("HWVideoRecorder", localStringBuilder.toString());
    if (!this.h)
    {
      paramArrayOfFloat1 = new StringBuilder();
      paramArrayOfFloat1.append("handleFrameAvailable mIsRecording = ");
      paramArrayOfFloat1.append(this.h);
      TLog.b("HWVideoRecorder", paramArrayOfFloat1.toString());
      return;
    }
    try
    {
      this.a.a();
      if (this.j) {
        paramInt2 = this.k.b();
      }
      if (paramInt2 != -1)
      {
        this.b.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
        if (this.j) {
          this.k.a(false, 1);
        }
        paramArrayOfFloat1 = this.e;
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
      paramArrayOfFloat2.append(this.i);
      TLog.b("HWVideoRecorder", paramArrayOfFloat2.toString(), paramArrayOfFloat1);
      paramArrayOfFloat2 = this.e;
      if (paramArrayOfFloat2 != null) {
        paramArrayOfFloat2.b(2, paramArrayOfFloat1);
      }
      this.a.c();
      this.b.a();
      this.h = false;
    }
  }
  
  private void c()
  {
    TLog.c("HWVideoRecorder", "handleStopRecording");
    if (this.h)
    {
      this.h = false;
      try
      {
        this.a.b();
        TLog.c("HWVideoRecorder", "handleStopRecording complete");
        if ((this.e != null) && (this.i.f == null))
        {
          this.e.a(this.g);
          this.e = null;
        }
        this.b.a();
        this.f = null;
        return;
      }
      catch (Exception localException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleStopRecording: exception. config = ");
        ((StringBuilder)localObject).append(this.i);
        TLog.d("HWVideoRecorder", ((StringBuilder)localObject).toString());
        localObject = this.e;
        if (localObject != null) {
          ((HWEncodeListener)localObject).b(2, localException);
        }
        this.a.c();
        this.b.a();
        return;
      }
    }
    TLog.c("HWVideoRecorder", "handleStopRecording: is not recording.");
  }
  
  public void a()
  {
    if (this.j) {
      this.k.a();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.c.sendMessage(localMessage);
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
    if (this.j)
    {
      bool = this.k.a(paramInt2);
    }
    else
    {
      this.c.removeMessages(2);
      bool = false;
    }
    if ((!this.j) || (bool))
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 2;
      ((Message)localObject).obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
      this.c.sendMessage((Message)localObject);
    }
  }
  
  public boolean b()
  {
    return this.h ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder.HWVideoRecorder
 * JD-Core Version:    0.7.0.1
 */