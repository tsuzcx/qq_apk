package cooperation.ilive.lite.service;

import android.content.Context;
import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room.DefaultCustomRoomService;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import kotlin.Pair;
import mqq.os.MqqHandler;

public class IliveCustomRoomService
  extends DefaultCustomRoomService
{
  private Context a;
  private RoomServiceAdapter b;
  
  public RoomServiceAdapter a()
  {
    return this.b;
  }
  
  public void init(RoomServiceAdapter paramRoomServiceAdapter)
  {
    super.init(paramRoomServiceAdapter);
    this.b = paramRoomServiceAdapter;
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    this.a = paramContext;
  }
  
  public void watchEnterRoom(EnterRoomInfo paramEnterRoomInfo, EnterExitRoomCallback paramEnterExitRoomCallback)
  {
    super.watchEnterRoom(paramEnterRoomInfo, paramEnterExitRoomCallback);
    VasStatisticCollector.b("lite_enter_sso", new Pair[0]);
    ThreadManager.getSubThreadHandler().post(new IliveCustomRoomService.1(this, paramEnterRoomInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveCustomRoomService
 * JD-Core Version:    0.7.0.1
 */