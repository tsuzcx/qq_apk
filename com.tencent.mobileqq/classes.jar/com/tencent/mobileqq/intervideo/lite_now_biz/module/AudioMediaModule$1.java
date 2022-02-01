package com.tencent.mobileqq.intervideo.lite_now_biz.module;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilivesdk.audiomediaservice.interfaces.AudioEnterRoomParam;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceListener;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.mobileqq.intervideo.lite_now_biz.report.DataReport;

class AudioMediaModule$1
  implements IAudioMediaServiceListener
{
  AudioMediaModule$1(AudioMediaModule paramAudioMediaModule, AudioEnterRoomParam paramAudioEnterRoomParam) {}
  
  public void a()
  {
    AudioMediaModule.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizModuleAudioMediaModule).i("AudioMediaModule", "audioCoreEventCallback: onAVStart", new Object[0]);
    AudioMediaModule.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizModuleAudioMediaModule);
    AudioMediaModule.b(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizModuleAudioMediaModule);
    DataReport.a(AudioMediaModule.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizModuleAudioMediaModule).getEnterRoomInfo().extData, String.valueOf(this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesAudioEnterRoomParam.b), this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesAudioEnterRoomParam.a, this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesAudioEnterRoomParam.c);
  }
  
  public void a(int paramInt, String paramString)
  {
    AudioMediaModule.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizModuleAudioMediaModule).i("AudioMediaModule", "onError: evenId[%d] msg[%s]", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public void b()
  {
    AudioMediaModule.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizModuleAudioMediaModule).i("AudioMediaModule", "audioCoreEventCallback: onAVStop", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.module.AudioMediaModule.1
 * JD-Core Version:    0.7.0.1
 */