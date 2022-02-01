package cooperation.qqlive.bizmodule;

import android.os.Bundle;
import com.tencent.timi.game.api.live.BaseGameLiveAudienceView;
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;

class QQLiveGameRoomModule$2
  implements IliveLiteEventCenter.Observer
{
  QQLiveGameRoomModule$2(QQLiveGameRoomModule paramQQLiveGameRoomModule) {}
  
  public boolean onCall(String paramString, Bundle paramBundle)
  {
    return (paramString.equals("ACTION_CLOSE_ROOM")) && (QQLiveGameRoomModule.a(this.a) != null) && (QQLiveGameRoomModule.a(this.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqlive.bizmodule.QQLiveGameRoomModule.2
 * JD-Core Version:    0.7.0.1
 */