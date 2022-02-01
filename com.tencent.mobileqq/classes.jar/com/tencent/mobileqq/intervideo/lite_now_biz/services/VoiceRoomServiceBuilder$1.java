package com.tencent.mobileqq.intervideo.lite_now_biz.services;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class VoiceRoomServiceBuilder$1
  implements RoomServiceAdapter
{
  VoiceRoomServiceBuilder$1(VoiceRoomServiceBuilder paramVoiceRoomServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public AppGeneralInfoService getAppInfo()
  {
    return (AppGeneralInfoService)this.a.getService(AppGeneralInfoService.class);
  }
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.a.getService(ChannelInterface.class);
  }
  
  public DataReportInterface getDataReporter()
  {
    return (DataReportInterface)this.a.getService(DataReportInterface.class);
  }
  
  public HostProxyInterface getHostProxyInterface()
  {
    return (HostProxyInterface)this.a.getService(HostProxyInterface.class);
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
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.services.VoiceRoomServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */