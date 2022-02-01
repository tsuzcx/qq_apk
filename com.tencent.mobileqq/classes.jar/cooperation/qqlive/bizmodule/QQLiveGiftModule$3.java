package cooperation.qqlive.bizmodule;

import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;

class QQLiveGiftModule$3
  implements IliveLiteEventCenter.Observer
{
  QQLiveGiftModule$3(QQLiveGiftModule paramQQLiveGiftModule) {}
  
  public boolean onCall(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e("QQLiveGiftModule", 1, "IliveLiteEventCenter onCall params is null");
      return false;
    }
    if (paramString.equals("ACTION_ROOM_RECEIVE_GIFT"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLiveGiftModule", 2, "receive gift event");
      }
      try
      {
        paramString = (GiftMessage)paramBundle.getParcelable("intent_extra_gift_message");
        if (paramString != null)
        {
          QQLiveGiftModule.a(this.a, paramString);
          return true;
        }
        QLog.e("QQLiveGiftModule", 1, "onCall receive gift event giftMessage is null");
        return true;
      }
      catch (Exception paramString)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onCall receive gift event throw error:");
        paramBundle.append(paramString.getMessage());
        QLog.e("QQLiveGiftModule", 1, paramBundle.toString());
        return true;
      }
    }
    if (paramString.equals("ACTION_ROOM_ON_GIFT_PANEL_SHOW"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLiveGiftModule", 2, "receive on gift panel show");
      }
      QQLiveGiftModule.a(this.a);
      float f1 = (float)DeviceInfoUtil.E();
      int i = paramBundle.getInt("panelHeight", -1);
      int j = QQLiveGiftModule.e(this.a).getMeasuredHeight();
      int k = QQLiveGiftModule.a(10.0F);
      float f2 = f1 / 2.0F;
      f1 = j;
      f2 = f2 - f1 / 2.0F - k;
      float f3 = i;
      f1 = (f3 - f2) / f1;
      if (f3 > f2)
      {
        QQLiveGiftModule.a(this.a, f1);
        return false;
      }
    }
    else if (paramString.equals("ACTION_ROOM_ON_GIFT_PANEL_HIDE"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLiveGiftModule", 2, "receive on gift panel hide");
      }
      QQLiveGiftModule.c(this.a);
      QQLiveGiftModule.f(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqlive.bizmodule.QQLiveGiftModule.3
 * JD-Core Version:    0.7.0.1
 */