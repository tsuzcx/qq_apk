package cooperation.ilive.lite.rommswitch;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.service.RoomSwitchServiceAdapter;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class LiveLiteSwitchRoomBuilder$1
  implements RoomSwitchServiceAdapter
{
  LiveLiteSwitchRoomBuilder$1(LiveLiteSwitchRoomBuilder paramLiveLiteSwitchRoomBuilder, ServiceAccessor paramServiceAccessor) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.rommswitch.LiveLiteSwitchRoomBuilder.1
 * JD-Core Version:    0.7.0.1
 */