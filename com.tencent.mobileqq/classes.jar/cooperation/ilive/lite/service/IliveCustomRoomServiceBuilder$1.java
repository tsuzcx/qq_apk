package cooperation.ilive.lite.service;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class IliveCustomRoomServiceBuilder$1
  implements RoomServiceAdapter
{
  IliveCustomRoomServiceBuilder$1(IliveCustomRoomServiceBuilder paramIliveCustomRoomServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public AppGeneralInfoService getAppInfo()
  {
    return (AppGeneralInfoService)this.jdField_a_of_type_ComTencentLivesdkServicefactoryServiceAccessor.getService(AppGeneralInfoService.class);
  }
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.jdField_a_of_type_ComTencentLivesdkServicefactoryServiceAccessor.getService(ChannelInterface.class);
  }
  
  public DataReportInterface getDataReporter()
  {
    return (DataReportInterface)this.jdField_a_of_type_ComTencentLivesdkServicefactoryServiceAccessor.getService(DataReportInterface.class);
  }
  
  public HostProxyInterface getHostProxyInterface()
  {
    return (HostProxyInterface)this.jdField_a_of_type_ComTencentLivesdkServicefactoryServiceAccessor.getService(HostProxyInterface.class);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveCustomRoomServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */