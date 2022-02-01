package cooperation.ilive.lite.service;

import android.os.Bundle;
import com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback;
import com.tencent.mobileqq.qqlive.data.room.LiveWatchMediaInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.event.IliveLiteEventCenter;

class IliveCustomRoomService$2$1
  implements EnterAudienceRoomCallback
{
  IliveCustomRoomService$2$1(IliveCustomRoomService.2 param2) {}
  
  public void onFailed(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[enterRoom-onFailed] code:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", msg:");
    localStringBuilder.append(paramString);
    QLog.e("IliveReportModule", 1, localStringBuilder.toString());
  }
  
  public void onSuccess(com.tencent.mobileqq.qqlive.data.room.LiveInfo paramLiveInfo)
  {
    if (paramLiveInfo != null)
    {
      Object localObject = IliveCustomRoomService.a(this.a.this$0, paramLiveInfo.anchorInfo);
      if (localObject != null)
      {
        IliveCustomRoomService.d(this.a.this$0).anchorInfo = ((com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo)localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("watchEnterRoom onSuccess anchor:");
          ((StringBuilder)localObject).append(IliveCustomRoomService.e(this.a.this$0).anchorInfo);
          QLog.d("IliveReportModule", 2, ((StringBuilder)localObject).toString());
        }
      }
      if (paramLiveInfo.watchMediaInfo != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("enterRoom--success mediaInfo=");
        ((StringBuilder)localObject).append(paramLiveInfo.watchMediaInfo.toString());
        QLog.e("IliveReportModule", 1, ((StringBuilder)localObject).toString());
        localObject = new Bundle();
        ((Bundle)localObject).putInt("media_status", IliveCustomRoomService.a(this.a.this$0, paramLiveInfo.watchMediaInfo.mVideoStatus));
        if (paramLiveInfo.anchorInfo != null) {
          paramLiveInfo = paramLiveInfo.anchorInfo.nickName;
        } else {
          paramLiveInfo = "";
        }
        ((Bundle)localObject).putString("anchor_nick_name", paramLiveInfo);
        IliveLiteEventCenter.a().a("ACTION_SSO_ENTER_ROOM", (Bundle)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveCustomRoomService.2.1
 * JD-Core Version:    0.7.0.1
 */