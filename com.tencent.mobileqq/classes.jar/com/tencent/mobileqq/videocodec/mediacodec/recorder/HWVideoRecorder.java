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
  protected HWVideoRecorder.RecodeHandler a;
  private HWVideoEncoder b;
  private EncodeInputSurface c;
  private HandlerThread d = new HandlerThread("recode_thread");
  private HWEncodeListener e;
  private HWEncodeNextListener f;
  private String g;
  private volatile boolean h = false;
  private EncodeConfig i;
  private boolean j;
  private boolean k;
  private boolean l = false;
  private HWVideoRecorderBuffer m;
  
  public HWVideoRecorder()
  {
    this.d.start();
    this.a = a(this.d.getLooper());
    this.b = new HWVideoEncoder();
    this.c = new EncodeInputSurface();
    this.m = new HWVideoRecorderBuffer();
  }
  
  private void a(HWVideoRecorder.RecordingObj paramRecordingObj)
  {
    this.e = paramRecordingObj.a;
    this.f = paramRecordingObj.b;
    paramRecordingObj = paramRecordingObj.c;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("handleStartRecording EGLContext = ");
      localStringBuilder1.append(paramRecordingObj.a());
      QLog.w("HWVideoRecorder", 2, localStringBuilder1.toString());
    }
    if (this.h) {
      f();
    }
    this.h = true;
    this.i = paramRecordingObj;
    this.g = paramRecordingObj.b;
    try
    {
      this.b.a(paramRecordingObj);
      this.c.a(paramRecordingObj, this.b.d());
      paramRecordingObj = this.e;
      if (paramRecordingObj != null) {
        paramRecordingObj.onEncodeStart();
      }
      this.j = true;
      this.k = false;
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
      paramRecordingObj = this.e;
      if (paramRecordingObj != null) {
        paramRecordingObj.onEncodeError(1, localThrowable);
      }
      this.h = false;
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "handleStopRecording");
    }
    if (this.h)
    {
      this.h = false;
      try
      {
        this.b.b();
        if (QLog.isColorLevel()) {
          QLog.w("HWVideoRecorder", 2, "handleStopRecording complete");
        }
        if (this.e != null)
        {
          EncodeConfig localEncodeConfig = this.i;
          if ((localEncodeConfig != null) && (localEncodeConfig.s == null))
          {
            this.e.onEncodeFinish(this.g);
            this.e = null;
          }
        }
        this.c.a();
        this.f = null;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleStopRecording: exception. config = ");
          ((StringBuilder)localObject).append(this.i);
          QLog.e("HWVideoRecorder", 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = this.e;
        if (localObject != null) {
          ((HWEncodeListener)localObject).onEncodeError(2, localException);
        }
        this.b.c();
        this.c.a();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "handleStopRecording: is not recording.");
    }
  }
  
  @NonNull
  protected HWVideoRecorder.RecodeHandler a(Looper paramLooper)
  {
    return new HWVideoRecorder.RecodeHandler(this, paramLooper, this);
  }
  
  public void a()
  {
    this.l = true;
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
    if (this.l)
    {
      bool = this.m.a(paramInt2);
    }
    else
    {
      this.a.removeMessages(2);
      bool = false;
    }
    if ((!this.l) || (bool))
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 2;
      ((Message)localObject).obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
      this.a.sendMessage((Message)localObject);
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
    if (this.l) {
      this.m.a(paramEncodeConfig.c, paramEncodeConfig.d);
    }
    Object localObject = Message.obtain();
    HWVideoRecorder.RecordingObj localRecordingObj = new HWVideoRecorder.RecordingObj(this, null);
    localRecordingObj.a = paramHWEncodeListener;
    localRecordingObj.b = paramHWEncodeNextListener;
    localRecordingObj.c = paramEncodeConfig;
    ((Message)localObject).obj = localRecordingObj;
    ((Message)localObject).what = 0;
    this.a.sendMessage((Message)localObject);
  }
  
  public void b()
  {
    if (this.l) {
      this.m.a();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.a.sendMessage(localMessage);
  }
  
  public void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.i == null)
    {
      QLog.d("HWVideoRecorder", 1, "handleFrameAvailable fail, encodeConfig null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoRecorder", 2, new Object[] { "handleFrameAvailable timestampNanos = ", Long.valueOf(paramLong), "; textureId = ", Integer.valueOf(paramInt2), "; EGLContext = ", this.i.a() });
    }
    if (!this.h)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfFloat1 = new StringBuilder();
        paramArrayOfFloat1.append("handleFrameAvailable mIsRecording = ");
        paramArrayOfFloat1.append(this.h);
        QLog.d("HWVideoRecorder", 2, paramArrayOfFloat1.toString());
      }
      return;
    }
    try
    {
      this.b.a();
      if ((this.j) && (this.i.i))
      {
        this.j = false;
        ThumbnailUtil.a(paramInt2, this.i.c, this.i.d, this.i, new HWVideoRecorder.1(this));
      }
      if (this.l) {
        paramInt2 = this.m.b();
      }
      if (paramInt2 != -1)
      {
        this.c.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
        if (this.l) {
          this.m.a(false, 1);
        }
        paramArrayOfFloat1 = this.e;
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
        paramArrayOfFloat2.append(this.i);
        QLog.e("HWVideoRecorder", 2, paramArrayOfFloat2.toString(), paramArrayOfFloat1);
      }
      paramArrayOfFloat2 = this.e;
      if (paramArrayOfFloat2 != null) {
        paramArrayOfFloat2.onEncodeError(2, paramArrayOfFloat1);
      }
      this.b.c();
      this.c.a();
      this.h = false;
    }
  }
  
  public boolean c()
  {
    return this.h ^ true;
  }
  
  public MediaFormat d()
  {
    HWVideoEncoder localHWVideoEncoder = this.b;
    if (localHWVideoEncoder != null) {
      return localHWVideoEncoder.a;
    }
    return null;
  }
  
  public void e()
  {
    HandlerThread localHandlerThread = this.d;
    if (localHandlerThread != null)
    {
      localHandlerThread.quitSafely();
      this.d = null;
    }
    this.e = null;
    this.f = null;
    this.i = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.recorder.HWVideoRecorder
 * JD-Core Version:    0.7.0.1
 */