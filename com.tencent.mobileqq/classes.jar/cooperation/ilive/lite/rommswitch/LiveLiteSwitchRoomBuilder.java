package cooperation.ilive.lite.rommswitch;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class LiveLiteSwitchRoomBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    LiveLiteRoomSwitchService localLiveLiteRoomSwitchService = new LiveLiteRoomSwitchService();
    localLiveLiteRoomSwitchService.onCreate(BaseApplicationImpl.context);
    localLiveLiteRoomSwitchService.a(new LiveLiteSwitchRoomBuilder.1(this, paramServiceAccessor));
    return localLiveLiteRoomSwitchService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.rommswitch.LiveLiteSwitchRoomBuilder
 * JD-Core Version:    0.7.0.1
 */