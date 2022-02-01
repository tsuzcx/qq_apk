package cooperation.qqlive.bizmodule;

import android.support.annotation.Nullable;
import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.ilive.litepages.room.webmodule.event.SendChatInputEvent;

class QQLiveGiftModule$2
  implements Observer<SendChatInputEvent>
{
  QQLiveGiftModule$2(QQLiveGiftModule paramQQLiveGiftModule) {}
  
  public void a(@Nullable SendChatInputEvent paramSendChatInputEvent)
  {
    if ((paramSendChatInputEvent != null) && (paramSendChatInputEvent.mType == 2))
    {
      paramSendChatInputEvent = this.a.getRootView();
      if (paramSendChatInputEvent != null) {
        paramSendChatInputEvent.postDelayed(new QQLiveGiftModule.2.1(this), 300L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqlive.bizmodule.QQLiveGiftModule.2
 * JD-Core Version:    0.7.0.1
 */