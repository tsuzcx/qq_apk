package cooperation.ilive.lite.service;

import com.tencent.ilivesdk.roomservice_interface.EnterRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveWatchMediaInfo;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class IliveCustomRoomService$1$1
  implements EnterRoomCallback
{
  IliveCustomRoomService$1$1(IliveCustomRoomService.1 param1) {}
  
  public void onFail(int paramInt, String paramString)
  {
    QLog.e("IliveReportModule", 1, "requestWatchEnterRoom error , failCode = " + paramInt + " msg = " + paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("code", paramInt + "_msg_" + paramString);
    VasStatisticCollector.a("lite_enter_sso_success", localHashMap);
  }
  
  public void onSuccess(LiveInfo paramLiveInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("requestWatchEnterRoom success info = ");
    if (paramLiveInfo == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.e("IliveReportModule", 1, bool);
      if ((paramLiveInfo != null) && (paramLiveInfo.anchorInfo != null)) {
        QLog.e("IliveReportModule", 1, "enterRoom--success anchoInfo=" + paramLiveInfo.anchorInfo.toString());
      }
      if ((paramLiveInfo != null) && (paramLiveInfo.watchMediaInfo != null)) {
        QLog.e("IliveReportModule", 1, "enterRoom--success mediaInfo=" + paramLiveInfo.watchMediaInfo.toString());
      }
      paramLiveInfo = new HashMap();
      paramLiveInfo.put("code", "1");
      VasStatisticCollector.a("lite_enter_sso_success", paramLiveInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveCustomRoomService.1.1
 * JD-Core Version:    0.7.0.1
 */