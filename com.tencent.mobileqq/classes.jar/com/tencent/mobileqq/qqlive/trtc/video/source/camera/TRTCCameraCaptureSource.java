package com.tencent.mobileqq.qqlive.trtc.video.source.camera;

import androidx.annotation.NonNull;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCEngineContext;
import com.tencent.mobileqq.qqlive.trtc.render.ILocalRender;
import com.tencent.mobileqq.qqlive.trtc.render.TRTCRenderCtrl;
import com.tencent.mobileqq.qqlive.trtc.utils.SourceInitState;
import com.tencent.mobileqq.qqlive.trtc.utils.TRTCConvertHelper;
import com.tencent.mobileqq.qqlive.trtc.video.source.TRTCVideoBaseSourceImpl;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;

public class TRTCCameraCaptureSource
  extends TRTCVideoBaseSourceImpl
  implements ITRTCCameraCaptureSource
{
  private TXDeviceManager f;
  private volatile boolean g = true;
  private volatile boolean h = false;
  
  public void a()
  {
    di_();
    this.b.stopLocalPreview();
  }
  
  public void a(@NonNull TRTCEngineContext paramTRTCEngineContext)
  {
    super.a(paramTRTCEngineContext);
    if (this.a.c()) {
      this.f = this.b.getDeviceManager();
    }
  }
  
  public void a(@NonNull ILocalRender paramILocalRender)
  {
    di_();
    if ((paramILocalRender instanceof TRTCRenderCtrl))
    {
      if (this.e != null)
      {
        TRTCCloudDef.TRTCVideoEncParam localTRTCVideoEncParam = TRTCConvertHelper.a(this.e);
        this.b.setVideoEncoderParam(localTRTCVideoEncParam);
      }
      this.b.startLocalPreview(this.g, ((TRTCRenderCtrl)paramILocalRender).b());
      return;
    }
    throw new IllegalStateException("startCapture failed!, please use TRTCRenderCtrl!");
  }
  
  public void b(boolean paramBoolean)
  {
    di_();
    this.h = paramBoolean;
    this.b.setVideoEncoderMirror(paramBoolean);
  }
  
  public void e()
  {
    try
    {
      super.e();
      this.f = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void f()
  {
    di_();
    this.g ^= true;
    this.f.switchCamera(this.g);
  }
  
  public boolean g()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.video.source.camera.TRTCCameraCaptureSource
 * JD-Core Version:    0.7.0.1
 */