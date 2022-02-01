package cooperation.ilive.lite.rommswitch;

import android.os.Bundle;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.IRoomList;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ilive.pb.LiveRoomList.GetFeedsListRsp;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
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
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("on getfeed list ");
      ((StringBuilder)localObject1).append(paramEIPCResult.isSuccess());
      QLog.d("LiveLiteRoomSwitchService", 1, ((StringBuilder)localObject1).toString());
      Object localObject2 = paramEIPCResult.data.getByteArray("rspBytes");
      if ((paramEIPCResult.isSuccess()) && (localObject2 != null))
      {
        localObject1 = new LiveRoomList.GetFeedsListRsp();
        try
        {
          ((LiveRoomList.GetFeedsListRsp)localObject1).mergeFrom((byte[])localObject2);
          if (((LiveRoomList.GetFeedsListRsp)localObject1).feeds.get() == null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("onCallback return feeds = null ");
            ((StringBuilder)localObject1).append(paramEIPCResult.isSuccess());
            QLog.e("LiveLiteRoomSwitchService", 1, ((StringBuilder)localObject1).toString());
            ThreadManager.getUIHandler().post(new LiveLiteRoomSwitchService.1.2(this));
            return;
          }
          paramEIPCResult = (ArrayList)((LiveRoomList.GetFeedsListRsp)localObject1).feeds.get();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onCallback return feeds size = ");
          ((StringBuilder)localObject2).append(paramEIPCResult.size());
          QLog.e("LiveLiteRoomSwitchService", 1, ((StringBuilder)localObject2).toString());
          paramEIPCResult = LiveLiteRoomSwitchService.a(paramEIPCResult, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int);
          LiveLiteRoomSwitchService.a().clear();
          LiveLiteRoomSwitchService.a().addAll(paramEIPCResult);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("on getfeed list newlist ");
          ((StringBuilder)localObject2).append(paramEIPCResult.size());
          ((StringBuilder)localObject2).append(" old size ");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilList.size());
          QLog.d("LiveLiteRoomSwitchService", 1, ((StringBuilder)localObject2).toString());
          ThreadManager.getUIHandler().post(new LiveLiteRoomSwitchService.1.3(this, paramEIPCResult));
          LiveLiteRoomSwitchService.a = (LiveRoomList.GetFeedsListRsp)localObject1;
          return;
        }
        catch (Exception paramEIPCResult)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("request Exception");
          ((StringBuilder)localObject1).append(paramEIPCResult);
          QLog.d("LiveLiteRoomSwitchService", 1, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onCallback bytes = null ");
      ((StringBuilder)localObject1).append(paramEIPCResult.isSuccess());
      QLog.e("LiveLiteRoomSwitchService", 1, ((StringBuilder)localObject1).toString());
      ThreadManager.getUIHandler().post(new LiveLiteRoomSwitchService.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.rommswitch.LiveLiteRoomSwitchService.1
 * JD-Core Version:    0.7.0.1
 */