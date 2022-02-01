package com.tencent.mobileqq.intervideo.lite_now_biz.module;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.ActivityCompat;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.log.LogSdkServiceInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilivesdk.audiomediaservice.interfaces.AudioEnterRoomParam;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaService;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveWatchMediaInfo;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.intervideo.lite_now_biz.config.NowBizConfigConst.NowLiteConfig;
import com.tencent.mobileqq.intervideo.lite_now_biz.event.ChangeMicrophoneEvent;
import com.tencent.mobileqq.intervideo.lite_now_biz.permission.RequestPermission;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class AudioMediaModule
  extends RoomBizModule
{
  private boolean a;
  private RoomEngine b;
  private LogInterface c;
  private LoginServiceInterface d;
  private IAudioMediaService e;
  private AVPlayerBuilderServiceInterface f;
  private RequestPermission g;
  private QQCustomDialog h;
  private RoomServiceInterface i;
  
  private void a()
  {
    this.e.a(new AudioMediaModule.2(this));
  }
  
  private void a(LiveInfo paramLiveInfo)
  {
    AudioEnterRoomParam localAudioEnterRoomParam = new AudioEnterRoomParam();
    localAudioEnterRoomParam.a = NowBizConfigConst.NowLiteConfig.a;
    localAudioEnterRoomParam.b = NowBizConfigConst.NowLiteConfig.b;
    localAudioEnterRoomParam.d = this.d.getLoginInfo().uid;
    localAudioEnterRoomParam.c = paramLiveInfo.anchorInfo.uid;
    localAudioEnterRoomParam.f = paramLiveInfo.roomInfo.roomId;
    localAudioEnterRoomParam.e = paramLiveInfo.roomInfo.roomType;
    localAudioEnterRoomParam.g = paramLiveInfo.watchMediaInfo.sig;
    this.e.a(localAudioEnterRoomParam, new AudioMediaModule.1(this, localAudioEnterRoomParam));
  }
  
  private void a(boolean paramBoolean)
  {
    if (ActivityCompat.checkSelfPermission(this.context, "android.permission.RECORD_AUDIO") != 0)
    {
      c();
      return;
    }
    this.e.a(paramBoolean);
  }
  
  private void b()
  {
    getEvent().observe(ChangeMicrophoneEvent.class, new AudioMediaModule.3(this));
  }
  
  private void c()
  {
    if (this.g != null)
    {
      this.c.i("AudioMediaModule", "requestMicPermission", new Object[0]);
      return;
    }
    this.g = new RequestPermission().a(12).a(new String[] { "android.permission.RECORD_AUDIO" }).a(new AudioMediaModule.4(this));
    this.g.a((Activity)this.context);
  }
  
  private void d()
  {
    if (this.h == null) {
      this.h = DialogUtil.a(this.context, 230, "", HardCodeUtil.a(2131894145), HardCodeUtil.a(2131887648), HardCodeUtil.a(2131891076), new AudioMediaModule.5(this), new AudioMediaModule.6(this));
    }
    if (!this.h.isShowing()) {
      this.h.show();
    }
  }
  
  private void e()
  {
    AVPlayerBuilderServiceInterface localAVPlayerBuilderServiceInterface = this.f;
    if (localAVPlayerBuilderServiceInterface != null) {
      localAVPlayerBuilderServiceInterface.uninit();
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((this.context instanceof Activity)) {
      ((Activity)this.context).finish();
    }
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    this.b = getRoomEngine();
    this.e = ((IAudioMediaService)this.b.getService(IAudioMediaService.class));
    this.f = ((AVPlayerBuilderServiceInterface)this.b.getService(AVPlayerBuilderServiceInterface.class));
    this.d = ((LoginServiceInterface)this.b.getService(LoginServiceInterface.class));
    this.i = ((RoomServiceInterface)this.b.getService(RoomServiceInterface.class));
    this.c = ((LogSdkServiceInterface)this.b.getService(LogSdkServiceInterface.class)).getLog();
    b();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.e.a();
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterRoom isOutEnter=");
      localStringBuilder.append(paramBoolean);
      QLog.i("AudioMediaModule", 1, localStringBuilder.toString());
    }
    a(this.i.getLiveInfo());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.module.AudioMediaModule
 * JD-Core Version:    0.7.0.1
 */