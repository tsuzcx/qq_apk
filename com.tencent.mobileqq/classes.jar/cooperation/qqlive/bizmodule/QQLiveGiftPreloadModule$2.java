package cooperation.qqlive.bizmodule;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;

class QQLiveGiftPreloadModule$2
  implements IliveLiteEventCenter.Observer
{
  QQLiveGiftPreloadModule$2(QQLiveGiftPreloadModule paramQQLiveGiftPreloadModule) {}
  
  public boolean onCall(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e("QQLiveGiftPreloadModule", 1, "IliveLiteEventCenter onCall params is null");
      return false;
    }
    if (paramString.equals("ACTION_WEBVIEW_NEED_SHOW_GIFT_ICON")) {
      QQLiveGiftPreloadModule.a(this.a, paramBundle.getBoolean("isSpecialAnchor", false));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqlive.bizmodule.QQLiveGiftPreloadModule.2
 * JD-Core Version:    0.7.0.1
 */