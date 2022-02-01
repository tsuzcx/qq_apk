package com.tencent.mobileqq.qqlive.anchor.room;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperFastResume;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperLogin;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperTRTC;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorTRTCRoom;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallback;
import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveCameraFilterLoaderListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveCameraBeautyInfo;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveCameraFilterInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataInit;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.filter.QQLiveAEFilterProcess;
import com.tencent.mobileqq.qqlive.filter.QQLiveAEResManager;
import java.util.List;

public class QQLiveAnchorTRTCRoom
  extends QQLiveAnchorRoom
  implements IQQLiveAnchorTRTCRoom
{
  private static final String[] t = { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.RECORD_AUDIO", "android.permission.MODIFY_AUDIO_SETTINGS", "android.permission.BLUETOOTH", "android.permission.CAMERA" };
  protected QQLiveAnchorHelperTRTC q = new QQLiveAnchorHelperTRTC();
  protected boolean r = false;
  protected boolean s = false;
  private FrameLayout u = new FrameLayout(this.a);
  private QQLiveAEFilterProcess v;
  
  public QQLiveAnchorTRTCRoom(Context paramContext, IQQLiveSDK paramIQQLiveSDK, QQLiveAnchorRoomConfig paramQQLiveAnchorRoomConfig, IQQLiveAnchorRoomCallback paramIQQLiveAnchorRoomCallback)
  {
    super(paramContext, paramIQQLiveSDK, paramQQLiveAnchorRoomConfig, paramIQQLiveAnchorRoomCallback);
    this.d.a(new QQLiveAnchorTRTCRoom.1(this));
    this.q.a(this.d);
    this.q.a(new QQLiveAnchorTRTCRoom.2(this));
  }
  
  private boolean k()
  {
    if (!this.isExitRoom)
    {
      if (this.isDestroy) {
        return false;
      }
      if ((this.s) && (!this.isInited)) {
        return this.r;
      }
    }
    return false;
  }
  
  private void l()
  {
    this.isInited = true;
    this.s = false;
    this.d.a(new QQLiveAnchorDataInit(true, null));
  }
  
  private void m()
  {
    if (this.isDestroy) {
      return;
    }
    this.q.a(this.a, this.liveSDK, new QQLiveAnchorTRTCRoom.4(this));
  }
  
  private boolean n()
  {
    return (this.b != null) && (this.b.streamRecordType == QQLiveAnchorStreamRecordType.CAMERA);
  }
  
  private boolean o()
  {
    return (this.b != null) && (this.b.streamRecordType == QQLiveAnchorStreamRecordType.SCREEN);
  }
  
  protected void a(QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    super.a(paramQQLiveErrorMsg);
    this.s = false;
  }
  
  protected String[] a()
  {
    return t;
  }
  
  public void changeAnchorCameraBeauty(QQLiveCameraBeautyInfo paramQQLiveCameraBeautyInfo)
  {
    if (this.isDestroy) {
      return;
    }
    if (!n()) {
      return;
    }
    QQLiveAEFilterProcess localQQLiveAEFilterProcess = this.v;
    if (localQQLiveAEFilterProcess != null) {
      localQQLiveAEFilterProcess.a(paramQQLiveCameraBeautyInfo.name, paramQQLiveCameraBeautyInfo.customValue, paramQQLiveCameraBeautyInfo.isSelected);
    }
  }
  
  public void changeAnchorCameraFilter(QQLiveCameraFilterInfo paramQQLiveCameraFilterInfo, QQLiveCameraFilterLoaderListener paramQQLiveCameraFilterLoaderListener)
  {
    if (this.isDestroy) {
      return;
    }
    if (!n()) {
      return;
    }
    QQLiveAEFilterProcess localQQLiveAEFilterProcess = this.v;
    if (localQQLiveAEFilterProcess != null) {
      localQQLiveAEFilterProcess.a(paramQQLiveCameraFilterInfo, paramQQLiveCameraFilterLoaderListener);
    }
  }
  
  public void changeOrientation(int paramInt)
  {
    QQLiveAnchorHelperTRTC localQQLiveAnchorHelperTRTC = this.q;
    if (localQQLiveAnchorHelperTRTC != null) {
      localQQLiveAnchorHelperTRTC.a(paramInt);
    }
  }
  
  protected void d()
  {
    if (!this.isDestroy)
    {
      if (this.e != QQLiveAnchorRoomState.STATE_INIT_ING) {
        return;
      }
      if (this.isInited) {}
    }
    for (;;)
    {
      try
      {
        if ((!this.isInited) && (this.g.a) && (this.q.a))
        {
          a(QQLiveAnchorRoomState.STATE_INIT_READY);
          if (this.b.streamRecordType != QQLiveAnchorStreamRecordType.SCREEN) {
            break label108;
          }
          bool = true;
          this.r = bool;
          h();
          if (!this.r) {
            l();
          }
        }
        return;
      }
      finally {}
      return;
      label108:
      boolean bool = false;
    }
  }
  
  public void destroy()
  {
    super.destroy();
    QQLiveAnchorHelperTRTC localQQLiveAnchorHelperTRTC = this.q;
    if (localQQLiveAnchorHelperTRTC != null) {
      localQQLiveAnchorHelperTRTC.j();
    }
  }
  
  public void exitRoom(ExitRoomCallback paramExitRoomCallback)
  {
    super.exitRoom(paramExitRoomCallback);
    this.q.f();
    this.q.a(null);
    if (this.b.streamRecordType == QQLiveAnchorStreamRecordType.CAMERA) {
      this.q.a();
    } else if (this.b.streamRecordType == QQLiveAnchorStreamRecordType.SCREEN) {
      this.q.c();
    }
    this.q.e();
  }
  
  public void fastResume()
  {
    if (this.isDestroy) {
      return;
    }
    super.fastResume();
    this.j.a(this, this.d);
  }
  
  public List<QQLiveCameraBeautyInfo> getAnchorCameraBeautyInfo(Context paramContext)
  {
    if (this.isDestroy) {
      return null;
    }
    if (!n()) {
      return null;
    }
    return QQLiveAEResManager.a().c();
  }
  
  public List<QQLiveCameraFilterInfo> getAnchorCameraFilterInfo(Context paramContext)
  {
    if (this.isDestroy) {
      return null;
    }
    if (!n()) {
      return null;
    }
    return (List)QQLiveAEResManager.a().b().getValue();
  }
  
  public TRTCVideoQualityParams getVideoQuality()
  {
    QQLiveAnchorHelperTRTC localQQLiveAnchorHelperTRTC = this.q;
    if (localQQLiveAnchorHelperTRTC != null) {
      return localQQLiveAnchorHelperTRTC.k();
    }
    return null;
  }
  
  public void h()
  {
    if (this.b.streamRecordType == QQLiveAnchorStreamRecordType.CAMERA)
    {
      startCameraPreview();
      if (this.b.openAudio) {
        startAudioRecord();
      }
    }
    if (this.b.streamRecordType == QQLiveAnchorStreamRecordType.SCREEN)
    {
      startScreenCapturePreview();
      if (this.b.openAudio) {
        startAudioRecord();
      }
    }
  }
  
  public void i()
  {
    if (this.isDestroy) {
      return;
    }
    if (!n()) {}
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    if (this.isDestroy) {
      return;
    }
    this.s = true;
    super.init(paramIQQLiveSDK);
    if (this.n)
    {
      m();
      i();
    }
  }
  
  public boolean isCameraMirror()
  {
    if (this.isDestroy) {
      return false;
    }
    return this.q.g();
  }
  
  public boolean isMicEnable()
  {
    QQLiveAnchorHelperTRTC localQQLiveAnchorHelperTRTC = this.q;
    if (localQQLiveAnchorHelperTRTC != null) {
      return localQQLiveAnchorHelperTRTC.i();
    }
    return false;
  }
  
  public FrameLayout j()
  {
    if (this.isDestroy) {
      return null;
    }
    return this.u;
  }
  
  public void pausePublishStream(Bitmap paramBitmap, int paramInt)
  {
    QQLiveAnchorHelperTRTC localQQLiveAnchorHelperTRTC = this.q;
    if (localQQLiveAnchorHelperTRTC != null) {
      localQQLiveAnchorHelperTRTC.a(paramBitmap, paramInt);
    }
  }
  
  public void prepare(Activity paramActivity)
  {
    super.prepare(paramActivity);
  }
  
  public void resumePublishStream()
  {
    QQLiveAnchorHelperTRTC localQQLiveAnchorHelperTRTC = this.q;
    if (localQQLiveAnchorHelperTRTC != null) {
      localQQLiveAnchorHelperTRTC.h();
    }
  }
  
  public void setCameraMirror(boolean paramBoolean)
  {
    if (this.isDestroy) {
      return;
    }
    this.q.a(this.b, paramBoolean);
  }
  
  public void setMute(boolean paramBoolean) {}
  
  public void setVideoQuality(TRTCVideoQualityParams paramTRTCVideoQualityParams)
  {
    QQLiveAnchorHelperTRTC localQQLiveAnchorHelperTRTC = this.q;
    if (localQQLiveAnchorHelperTRTC != null) {
      localQQLiveAnchorHelperTRTC.a(paramTRTCVideoQualityParams);
    }
  }
  
  public void startAudioRecord()
  {
    QQLiveAnchorHelperTRTC localQQLiveAnchorHelperTRTC = this.q;
    if (localQQLiveAnchorHelperTRTC != null) {
      localQQLiveAnchorHelperTRTC.d();
    }
  }
  
  public void startCameraPreview()
  {
    if (!n()) {
      return;
    }
    if (this.b.streamRecordType != QQLiveAnchorStreamRecordType.CAMERA) {
      return;
    }
    QQLiveAnchorHelperTRTC localQQLiveAnchorHelperTRTC = this.q;
    if (localQQLiveAnchorHelperTRTC != null) {
      localQQLiveAnchorHelperTRTC.a(this.b, this.u);
    }
  }
  
  public void startScreenCapturePreview()
  {
    if (!o()) {
      return;
    }
    QQLiveAnchorHelperTRTC localQQLiveAnchorHelperTRTC = this.q;
    if (localQQLiveAnchorHelperTRTC != null) {
      localQQLiveAnchorHelperTRTC.b();
    }
  }
  
  public void stopAudioRecord()
  {
    QQLiveAnchorHelperTRTC localQQLiveAnchorHelperTRTC = this.q;
    if (localQQLiveAnchorHelperTRTC != null) {
      localQQLiveAnchorHelperTRTC.e();
    }
  }
  
  public void stopCameraPreview()
  {
    if (!n()) {
      return;
    }
    if (this.b.streamRecordType != QQLiveAnchorStreamRecordType.CAMERA) {
      return;
    }
    Object localObject = this.u;
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViews();
    }
    localObject = this.q;
    if (localObject != null) {
      ((QQLiveAnchorHelperTRTC)localObject).a();
    }
  }
  
  public void stopScreenCapturePreview()
  {
    if (!o()) {
      return;
    }
    QQLiveAnchorHelperTRTC localQQLiveAnchorHelperTRTC = this.q;
    if (localQQLiveAnchorHelperTRTC != null) {
      localQQLiveAnchorHelperTRTC.c();
    }
  }
  
  public void switchAnchorCamera()
  {
    if (this.isDestroy) {
      return;
    }
    this.q.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorTRTCRoom
 * JD-Core Version:    0.7.0.1
 */