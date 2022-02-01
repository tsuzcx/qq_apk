package cooperation.ilive.lite.rommswitch;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedListRsp;
import android.os.Bundle;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.IRoomList;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mqq.os.MqqHandler;

class LiveLiteRoomSwitchService$1
  implements EIPCResultCallback
{
  LiveLiteRoomSwitchService$1(LiveLiteRoomSwitchService paramLiveLiteRoomSwitchService, RoomSwitchInterface.IRoomList paramIRoomList, List paramList, int paramInt) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null))
    {
      QLog.d("LiveLiteRoomSwitchService", 1, "on getfeed list " + paramEIPCResult.isSuccess());
      localObject = paramEIPCResult.data.getByteArray("rspBytes");
      if ((!paramEIPCResult.isSuccess()) || (localObject == null)) {
        ThreadManager.getUIHandler().post(new LiveLiteRoomSwitchService.1.1(this));
      }
    }
    else
    {
      return;
    }
    paramEIPCResult = new CertifiedAccountRead.StGetFeedListRsp();
    try
    {
      paramEIPCResult.mergeFrom((byte[])localObject);
      if (paramEIPCResult.hotLive.get() == null)
      {
        ThreadManager.getUIHandler().post(new LiveLiteRoomSwitchService.1.2(this));
        return;
      }
    }
    catch (Exception paramEIPCResult)
    {
      QLog.d("LiveLiteRoomSwitchService", 1, "request Exception" + paramEIPCResult);
      return;
    }
    Object localObject = LiveLiteRoomSwitchService.a((ArrayList)paramEIPCResult.hotLive.get(), this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int);
    LiveLiteRoomSwitchService.a().clear();
    LiveLiteRoomSwitchService.a().addAll((Collection)localObject);
    QLog.d("LiveLiteRoomSwitchService", 1, "on getfeed list newlist " + ((ArrayList)localObject).size() + " old size " + this.jdField_a_of_type_JavaUtilList.size());
    ThreadManager.getUIHandler().post(new LiveLiteRoomSwitchService.1.3(this, (ArrayList)localObject));
    LiveLiteRoomSwitchService.a = paramEIPCResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.rommswitch.LiveLiteRoomSwitchService.1
 * JD-Core Version:    0.7.0.1
 */