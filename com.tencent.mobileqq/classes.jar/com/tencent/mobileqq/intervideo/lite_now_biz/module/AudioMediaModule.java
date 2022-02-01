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

public class AudioMediaModule
  extends RoomBizModule
{
  private LogInterface jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface;
  private LoginServiceInterface jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginServiceInterface;
  private IAudioMediaService jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaService;
  private AVPlayerBuilderServiceInterface jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface;
  private RoomServiceInterface jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceRoomServiceInterface;
  private RoomEngine jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine;
  private RequestPermission jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizPermissionRequestPermission;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaService.a(new AudioMediaModule.2(this));
  }
  
  private void a(LiveInfo paramLiveInfo)
  {
    AudioEnterRoomParam localAudioEnterRoomParam = new AudioEnterRoomParam();
    localAudioEnterRoomParam.jdField_a_of_type_Int = NowBizConfigConst.NowLiteConfig.jdField_a_of_type_Int;
    localAudioEnterRoomParam.jdField_b_of_type_Int = NowBizConfigConst.NowLiteConfig.jdField_b_of_type_Int;
    localAudioEnterRoomParam.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginServiceInterface.getLoginInfo().uid;
    localAudioEnterRoomParam.jdField_a_of_type_Long = paramLiveInfo.anchorInfo.uid;
    localAudioEnterRoomParam.jdField_c_of_type_Long = paramLiveInfo.roomInfo.roomId;
    localAudioEnterRoomParam.jdField_c_of_type_Int = paramLiveInfo.roomInfo.roomType;
    localAudioEnterRoomParam.jdField_a_of_type_ArrayOfByte = paramLiveInfo.watchMediaInfo.sig;
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaService.a(localAudioEnterRoomParam, new AudioMediaModule.1(this, localAudioEnterRoomParam));
  }
  
  private void a(boolean paramBoolean)
  {
    if (ActivityCompat.checkSelfPermission(this.context, "android.permission.RECORD_AUDIO") != 0)
    {
      c();
      return;
    }
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaService.a(paramBoolean);
  }
  
  private void b()
  {
    getEvent().observe(ChangeMicrophoneEvent.class, new AudioMediaModule.3(this));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizPermissionRequestPermission != null)
    {
      this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface.i("AudioMediaModule", "requestMicPermission", new Object[0]);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizPermissionRequestPermission = new RequestPermission().a(12).a(new String[] { "android.permission.RECORD_AUDIO" }).a(new AudioMediaModule.4(this));
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizPermissionRequestPermission.a((Activity)this.context);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.context, 230, "", HardCodeUtil.a(2131696354), HardCodeUtil.a(2131690800), HardCodeUtil.a(2131693566), new AudioMediaModule.5(this), new AudioMediaModule.6(this));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface != null) {
      this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface.uninit();
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
    this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine = getRoomEngine();
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaService = ((IAudioMediaService)this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getService(IAudioMediaService.class));
    this.jdField_a_of_type_ComTencentIlivesdkAvplayerbuilderservice_interfaceAVPlayerBuilderServiceInterface = ((AVPlayerBuilderServiceInterface)this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getService(AVPlayerBuilderServiceInterface.class));
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiLoginLoginServiceInterface = ((LoginServiceInterface)this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getService(LoginServiceInterface.class));
    this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceRoomServiceInterface = ((RoomServiceInterface)this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getService(RoomServiceInterface.class));
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface = ((LogSdkServiceInterface)this.jdField_a_of_type_ComTencentLivesdkRoomengineRoomEngine.getService(LogSdkServiceInterface.class)).getLog();
    b();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaService.a();
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    a(this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceRoomServiceInterface.getLiveInfo());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.module.AudioMediaModule
 * JD-Core Version:    0.7.0.1
 */