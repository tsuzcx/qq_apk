package com.tencent.mobileqq.qqlive.trtc.engine;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.mobileqq.qqlive.trtc.ITRTCEngine;
import com.tencent.mobileqq.qqlive.trtc.audio.ITRTCAudioBaseSource;
import com.tencent.mobileqq.qqlive.trtc.audio.ITRTCAudioSource;
import com.tencent.mobileqq.qqlive.trtc.audio.TRTCAudioSource;
import com.tencent.mobileqq.qqlive.trtc.render.ILocalRender;
import com.tencent.mobileqq.qqlive.trtc.render.TRTCRenderCtrl;
import com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomCtrl;
import com.tencent.mobileqq.qqlive.trtc.room.TRTCRoomCtrl;
import com.tencent.mobileqq.qqlive.trtc.video.source.ITRTCVideoBaseSource;
import com.tencent.mobileqq.qqlive.trtc.video.source.camera.ITRTCCameraCaptureSource;
import com.tencent.mobileqq.qqlive.trtc.video.source.camera.TRTCCameraCaptureSource;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.ITRTCInnerCaptureEventListener;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.ITRTCScreenCaptureSource;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.StatisticDataListener;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.TRTCScreenCaptureSource;
import com.tencent.mobileqq.qqlive.trtc.video.videoprocess.ITRTCVideoPreProcess;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trtc.TRTCCloud;
import mqq.util.WeakReference;

