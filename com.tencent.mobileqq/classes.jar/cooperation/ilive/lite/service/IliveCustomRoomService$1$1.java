package cooperation.ilive.lite.service;

import android.os.Bundle;
import com.tencent.ilivesdk.roomservice_interface.EnterRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveWatchMediaInfo;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.event.IliveLiteEventCenter;
import java.util.HashMap;
import java.util.Map;

class IliveCustomRoomService$1$1
  implements EnterRoomCallback
{
  IliveCustomRoomService$1$1(IliveCustomRoomService.1 param1) {}
  
  public void onFail(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestWatchEnterRoom error , failCode = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" msg = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("IliveReportModule", 1, ((StringBuilder)localObject).toString());
    localObject = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_msg_");
    localStringBuilder.append(paramString);
    ((HashMap)localObject).put("code", localStringBuilder.toString());
    VasStatisticCollector.a("lite_enter_sso_success", (Map)localObject);
  }
  
  public void onSuccess(LiveInfo paramLiveInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestWatchEnterRoom success info = ");
    boolean bool;
    if (paramLiveInfo == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    QLog.e("IliveReportModule", 1, ((StringBuilder)localObject).toString());
    if ((paramLiveInfo != null) && (paramLiveInfo.anchorInfo != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterRoom--success anchoInfo=");
      ((StringBuilder)localObject).append(paramLiveInfo.anchorInfo.toString());
      QLog.e("IliveReportModule", 1, ((StringBuilder)localObject).toString());
    }
    if ((paramLiveInfo != null) && (paramLiveInfo.watchMediaInfo != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterRoom--success mediaInfo=");
      ((StringBuilder)localObject).append(paramLiveInfo.watchMediaInfo.toString());
      QLog.e("IliveReportModule", 1, ((StringBuilder)localObject).toString());
      localObject = new Bundle();
      ((Bundle)localObject).putInt("media_status", IliveCustomRoomService.a(this.a.this$0, paramLiveInfo.watchMediaInfo.mVideoStatus));
      IliveLiteEventCenter.a().a("ACTION_SSO_ENTER_ROOM", (Bundle)localObject);
    }
    paramLiveInfo = new HashMap();
    paramLiveInfo.put("code", "1");
    VasStatisticCollector.a("lite_enter_sso_success", paramLiveInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveCustomRoomService.1.1
 * JD-Core Version:    0.7.0.1
 */