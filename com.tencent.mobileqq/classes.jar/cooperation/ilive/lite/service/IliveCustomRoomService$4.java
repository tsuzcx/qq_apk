package cooperation.ilive.lite.service;

import android.os.Bundle;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.event.IliveLiteEventCenter;

class IliveCustomRoomService$4
  implements ReceiveGiftMessageListener
{
  IliveCustomRoomService$4(IliveCustomRoomService paramIliveCustomRoomService) {}
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receiveGiftMessageListener onError code:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", msg:");
    localStringBuilder.append(paramString);
    QLog.e("IliveReportModule", 1, localStringBuilder.toString());
  }
  
  public void a(GiftMessage paramGiftMessage)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGiftMessageReceive giftMessage:");
      ((StringBuilder)localObject).append(paramGiftMessage);
      QLog.d("IliveReportModule", 2, ((StringBuilder)localObject).toString());
    }
    if (IliveCustomRoomService.a(this.a, paramGiftMessage.sender))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGiftMessageReceive login user send giftMessage:");
        ((StringBuilder)localObject).append(paramGiftMessage);
        QLog.d("IliveReportModule", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = new Bundle();
    if (IliveCustomRoomService.f(this.a).anchorInfo != null) {
      paramGiftMessage.receiver = IliveCustomRoomService.g(this.a).anchorInfo.uid;
    }
    ((Bundle)localObject).putParcelable("intent_extra_gift_message", paramGiftMessage);
    IliveLiteEventCenter.a().a("ACTION_ROOM_RECEIVE_GIFT", (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveCustomRoomService.4
 * JD-Core Version:    0.7.0.1
 */