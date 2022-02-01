package com.tencent.mobileqq.qqlive.anchor.room;

import android.content.Context;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperFastResume;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperThirdPush;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorThirdPushChecker;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorThirdPushRoom;
import com.tencent.mobileqq.qqlive.api.impl.room.AudienceRoomPlayModule;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallback;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.qphone.base.util.QLog;

public class QQLiveAnchorThirdPushRoom
  extends QQLiveAnchorRoom
  implements IQQLiveAnchorThirdPushRoom
{
  private static final String[] s = { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE" };
  protected QQLiveAnchorHelperThirdPush q = new QQLiveAnchorHelperThirdPush();
  protected QQLiveAnchorThirdPushChecker r;
  private AudienceRoomPlayModule t = new AudienceRoomPlayModule();
  private AudienceRoomPlayerListener u = new QQLiveAnchorThirdPushRoom.1(this);
  
  public QQLiveAnchorThirdPushRoom(Context paramContext, IQQLiveSDK paramIQQLiveSDK, QQLiveAnchorRoomConfig paramQQLiveAnchorRoomConfig, IQQLiveAnchorRoomCallback paramIQQLiveAnchorRoomCallback)
  {
    super(paramContext, paramIQQLiveSDK, paramQQLiveAnchorRoomConfig, paramIQQLiveAnchorRoomCallback);
    this.t.registerRoomPlayerListener(this.u);
    this.t.setRetryParams(-1L, -1);
  }
  
  private void a(QQLiveAnchorAutoCheckPullPlayParams paramQQLiveAnchorAutoCheckPullPlayParams, String paramString, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback)
  {
    if (paramQQLiveAnchorAutoCheckPullPlayParams.autoCheckPullPlay)
    {
      QQLiveAnchorThirdPushChecker localQQLiveAnchorThirdPushChecker = this.r;
      if (localQQLiveAnchorThirdPushChecker != null) {
        localQQLiveAnchorThirdPushChecker.b(false);
      }
      this.r = new QQLiveAnchorThirdPushChecker(paramString, this.t, paramQQLiveAnchorAutoCheckPullPlayParams, paramIQQLiveAnchorRoomThirdPushCallback);
      this.r.a(paramQQLiveAnchorAutoCheckPullPlayParams.isMute);
    }
  }
  
  private void i()
  {
    this.t.setRetryParams(-1L, -1);
    this.r.b(false);
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchorThirdPushRoom", 1, "thirdpush room destroy player");
    }
    try
    {
      if (this.t == null) {
        return;
      }
      this.t.unRegisterRoomPlayerListener(this.u);
      this.t.destroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("destroyPlayer error: ");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.e("QQLiveAnchorThirdPushRoom", 1, localStringBuilder.toString());
    }
  }
  
  protected String[] a()
  {
    return s;
  }
  
  public void destroy()
  {
    super.destroy();
    j();
  }
  
  public void exitRoom(ExitRoomCallback paramExitRoomCallback)
  {
    super.exitRoom(paramExitRoomCallback);
  }
  
  public void fastResume()
  {
    if (this.isDestroy) {
      return;
    }
    super.fastResume();
    this.j.a(this, this.d);
  }
  
  public int getPlayStatus()
  {
    return 0;
  }
  
  public void getRtmpPullUrl(QQLiveAnchorAutoCheckPullPlayParams paramQQLiveAnchorAutoCheckPullPlayParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchorThirdPushRoom", 1, "thirdPushRoom getPullUrl");
    }
    if (this.isDestroy) {
      return;
    }
    this.q.b(this.liveSDK, this.c, paramQQLiveAnchorAutoCheckPullPlayParams, new QQLiveAnchorThirdPushRoom.3(this, this.d, paramQQLiveAnchorAutoCheckPullPlayParams));
  }
  
  public void getRtmpPushUrl(QQLiveAnchorAutoCheckPullPlayParams paramQQLiveAnchorAutoCheckPullPlayParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchorThirdPushRoom", 1, "thirdPushRoom getPushUrl");
    }
    if (this.isDestroy) {
      return;
    }
    this.q.a(this.liveSDK, this.c, paramQQLiveAnchorAutoCheckPullPlayParams, new QQLiveAnchorThirdPushRoom.2(this, this.d, paramQQLiveAnchorAutoCheckPullPlayParams));
  }
  
  public ITPPlayerVideoView h()
  {
    if (this.isDestroy) {
      return null;
    }
    return this.t.playerView;
  }
  
  public void pause()
  {
    if (this.isDestroy) {
      return;
    }
    this.t.pause();
  }
  
  public void play()
  {
    if (this.isDestroy) {
      return;
    }
    this.t.startPlay("");
  }
  
  public void preloadUrl(String paramString) {}
  
  public void registerRoomPlayerListener(AudienceRoomPlayerListener paramAudienceRoomPlayerListener)
  {
    if (this.isDestroy) {
      return;
    }
    this.t.registerRoomPlayerListener(paramAudienceRoomPlayerListener);
  }
  
  public void reset()
  {
    super.reset();
    j();
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (this.isDestroy) {
      return;
    }
    this.t.setMute(paramBoolean);
  }
  
  public void startPlay(String paramString) {}
  
  public void unRegisterRoomPlayerListener(AudienceRoomPlayerListener paramAudienceRoomPlayerListener)
  {
    if (this.isDestroy) {
      return;
    }
    this.t.unRegisterRoomPlayerListener(paramAudienceRoomPlayerListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorThirdPushRoom
 * JD-Core Version:    0.7.0.1
 */