package com.tencent.mobileqq.intervideo.lite_now_biz.now_od.services;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.service.RoomSwitchServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class ODSwitchRoomBuilder$1
  implements RoomSwitchServiceAdapter
{
  ODSwitchRoomBuilder$1(ODSwitchRoomBuilder paramODSwitchRoomBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.a.getService(ChannelInterface.class);
  }
  
  public HttpInterface getHttpInterface()
  {
    return (HttpInterface)this.a.getService(HttpInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.a.getService(LogInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_od.services.ODSwitchRoomBuilder.1
 * JD-Core Version:    0.7.0.1
 */