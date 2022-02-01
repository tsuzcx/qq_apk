package com.tencent.mobileqq.intervideo.lite_now_biz.now_live.services;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.service.RoomSwitchServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class NowSwitchRoomBuilder$1
  implements RoomSwitchServiceAdapter
{
  NowSwitchRoomBuilder$1(NowSwitchRoomBuilder paramNowSwitchRoomBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.jdField_a_of_type_ComTencentLivesdkServicefactoryServiceAccessor.getService(ChannelInterface.class);
  }
  
  public HttpInterface getHttpInterface()
  {
    return (HttpInterface)this.jdField_a_of_type_ComTencentLivesdkServicefactoryServiceAccessor.getService(HttpInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.jdField_a_of_type_ComTencentLivesdkServicefactoryServiceAccessor.getService(LogInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.services.NowSwitchRoomBuilder.1
 * JD-Core Version:    0.7.0.1
 */