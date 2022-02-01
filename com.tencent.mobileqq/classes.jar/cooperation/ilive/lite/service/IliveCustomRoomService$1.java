package cooperation.ilive.lite.service;

import com.tencent.mobileqq.qqlive.api.room.IQQLiveAudienceRoomReportHelper;
import com.tencent.mobileqq.qqlive.report.IQQLiveReportCallback;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;

class IliveCustomRoomService$1
  implements IQQLiveReportCallback
{
  IliveCustomRoomService$1(IliveCustomRoomService paramIliveCustomRoomService) {}
  
  public void a(String paramString, HashMap<String, String> paramHashMap)
  {
    ((IQQLiveAudienceRoomReportHelper)QRoute.api(IQQLiveAudienceRoomReportHelper.class)).doQQLiveReportEvent(paramString, paramHashMap, IliveCustomRoomService.a(this.a), IliveCustomRoomService.b(this.a), IliveCustomRoomService.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveCustomRoomService.1
 * JD-Core Version:    0.7.0.1
 */