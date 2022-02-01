package cooperation.qqlive;

import android.os.Bundle;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.event.IliveLiteEventCenter;

class QQLiveAudienceGiftFragment$2
  implements Runnable
{
  QQLiveAudienceGiftFragment$2(QQLiveAudienceGiftFragment paramQQLiveAudienceGiftFragment, View paramView) {}
  
  public void run()
  {
    int i = this.a.getMeasuredHeight();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPanelShow height:");
      ((StringBuilder)localObject).append(i);
      QLog.e("QQLiveAudienceGiftActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("panelHeight", i);
    IliveLiteEventCenter.a().a("ACTION_ROOM_ON_GIFT_PANEL_SHOW", (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqlive.QQLiveAudienceGiftFragment.2
 * JD-Core Version:    0.7.0.1
 */