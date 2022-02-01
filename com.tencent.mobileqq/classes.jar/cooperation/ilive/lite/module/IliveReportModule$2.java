package cooperation.ilive.lite.module;

import com.tencent.ilivesdk.roomservice.RoomDataServer;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.ServiceAccessorMgr;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.service.IliveCustomRoomService;
import kotlin.Pair;

class IliveReportModule$2
  implements Runnable
{
  IliveReportModule$2(IliveReportModule paramIliveReportModule, long paramLong) {}
  
  public void run()
  {
    try
    {
      Object localObject = (RoomServiceInterface)ServiceAccessorMgr.getInstance().getRoomAccessor().getService(RoomServiceInterface.class);
      if ((localObject != null) && ((localObject instanceof IliveCustomRoomService)))
      {
        QLog.e("IliveReportModule", 1, "handle requestExitRoom");
        localObject = (IliveCustomRoomService)localObject;
        VasStatisticCollector.b("lite_exit_sso", new Pair[0]);
        LiveRoomInfo localLiveRoomInfo = new LiveRoomInfo();
        localLiveRoomInfo.roomId = this.a;
        RoomDataServer.requestExitRoom(((IliveCustomRoomService)localObject).a(), localLiveRoomInfo);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.e("IliveReportModule", 1, "requestExitRoom exception", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveReportModule.2
 * JD-Core Version:    0.7.0.1
 */