package com.tencent.mobileqq.richmedia.mediacodec;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.Matrix;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWVideoRecorder;
import com.tencent.ttpic.video.AEEncoder;

@TargetApi(17)
public class AEVEncoder
  implements HWEncodeListener, AEEncoder
{
  private HWVideoRecorder a = new HWVideoRecorder();
  private EncodeConfig b;
  private boolean c;
  private float[] d = new float[16];
  private final Object e = new Object();
  
  public AEVEncoder(String paramString, int paramInt1, int paramInt2)
  {
    this.b = new EncodeConfig(paramString, paramInt1, paramInt2, 5242880, 1, false, 0);
    Matrix.setIdentityM(this.d, 0);
    Matrix.setRotateM(this.d, 0, 180.0F, 1.0F, 0.0F, 0.0F);
  }
  
  public void onEncodeError(int paramInt, Throwable paramThrowable) {}
  
  public void onEncodeFinish(String arg1)
  {
    this.a.e();
    this.c = false;
    synchronized (this.e)
    {
      this.e.notifyAll();
      return;
    }
  }
  
  public void onEncodeFrame() {}
  
  public void onEncodeStart() {}
  
  public void release()
  {
    this.a.b();
    try
    {
      synchronized (this.e)
      {
        this.e.wait();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      label28:
      break label28;
    }
    return;
    throw localObject2;
  }
  
  public int writeFrame(int paramInt, long paramLong)
  {
    if (!this.c)
    {
      this.b.a(EGL14.eglGetCurrentContext());
      this.a.a(this.b, this);
      this.c = true;
    }
    this.a.a(3553, paramInt, null, this.d, 1000000L * paramLong);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.AEVEncoder
 * JD-Core Version:    0.7.0.1
 */