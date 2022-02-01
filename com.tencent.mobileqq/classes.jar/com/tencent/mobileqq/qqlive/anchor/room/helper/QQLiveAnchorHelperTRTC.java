package com.tencent.mobileqq.qqlive.anchor.room.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.config.IQQLiveConfigModule;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomStream;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams.Builder;
import com.tencent.mobileqq.qqlive.trtc.TRTCEngineProxy;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.StatisticDataListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class QQLiveAnchorHelperTRTC
{
  public boolean a = false;
  public boolean b = false;
  private TRTCEngineProxy c = TRTCEngineProxy.a();
  private IQQLiveAnchorRoomStream d;
  
  private void l()
  {
    this.c.a(null);
  }
  
  private void m()
  {
    this.c.a(new QQLiveAnchorHelperTRTC.4(this));
  }
  
  public void a()
  {
    if (this.a)
    {
      if (!this.b) {
        return;
      }
      ThreadManager.getUIHandler().post(new -..Lambda.QQLiveAnchorHelperTRTC.1G96R9TW_OACITgrCJ97hwbxTeY(this));
    }
  }
  
  public void a(int paramInt)
  {
    if (this.c == null) {
      return;
    }
    TRTCVideoQualityParams localTRTCVideoQualityParams = k();
    if (localTRTCVideoQualityParams == null)
    {
      QLog.e("QQLiveAnchor_TRTC", 1, "changeOrientationInner but params is null");
      return;
    }
    if (paramInt == localTRTCVideoQualityParams.getVideoResolutionMode())
    {
      QLog.e("QQLiveAnchor_TRTC", 1, "changeOrientationInner but not change");
      return;
    }
    a(new TRTCVideoQualityParams.Builder().setEnableAdjustRes(localTRTCVideoQualityParams.isEnableAdjustRes()).setMinVideoBitRate(localTRTCVideoQualityParams.getMinVideoBitRate()).setVideoBitRate(localTRTCVideoQualityParams.getVideoBitRate()).setVideoResolution(localTRTCVideoQualityParams.getVideoResolution()).setVideoFps(localTRTCVideoQualityParams.getVideoFps()).setVideoResolutionMode(paramInt).build());
  }
  
  public void a(Context paramContext, IQQLiveSDK paramIQQLiveSDK, QQLiveAnchorHelperTRTC.Callback paramCallback)
  {
    this.a = false;
    this.c.a(paramContext, paramIQQLiveSDK.getConfigModule().getConfigData(), new QQLiveAnchorHelperTRTC.1(this, paramCallback));
    this.c.a(new QQLiveAnchorHelperTRTC.2(this));
  }
  
  public void a(Bitmap paramBitmap, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_TRTC", 1, "pausePublishStream, pause");
    }
    if (this.a)
    {
      TRTCEngineProxy localTRTCEngineProxy = this.c;
      if (localTRTCEngineProxy == null) {
        return;
      }
      try
      {
        localTRTCEngineProxy.a(paramBitmap, paramInt);
        return;
      }
      catch (Throwable paramBitmap)
      {
        QLog.e("QQLiveAnchor_TRTC", 1, paramBitmap, new Object[0]);
      }
    }
  }
  
  public void a(IQQLiveAnchorRoomStream paramIQQLiveAnchorRoomStream)
  {
    this.d = paramIQQLiveAnchorRoomStream;
  }
  
  public void a(QQLiveAnchorRoomConfig paramQQLiveAnchorRoomConfig)
  {
    if (this.a)
    {
      if (!this.b) {
        return;
      }
      if (paramQQLiveAnchorRoomConfig.streamRecordType == QQLiveAnchorStreamRecordType.CAMERA) {
        this.c.f();
      }
    }
  }
  
  public void a(QQLiveAnchorRoomConfig paramQQLiveAnchorRoomConfig, FrameLayout paramFrameLayout)
  {
    if (this.a)
    {
      if (this.b) {
        return;
      }
      ThreadManager.getUIHandler().post(new QQLiveAnchorHelperTRTC.3(this, paramFrameLayout, paramQQLiveAnchorRoomConfig));
    }
  }
  
  public void a(QQLiveAnchorRoomConfig paramQQLiveAnchorRoomConfig, boolean paramBoolean)
  {
    if (this.a)
    {
      if (!this.b) {
        return;
      }
      if (paramQQLiveAnchorRoomConfig.streamRecordType == QQLiveAnchorStreamRecordType.CAMERA) {
        this.c.d(paramBoolean);
      }
    }
  }
  
  public void a(QQLiveRoomParams paramQQLiveRoomParams)
  {
    if (!this.a) {
      return;
    }
    try
    {
      this.c.a(paramQQLiveRoomParams);
      return;
    }
    catch (Throwable paramQQLiveRoomParams)
    {
      QLog.e("QQLiveAnchor_TRTC", 1, paramQQLiveRoomParams, new Object[0]);
    }
  }
  
  public void a(TRTCVideoQualityParams paramTRTCVideoQualityParams)
  {
    TRTCEngineProxy localTRTCEngineProxy = this.c;
    if (localTRTCEngineProxy != null) {
      localTRTCEngineProxy.a(paramTRTCVideoQualityParams);
    }
  }
  
  public void a(StatisticDataListener paramStatisticDataListener)
  {
    TRTCEngineProxy localTRTCEngineProxy = this.c;
    if (localTRTCEngineProxy != null) {
      localTRTCEngineProxy.a(paramStatisticDataListener);
    }
  }
  
  public void b()
  {
    if (this.a)
    {
      if (this.b) {
        return;
      }
      ThreadManager.getUIHandler().post(new -..Lambda.QQLiveAnchorHelperTRTC.xD2i9iu3aTV2of2_1T_v5ReWGO0(this));
    }
  }
  
  public void c()
  {
    if (this.a)
    {
      if (!this.b) {
        return;
      }
      ThreadManager.getUIHandler().post(new -..Lambda.QQLiveAnchorHelperTRTC.Bk7Ez51aYKpUVQfJTGxqU8l2d5c(this));
    }
  }
  
  public void d()
  {
    ThreadManager.getUIHandler().post(new -..Lambda.QQLiveAnchorHelperTRTC.zde1qXLTzUtaMTC1_8I5w0KRoqE(this));
  }
  
  public void e()
  {
    ThreadManager.getUIHandler().post(new -..Lambda.QQLiveAnchorHelperTRTC.ptUYN19VyOa50g5mCtlF6RdTbtY(this));
  }
  
  public void f()
  {
    if (!this.a) {
      return;
    }
    try
    {
      this.c.i();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQLiveAnchor_TRTC", 1, localThrowable, new Object[0]);
    }
  }
  
  public boolean g()
  {
    if (!this.a) {
      return false;
    }
    return this.c.o();
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_TRTC", 1, "resumePublishStream, resume");
    }
    if (this.a)
    {
      TRTCEngineProxy localTRTCEngineProxy = this.c;
      if (localTRTCEngineProxy == null) {
        return;
      }
      try
      {
        localTRTCEngineProxy.q();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQLiveAnchor_TRTC", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public boolean i()
  {
    TRTCEngineProxy localTRTCEngineProxy = this.c;
    if (localTRTCEngineProxy != null) {
      return localTRTCEngineProxy.r();
    }
    return false;
  }
  
  public void j()
  {
    if (this.c == null) {
      return;
    }
    f();
    e();
    c();
    a();
    try
    {
      this.c.a(null);
      this.c.a(null);
      this.c.a(null);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQLiveAnchor_TRTC", 1, localThrowable, new Object[0]);
    }
  }
  
  public TRTCVideoQualityParams k()
  {
    TRTCEngineProxy localTRTCEngineProxy = this.c;
    if (localTRTCEngineProxy != null) {
      return localTRTCEngineProxy.n();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperTRTC
 * JD-Core Version:    0.7.0.1
 */