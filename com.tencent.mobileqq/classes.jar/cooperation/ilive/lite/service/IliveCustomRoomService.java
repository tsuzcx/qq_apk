package cooperation.ilive.lite.service;

import android.content.Context;
import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveVideoStatus;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room.DefaultCustomRoomService;
import mqq.os.MqqHandler;

public class IliveCustomRoomService
  extends DefaultCustomRoomService
{
  private Context a;
  private RoomServiceAdapter b;
  
  private int a(LiveVideoStatus paramLiveVideoStatus)
  {
    if (paramLiveVideoStatus == null) {
      return 0;
    }
    if (paramLiveVideoStatus == LiveVideoStatus.Start) {
      return 1;
    }
    return 0;
  }
  
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
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void watchEnterRoom(EnterRoomInfo paramEnterRoomInfo, EnterExitRoomCallback paramEnterExitRoomCallback)
  {
    super.watchEnterRoom(paramEnterRoomInfo, paramEnterExitRoomCallback);
    ThreadManager.getSubThreadHandler().post(new IliveCustomRoomService.1(this, paramEnterRoomInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveCustomRoomService
 * JD-Core Version:    0.7.0.1
 */