public class QQLiveTRTCEngineImpl
  implements ITRTCEngine
{
  private TRTCCloud a;
  private TRTCInnerCloudListener b;
  private WeakReference<Context> c;
  private TRTCEngineContext d;
  private final boolean e = false;
  private int f = 0;
  private ITRTCVideoBaseSource g;
  private ITRTCAudioBaseSource h;
  private ILocalRender i;
  private TRTCRoomCtrl j;
  private ITRTCVideoPreProcess k;
  private Looper l;
  private Handler m;
  
  private int a(Context paramContext, ConfigData paramConfigData)
  {
    if (paramContext == null)
    {
      this.f = 3;
      QLog.e("QQLiveTRTCEngine", 1, "initEngine: context is null!");
      return -2001002;
    }
    if (g())
    {
      QLog.i("QQLiveTRTCEngine", 1, "Engine already init success!");
      return 0;
    }
    this.c = new WeakReference(paramContext.getApplicationContext());
    Looper localLooper = this.l;
    if ((localLooper != null) && (localLooper.getThread().isAlive())) {
      this.m = new Handler(this.l);
    } else {
      this.m = new Handler(Looper.getMainLooper());
    }
    this.a = TRTCCloud.sharedInstance(paramContext);
    this.d = new TRTCEngineContext();
    paramContext = this.d;
    paramContext.c = paramConfigData;
    paramContext.b = this.c;
    paramContext.a = this.a;
    this.i = new TRTCRenderCtrl(paramContext);
    this.j = new TRTCRoomCtrl(this.d);
    this.j.a(this.m);
    this.b = new TRTCInnerCloudListener();
    this.b.a(this.j);
    this.a.setListener(this.b);
    this.f = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveTRTCEngine", 2, "initEngine successful!");
    }
    return 0;
  }
  
  private boolean g()
  {
    return this.f == 2;
  }
  
  @NonNull
  public <T extends ITRTCVideoBaseSource> T a(@NonNull Class<T> paramClass)
  {
    if (g())
    {
      if (this.g == null) {
        QLog.w("QQLiveTRTCEngine", 1, "getCurrentVideoSource: video source not set.");
      }
      if (!paramClass.isInstance(this.g))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCurrentVideoSource: cls type different. ");
        localStringBuilder.append(paramClass.toString());
        QLog.w("QQLiveTRTCEngine", 1, localStringBuilder.toString());
        return null;
      }
      return this.g;
    }
    throw new IllegalStateException("getCurrentVideoSource: not init.");
  }
  
  public void a()
  {
    f();
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.f = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(@NonNull Context paramContext, @NonNull ConfigData paramConfigData, TRTCInitCallback paramTRTCInitCallback)
  {
    if (g())
    {
      if (paramConfigData.equals(c().c))
      {
        paramContext = new StringBuilder();
        paramContext.append("already init config ");
        paramContext.append(paramConfigData.getLiveAppId());
        QLog.d("QQLiveTRTCEngine", 1, paramContext.toString());
        if (paramTRTCInitCallback != null) {
          paramTRTCInitCallback.a(b(), 0);
        }
        return;
      }
      QLog.w("QQLiveTRTCEngine", 1, "init different config data!");
      f();
    }
    a(Looper.getMainLooper());
    a(1);
    QLog.d("QQLiveTRTCEngine", 1, "initEngine doing!");
    SoLoadManager.getInstance().load("trtc_entry", new QQLiveTRTCEngineImpl.1(this, paramContext, paramConfigData, paramTRTCInitCallback));
  }
  
  public void a(@Nullable ITRTCAudioBaseSource paramITRTCAudioBaseSource)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setAudioSource: ");
      ((StringBuilder)localObject).append(paramITRTCAudioBaseSource);
      QLog.i("QQLiveTRTCEngine", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.h;
    if (paramITRTCAudioBaseSource == localObject)
    {
      QLog.w("QQLiveTRTCEngine", 1, "setAudioSource: ignore. set the same audio source.");
      return;
    }
    if (localObject != null) {
      ((ITRTCAudioBaseSource)localObject).a();
    }
    this.h = paramITRTCAudioBaseSource;
    paramITRTCAudioBaseSource = this.h;
    if (paramITRTCAudioBaseSource != null)
    {
      paramITRTCAudioBaseSource.a(this.d);
      this.h.a(this.m);
    }
  }
  
  public void a(@Nullable ITRTCVideoBaseSource paramITRTCVideoBaseSource)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setVideoSource: ");
      ((StringBuilder)localObject).append(paramITRTCVideoBaseSource);
      QLog.i("QQLiveTRTCEngine", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.g;
    if (localObject == paramITRTCVideoBaseSource) {
      return;
    }
    if (localObject != null) {
      ((ITRTCVideoBaseSource)localObject).e();
    }
    this.g = paramITRTCVideoBaseSource;
    paramITRTCVideoBaseSource = this.g;
    if (paramITRTCVideoBaseSource != null)
    {
      paramITRTCVideoBaseSource.a(this.d);
      this.g.a(this.m);
    }
    paramITRTCVideoBaseSource = this.g;
    if ((paramITRTCVideoBaseSource instanceof ITRTCScreenCaptureSource))
    {
      paramITRTCVideoBaseSource = (ITRTCInnerCaptureEventListener)paramITRTCVideoBaseSource;
      localObject = this.b;
      if (localObject != null) {
        ((TRTCInnerCloudListener)localObject).a(paramITRTCVideoBaseSource);
      }
    }
  }
  
  public void a(StatisticDataListener paramStatisticDataListener)
  {
    TRTCInnerCloudListener localTRTCInnerCloudListener = this.b;
    if ((localTRTCInnerCloudListener != null) && (paramStatisticDataListener != null)) {
      localTRTCInnerCloudListener.a(paramStatisticDataListener);
    }
  }
  
  public boolean a(Looper paramLooper)
  {
    if (this.f != 0) {
      return false;
    }
    this.l = paramLooper;
    return true;
  }
  
  public int b()
  {
    return this.f;
  }
  
  public <T extends ITRTCAudioBaseSource> T b(@NonNull Class<T> paramClass)
  {
    if (g())
    {
      if (paramClass.isInstance(this.h)) {
        return this.h;
      }
      throw new IllegalArgumentException("no audio source of the specified type");
    }
    throw new IllegalStateException("getCurrentAudioSource: not init.");
  }
  
  @Nullable
  public <T extends ITRTCAudioBaseSource> T c(@NonNull Class<T> paramClass)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create TRTC audio source, class name:");
    localStringBuilder.append(paramClass.getSimpleName());
    QLog.i("QQLiveTRTCEngine", 2, localStringBuilder.toString());
    if (paramClass.equals(ITRTCAudioSource.class))
    {
      QLog.i("QQLiveTRTCEngine", 2, "create music accompany effect.");
      return new TRTCAudioSource();
    }
    QLog.e("QQLiveTRTCEngine", 1, "not support effect type.");
    return null;
  }
  
  public TRTCEngineContext c()
  {
    return this.d;
  }
  
  public ILocalRender d()
  {
    return this.i;
  }
  
  public <T extends ITRTCVideoBaseSource> T d(@NonNull Class<T> paramClass)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("create TRTC video source, class name:");
      localStringBuilder.append(paramClass.getSimpleName());
      QLog.i("QQLiveTRTCEngine", 2, localStringBuilder.toString());
    }
    if (paramClass.equals(ITRTCCameraCaptureSource.class)) {
      return new TRTCCameraCaptureSource();
    }
    if (paramClass.equals(ITRTCScreenCaptureSource.class)) {
      return new TRTCScreenCaptureSource();
    }
    return null;
  }
  
  public ITRTCRoomCtrl e()
  {
    return this.j;
  }
  
  public void f()
  {
    try
    {
      QLog.i("QQLiveTRTCEngine", 1, "now destroy TRTC Engine!");
      if (this.j != null) {
        this.j.c();
      }
      if (this.g != null) {
        this.g.e();
      }
      if (this.h != null) {
        this.h.a();
      }
      if (this.i != null) {
        this.i.a();
      }
      if (this.k != null)
      {
        this.k.a();
        this.k = null;
      }
      if (this.a != null)
      {
        this.a.setListener(null);
        this.b = null;
        this.a = null;
        TRTCCloud.destroySharedInstance();
      }
      this.d = null;
      this.f = 0;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.engine.QQLiveTRTCEngineImpl
 * JD-Core Version:    0.7.0.1
 */