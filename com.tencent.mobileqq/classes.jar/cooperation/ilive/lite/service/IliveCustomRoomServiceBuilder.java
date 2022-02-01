package cooperation.ilive.lite.service;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class IliveCustomRoomServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    IliveCustomRoomService localIliveCustomRoomService = new IliveCustomRoomService();
    localIliveCustomRoomService.init(new IliveCustomRoomServiceBuilder.1(this, paramServiceAccessor));
    return localIliveCustomRoomService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveCustomRoomServiceBuilder
 * JD-Core Version:    0.7.0.1
 */