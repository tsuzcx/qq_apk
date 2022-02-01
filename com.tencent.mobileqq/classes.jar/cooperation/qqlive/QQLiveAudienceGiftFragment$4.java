package cooperation.qqlive;

import android.app.Activity;
import android.os.Bundle;
import cooperation.ilive.lite.event.IliveLiteEventCenter;

class QQLiveAudienceGiftFragment$4
  implements Runnable
{
  QQLiveAudienceGiftFragment$4(QQLiveAudienceGiftFragment paramQQLiveAudienceGiftFragment, Activity paramActivity) {}
  
  public void run()
  {
    this.a.finish();
    Bundle localBundle = new Bundle();
    IliveLiteEventCenter.a().a("ACTION_ROOM_ON_GIFT_PANEL_HIDE", localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqlive.QQLiveAudienceGiftFragment.4
 * JD-Core Version:    0.7.0.1
 */