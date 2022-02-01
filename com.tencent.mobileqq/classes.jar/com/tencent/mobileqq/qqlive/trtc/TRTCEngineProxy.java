package com.tencent.mobileqq.qqlive.trtc;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveScreenCaptureParams;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.trtc.audio.ITRTCAudioBaseSource;
import com.tencent.mobileqq.qqlive.trtc.audio.ITRTCAudioSource;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCEngineContext;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback;
import com.tencent.mobileqq.qqlive.trtc.ipc.TRTCIPCManager;
import com.tencent.mobileqq.qqlive.trtc.render.ILocalRender;
import com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomCtrl;
import com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener;
import com.tencent.mobileqq.qqlive.trtc.video.source.ITRTCVideoBaseSource;
import com.tencent.mobileqq.qqlive.trtc.video.source.camera.ITRTCCameraCaptureSource;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.IRTCScreenCaptureEventListener;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.ITRTCScreenCaptureSource;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.StatisticDataListener;
import com.tencent.mobileqq.qqlive.utils.VideoQualityUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class TRTCEngineProxy
{
  private volatile ITRTCEngine a;
  
  public static TRTCEngineProxy a()
  {
    return TRTCEngineProxy.InstanceHolder.a;
  }
  
  private <T extends ITRTCVideoBaseSource> T a(@NonNull Class<T> paramClass)
  {
    paramClass = this.a.d(paramClass);
    this.a.a(paramClass);
    return paramClass;
  }
  
  public ITRTCCameraCaptureSource a(boolean paramBoolean)
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return null;
    }
    ITRTCCameraCaptureSource localITRTCCameraCaptureSource2;
    try
    {
      ITRTCCameraCaptureSource localITRTCCameraCaptureSource1 = (ITRTCCameraCaptureSource)this.a.a(ITRTCCameraCaptureSource.class);
    }
    catch (Exception localException)
    {
      QLog.e("TRTCEngineProxy", 1, "getCameraSource error!", localException);
      localITRTCCameraCaptureSource2 = null;
    }
    if (localITRTCCameraCaptureSource2 == null)
    {
      if (paramBoolean) {
        return (ITRTCCameraCaptureSource)a(ITRTCCameraCaptureSource.class);
      }
      QLog.e("TRTCEngineProxy", 1, "error! cameraCaptureSource not exit!");
    }
    return localITRTCCameraCaptureSource2;
  }
  
  public void a(Context paramContext, ConfigData paramConfigData, TRTCInitCallback paramTRTCInitCallback)
  {
    try
    {
      if (m())
      {
        QLog.e("TRTCEngineProxy", 1, "already init engine!");
        if (paramTRTCInitCallback != null) {
          paramTRTCInitCallback.a(2, 0);
        }
        return;
      }
      if (this.a == null) {
        this.a = TRTCIPCManager.b().f();
      }
      if (this.a != null) {
        this.a.a(paramContext, paramConfigData, paramTRTCInitCallback);
      }
      return;
    }
    finally {}
  }
  
  public void a(Bitmap paramBitmap, int paramInt)
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return;
    }
    int i;
    Object localObject;
    if (paramInt >= 5)
    {
      i = paramInt;
      if (paramInt <= 20) {}
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fps except [5, 20]. but ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("TRTCEngineProxy", 1, ((StringBuilder)localObject).toString());
      i = 10;
    }
    try
    {
      localObject = this.a.a(ITRTCVideoBaseSource.class);
      if (localObject != null)
      {
        ((ITRTCVideoBaseSource)localObject).a(paramBitmap, i);
        ((ITRTCVideoBaseSource)localObject).c();
      }
    }
    catch (Throwable paramBitmap)
    {
      QLog.e("TRTCEngineProxy", 1, paramBitmap, new Object[0]);
    }
    try
    {
      paramBitmap = this.a.b(ITRTCAudioBaseSource.class);
      if (paramBitmap != null)
      {
        paramBitmap.b();
        return;
      }
    }
    catch (Throwable paramBitmap)
    {
      QLog.e("TRTCEngineProxy", 1, paramBitmap, new Object[0]);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if ((paramViewGroup != null) && (m()))
    {
      if (this.a.d() == null)
      {
        QLog.e("TRTCEngineProxy", 1, "don't support setPreviewViewGroup, fail!");
        return;
      }
      this.a.d().a(new WeakReference(paramViewGroup));
      return;
    }
    QLog.e("TRTCEngineProxy", 1, "setPreviewViewGroup failed!");
  }
  
  public void a(QQLiveRoomParams paramQQLiveRoomParams)
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return;
    }
    this.a.e().a(paramQQLiveRoomParams);
  }
  
  public void a(@NonNull TRTCVideoQualityParams paramTRTCVideoQualityParams)
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return;
    }
    ITRTCVideoBaseSource localITRTCVideoBaseSource = this.a.a(ITRTCVideoBaseSource.class);
    if (localITRTCVideoBaseSource != null) {
      localITRTCVideoBaseSource.a(paramTRTCVideoQualityParams);
    }
  }
  
  public void a(TRTCVideoQualityParams paramTRTCVideoQualityParams, QQLiveScreenCaptureParams paramQQLiveScreenCaptureParams)
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return;
    }
    ITRTCScreenCaptureSource localITRTCScreenCaptureSource = c(true);
    if (localITRTCScreenCaptureSource != null)
    {
      TRTCVideoQualityParams localTRTCVideoQualityParams = paramTRTCVideoQualityParams;
      if (paramTRTCVideoQualityParams == null) {
        localTRTCVideoQualityParams = VideoQualityUtils.b(this.a.c().a());
      }
      localITRTCScreenCaptureSource.a(localTRTCVideoQualityParams, paramQQLiveScreenCaptureParams);
    }
  }
  
  public void a(ITRTCRoomListener paramITRTCRoomListener)
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return;
    }
    ITRTCRoomCtrl localITRTCRoomCtrl = this.a.e();
    if (localITRTCRoomCtrl != null) {
      localITRTCRoomCtrl.a(paramITRTCRoomListener);
    }
  }
  
  public void a(IRTCScreenCaptureEventListener paramIRTCScreenCaptureEventListener)
  {
    ITRTCScreenCaptureSource localITRTCScreenCaptureSource = c(true);
    if (localITRTCScreenCaptureSource != null) {
      localITRTCScreenCaptureSource.a(paramIRTCScreenCaptureEventListener);
    }
  }
  
  public void a(StatisticDataListener paramStatisticDataListener)
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return;
    }
    this.a.a(paramStatisticDataListener);
  }
  
  public ITRTCAudioSource b(boolean paramBoolean)
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return null;
    }
    ITRTCAudioSource localITRTCAudioSource2;
    try
    {
      ITRTCAudioSource localITRTCAudioSource1 = (ITRTCAudioSource)this.a.b(ITRTCAudioSource.class);
    }
    catch (Exception localException)
    {
      QLog.e("TRTCEngineProxy", 1, localException.toString());
      localITRTCAudioSource2 = null;
    }
    if (localITRTCAudioSource2 == null)
    {
      if (paramBoolean)
      {
        localITRTCAudioSource2 = (ITRTCAudioSource)this.a.c(ITRTCAudioSource.class);
        this.a.a(localITRTCAudioSource2);
        return localITRTCAudioSource2;
      }
      QLog.e("TRTCEngineProxy", 1, "failed to get audio source! isNeedCreate is false!");
    }
    return localITRTCAudioSource2;
  }
  
  public void b()
  {
    try
    {
      if (!m())
      {
        QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
        return;
      }
      this.a.a();
      this.a = null;
      return;
    }
    finally {}
  }
  
  public ITRTCScreenCaptureSource c(boolean paramBoolean)
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return null;
    }
    ITRTCScreenCaptureSource localITRTCScreenCaptureSource2;
    try
    {
      ITRTCScreenCaptureSource localITRTCScreenCaptureSource1 = (ITRTCScreenCaptureSource)this.a.a(ITRTCScreenCaptureSource.class);
    }
    catch (Exception localException)
    {
      QLog.e("TRTCEngineProxy", 1, "getScreenCaptureSource error!", localException);
      localITRTCScreenCaptureSource2 = null;
    }
    if (localITRTCScreenCaptureSource2 == null)
    {
      if (paramBoolean) {
        return (ITRTCScreenCaptureSource)a(ITRTCScreenCaptureSource.class);
      }
      QLog.e("TRTCEngineProxy", 1, "screenCaptureSource is null!, isNeedCreate is false!");
    }
    return localITRTCScreenCaptureSource2;
  }
  
  public void c()
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return;
    }
    if (this.a.d() == null)
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine getLocalRender null!");
      return;
    }
    ITRTCCameraCaptureSource localITRTCCameraCaptureSource = a(true);
    if (localITRTCCameraCaptureSource != null)
    {
      d();
      localITRTCCameraCaptureSource.a(this.a.d());
    }
  }
  
  public void d()
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return;
    }
    if (a(true) != null) {
      a(VideoQualityUtils.a(this.a.c().a()));
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return;
    }
    ITRTCCameraCaptureSource localITRTCCameraCaptureSource = a(false);
    if (localITRTCCameraCaptureSource != null) {
      localITRTCCameraCaptureSource.b(paramBoolean);
    }
  }
  
  public void e()
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return;
    }
    ITRTCCameraCaptureSource localITRTCCameraCaptureSource = a(false);
    if (localITRTCCameraCaptureSource != null) {
      localITRTCCameraCaptureSource.a();
    }
  }
  
  public boolean f()
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return false;
    }
    ITRTCCameraCaptureSource localITRTCCameraCaptureSource = a(false);
    if (localITRTCCameraCaptureSource != null)
    {
      localITRTCCameraCaptureSource.f();
      return true;
    }
    return false;
  }
  
  public void g()
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return;
    }
    ITRTCAudioSource localITRTCAudioSource = b(true);
    if (localITRTCAudioSource != null) {
      localITRTCAudioSource.a(2);
    }
  }
  
  public void h()
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return;
    }
    ITRTCAudioSource localITRTCAudioSource = b(false);
    if (localITRTCAudioSource != null) {
      localITRTCAudioSource.d();
    }
  }
  
  public void i()
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return;
    }
    this.a.e().b();
  }
  
  public void j()
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return;
    }
    ITRTCScreenCaptureSource localITRTCScreenCaptureSource = c(false);
    if (localITRTCScreenCaptureSource != null) {
      localITRTCScreenCaptureSource.f();
    }
  }
  
  public void k()
  {
    Object localObject;
    try
    {
      ITRTCScreenCaptureSource localITRTCScreenCaptureSource = (ITRTCScreenCaptureSource)this.a.a(ITRTCScreenCaptureSource.class);
    }
    catch (Exception localException)
    {
      QLog.e("TRTCEngineProxy", 1, "initScreenCaptureSource error!", localException);
      localObject = null;
    }
    if (localObject == null) {
      a(ITRTCScreenCaptureSource.class);
    }
  }
  
  public void l()
  {
    ITRTCAudioSource localITRTCAudioSource2;
    try
    {
      ITRTCAudioSource localITRTCAudioSource1 = (ITRTCAudioSource)this.a.b(ITRTCAudioSource.class);
    }
    catch (Exception localException)
    {
      QLog.e("TRTCEngineProxy", 1, localException.toString());
      localITRTCAudioSource2 = null;
    }
    if (localITRTCAudioSource2 == null)
    {
      localITRTCAudioSource2 = (ITRTCAudioSource)this.a.c(ITRTCAudioSource.class);
      this.a.a(localITRTCAudioSource2);
    }
  }
  
  public boolean m()
  {
    return (this.a != null) && (this.a.b() == 2);
  }
  
  public TRTCVideoQualityParams n()
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return null;
    }
    Object localObject;
    try
    {
      ITRTCVideoBaseSource localITRTCVideoBaseSource = this.a.a(ITRTCVideoBaseSource.class);
    }
    catch (Exception localException)
    {
      QLog.e("TRTCEngineProxy", 1, "getVideoQuality error!", localException);
      localObject = null;
    }
    if (localObject != null) {
      return localObject.b();
    }
    return null;
  }
  
  public boolean o()
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return false;
    }
    ITRTCCameraCaptureSource localITRTCCameraCaptureSource = a(false);
    if (localITRTCCameraCaptureSource != null) {
      return localITRTCCameraCaptureSource.g();
    }
    return false;
  }
  
  public ITRTCRoomCtrl p()
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return null;
    }
    return this.a.e();
  }
  
  public void q()
  {
    if (!m())
    {
      QLog.e("TRTCEngineProxy", 1, "trtcEngine null or not ready !");
      return;
    }
    try
    {
      ITRTCVideoBaseSource localITRTCVideoBaseSource = this.a.a(ITRTCVideoBaseSource.class);
      if (localITRTCVideoBaseSource != null) {
        localITRTCVideoBaseSource.d();
      }
    }
    catch (Throwable localThrowable1)
    {
      QLog.e("TRTCEngineProxy", 1, localThrowable1, new Object[0]);
    }
    try
    {
      ITRTCAudioBaseSource localITRTCAudioBaseSource = this.a.b(ITRTCAudioBaseSource.class);
      if (localITRTCAudioBaseSource != null)
      {
        localITRTCAudioBaseSource.c();
        return;
      }
    }
    catch (Throwable localThrowable2)
    {
      QLog.e("TRTCEngineProxy", 1, localThrowable2, new Object[0]);
    }
  }
  
  public boolean r()
  {
    try
    {
      ITRTCAudioBaseSource localITRTCAudioBaseSource = this.a.b(ITRTCAudioBaseSource.class);
      if ((localITRTCAudioBaseSource != null) && ((localITRTCAudioBaseSource instanceof ITRTCAudioSource)))
      {
        boolean bool = ((ITRTCAudioSource)localITRTCAudioBaseSource).e();
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TRTCEngineProxy", 1, localThrowable, new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.TRTCEngineProxy
 * JD-Core Version:    0.7.0.1
 */