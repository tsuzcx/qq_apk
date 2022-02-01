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
import com.tencent.mobileqq.qqlive.trtc.audio.TRTCFakeAudioSource;
import com.tencent.mobileqq.qqlive.trtc.ipc.TRTCIPCManager;
import com.tencent.mobileqq.qqlive.trtc.ipc.TRTCServerIPCModule;
import com.tencent.mobileqq.qqlive.trtc.render.ILocalRender;
import com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomCtrl;
import com.tencent.mobileqq.qqlive.trtc.room.TRTCFakeRoomCtrl;
import com.tencent.mobileqq.qqlive.trtc.video.source.ITRTCVideoBaseSource;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.ITRTCScreenCaptureSource;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.StatisticDataListener;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.TRTCFakeScreenCaptureSource;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class TRTCFakeEngineImpl
  implements ITRTCEngine
{
  private final TRTCEngineContext a = new TRTCEngineContext();
  private final Handler b = new Handler(Looper.getMainLooper());
  private TRTCFakeRoomCtrl c;
  private volatile int d = 0;
  private ITRTCVideoBaseSource e;
  private ITRTCAudioBaseSource f;
  
  private void f()
  {
    if (this.c == null) {
      this.c = new TRTCFakeRoomCtrl();
    }
    if (this.f == null) {
      a(new TRTCFakeAudioSource());
    }
    if (this.e == null) {
      a(new TRTCFakeScreenCaptureSource());
    }
  }
  
  private boolean g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isEngineInitSuccess engine state ");
    localStringBuilder.append(this.d);
    QLog.d("TRTCFakeEngineImpl", 1, localStringBuilder.toString());
    return this.d == 2;
  }
  
  public <T extends ITRTCVideoBaseSource> T a(@NonNull Class<T> paramClass)
  {
    if (g())
    {
      ITRTCVideoBaseSource localITRTCVideoBaseSource = this.e;
      if (localITRTCVideoBaseSource != null)
      {
        if (paramClass.isInstance(localITRTCVideoBaseSource)) {
          return this.e;
        }
        throw new IllegalArgumentException("getCurrentVideoSource: cls type different.");
      }
      QLog.w("TRTCFakeEngineImpl", 1, "getCurrentVideoSource: video source not set.");
      throw new IllegalStateException("getCurrentVideoSource: video source not set.");
    }
    throw new IllegalStateException("getCurrentVideoSource: not init.");
  }
  
  public void a()
  {
    QLog.e("TRTCFakeEngineImpl", 1, "resetEngine and stop service!");
    TRTCServerIPCModule.a("Action_Client_Destroy_SDK", null, null);
    Object localObject = this.f;
    if (localObject != null)
    {
      ((ITRTCAudioBaseSource)localObject).a();
      this.f = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((ITRTCVideoBaseSource)localObject).e();
      this.e = null;
    }
    TRTCIPCManager.b().d();
    localObject = this.c;
    if (localObject != null)
    {
      ((TRTCFakeRoomCtrl)localObject).c();
      this.c = null;
    }
    this.d = 0;
    this.a.b();
  }
  
  public void a(@NonNull Context paramContext, @NonNull ConfigData paramConfigData, TRTCInitCallback paramTRTCInitCallback)
  {
    this.a.b = new WeakReference(paramContext.getApplicationContext());
    this.a.c = paramConfigData;
    if (this.d == 2)
    {
      if (paramTRTCInitCallback != null) {
        paramTRTCInitCallback.a(this.d, 0);
      }
      return;
    }
    this.d = 1;
    SoLoadManager.getInstance().load("trtc_entry", new TRTCFakeEngineImpl.1(this, paramTRTCInitCallback, paramContext, paramConfigData));
  }
  
  public void a(@Nullable ITRTCAudioBaseSource paramITRTCAudioBaseSource)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setAudioSource: ");
      ((StringBuilder)localObject).append(paramITRTCAudioBaseSource);
      QLog.i("TRTCFakeEngineImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.f;
    if (paramITRTCAudioBaseSource == localObject)
    {
      QLog.w("TRTCFakeEngineImpl", 1, "setAudioSource: ignore. set the same audio source.");
      return;
    }
    if (localObject != null) {
      ((ITRTCAudioBaseSource)localObject).a();
    }
    this.f = paramITRTCAudioBaseSource;
    paramITRTCAudioBaseSource = this.f;
    if (paramITRTCAudioBaseSource != null)
    {
      paramITRTCAudioBaseSource.a(this.a);
      this.f.a(this.b);
    }
  }
  
  public void a(@Nullable ITRTCVideoBaseSource paramITRTCVideoBaseSource)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setVideoSource: ");
      ((StringBuilder)localObject).append(paramITRTCVideoBaseSource);
      QLog.i("TRTCFakeEngineImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.e;
    if (localObject == paramITRTCVideoBaseSource) {
      return;
    }
    if (localObject != null) {
      ((ITRTCVideoBaseSource)localObject).e();
    }
    this.e = paramITRTCVideoBaseSource;
    paramITRTCVideoBaseSource = this.e;
    if (paramITRTCVideoBaseSource != null)
    {
      paramITRTCVideoBaseSource.a(this.a);
      this.e.a(this.b);
    }
  }
  
  public void a(StatisticDataListener paramStatisticDataListener) {}
  
  public int b()
  {
    return this.d;
  }
  
  public <T extends ITRTCAudioBaseSource> T b(@NonNull Class<T> paramClass)
  {
    if (g())
    {
      if (paramClass.isInstance(this.f)) {
        return this.f;
      }
      throw new IllegalArgumentException("no audio source of the specified type");
    }
    throw new IllegalStateException("getCurrentAudioSource: not init.");
  }
  
  public <T extends ITRTCAudioBaseSource> T c(@NonNull Class<T> paramClass)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create TRTC audio source, class name:");
    localStringBuilder.append(paramClass.getSimpleName());
    QLog.i("TRTCFakeEngineImpl", 2, localStringBuilder.toString());
    if (paramClass.equals(ITRTCAudioSource.class))
    {
      QLog.i("TRTCFakeEngineImpl", 2, "create music accompany effect.");
      return new TRTCFakeAudioSource();
    }
    QLog.e("TRTCFakeEngineImpl", 1, "not support effect type.");
    return null;
  }
  
  public TRTCEngineContext c()
  {
    return this.a;
  }
  
  public ILocalRender d()
  {
    return null;
  }
  
  public <T extends ITRTCVideoBaseSource> T d(@NonNull Class<T> paramClass)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("create TRTC video source, class name:");
      localStringBuilder.append(paramClass.getSimpleName());
      QLog.i("TRTCFakeEngineImpl", 2, localStringBuilder.toString());
    }
    if (paramClass.equals(ITRTCScreenCaptureSource.class)) {
      return new TRTCFakeScreenCaptureSource();
    }
    return null;
  }
  
  public ITRTCRoomCtrl e()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.engine.TRTCFakeEngineImpl
 * JD-Core Version:    0.7.0.1
 */