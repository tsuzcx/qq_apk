package cooperation.ilive.lite.service;

import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.qphone.base.util.QLog;

class IliveCustomRoomService$3
  implements ExitRoomCallback
{
  IliveCustomRoomService$3(IliveCustomRoomService paramIliveCustomRoomService) {}
  
  public void onComplete(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exitRoom onComplete code:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errorMsg:");
    localStringBuilder.append(paramString);
    QLog.e("IliveReportModule", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveCustomRoomService.3
 * JD-Core Version:    0.7.0.1
 */