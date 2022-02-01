package com.tencent.mobileqq.qqlive.trtc.video.source;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCEngineContext;
import com.tencent.mobileqq.qqlive.trtc.utils.SourceInitState;
import com.tencent.mobileqq.qqlive.trtc.utils.TRTCConvertHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trtc.TRTCCloud;
import mqq.util.WeakReference;

public class TRTCVideoBaseSourceImpl
  implements ITRTCVideoBaseSource
{
  protected final SourceInitState a = new SourceInitState();
  protected TRTCCloud b;
  protected WeakReference<Context> c;
  protected Handler d;
  protected TRTCVideoQualityParams e;
  
  public void a(@NonNull Bitmap paramBitmap, int paramInt)
  {
    if ((paramInt >= 5) && (paramInt <= 20))
    {
      TRTCCloud localTRTCCloud = this.b;
      if (localTRTCCloud != null) {
        localTRTCCloud.setVideoMuteImage(paramBitmap, paramInt);
      }
      return;
    }
    paramBitmap = new StringBuilder();
    paramBitmap.append("fps except [5, 20]. but ");
    paramBitmap.append(paramInt);
    throw new IllegalArgumentException(paramBitmap.toString());
  }
  
  public void a(@NonNull Handler paramHandler)
  {
    this.d = paramHandler;
  }
  
  public void a(@NonNull TRTCVideoQualityParams paramTRTCVideoQualityParams)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setVideoQuality. resolution:");
    ((StringBuilder)localObject).append(paramTRTCVideoQualityParams.getVideoResolution());
    ((StringBuilder)localObject).append(", mode:");
    ((StringBuilder)localObject).append(paramTRTCVideoQualityParams.getVideoResolutionMode());
    ((StringBuilder)localObject).append(", fps:");
    ((StringBuilder)localObject).append(paramTRTCVideoQualityParams.getVideoFps());
    ((StringBuilder)localObject).append(", bitrate:");
    ((StringBuilder)localObject).append(paramTRTCVideoQualityParams.getMinVideoBitRate());
    QLog.i("TRTCVideoBaseSourceImpl", 1, ((StringBuilder)localObject).toString());
    this.e = paramTRTCVideoQualityParams;
    paramTRTCVideoQualityParams = TRTCConvertHelper.a(paramTRTCVideoQualityParams);
    localObject = this.b;
    if (localObject != null) {
      ((TRTCCloud)localObject).setVideoEncoderParam(paramTRTCVideoQualityParams);
    }
  }
  
  public void a(@NonNull TRTCEngineContext paramTRTCEngineContext)
  {
    if (!this.a.c())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TRTCVideoBaseSourceImpl", 1, "initSource!");
      }
      this.b = paramTRTCEngineContext.a;
      this.c = paramTRTCEngineContext.b;
      this.a.a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TRTCCloud localTRTCCloud = this.b;
    if (localTRTCCloud != null) {
      localTRTCCloud.muteLocalVideo(paramBoolean);
    }
  }
  
  public TRTCVideoQualityParams b()
  {
    return this.e;
  }
  
  public void c()
  {
    di_();
    QLog.d("TRTCVideoBaseSourceImpl", 1, "pauseSource!");
    TRTCCloud localTRTCCloud = this.b;
    if (localTRTCCloud != null) {
      localTRTCCloud.muteLocalVideo(true);
    }
  }
  
  public void d()
  {
    di_();
    QLog.d("TRTCVideoBaseSourceImpl", 1, "resumeSource!");
    TRTCCloud localTRTCCloud = this.b;
    if (localTRTCCloud != null) {
      localTRTCCloud.muteLocalVideo(false);
    }
  }
  
  protected void di_()
  {
    if (this.a.c()) {
      return;
    }
    throw new IllegalStateException("not init. please call setVideoSource");
  }
  
  public void e()
  {
    di_();
    QLog.d("TRTCVideoBaseSourceImpl", 1, "destroy!");
    this.b = null;
    this.e = null;
    this.d = null;
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.video.source.TRTCVideoBaseSourceImpl
 * JD-Core Version:    0.7.0.1
 */