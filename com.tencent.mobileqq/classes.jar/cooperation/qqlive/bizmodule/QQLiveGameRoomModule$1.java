package cooperation.qqlive.bizmodule;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ilive.base.page.fragment.LiveTemplateFragment;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.mobileqq.qqlive.data.record.QQLiveSwitchRoom;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.timi.game.api.live.BaseGameLiveAudienceView.LiveViewListener;
import cooperation.qqlive.api.IQQLiveAudienceRoomService;

class QQLiveGameRoomModule$1
  implements BaseGameLiveAudienceView.LiveViewListener
{
  QQLiveGameRoomModule$1(QQLiveGameRoomModule paramQQLiveGameRoomModule, Context paramContext) {}
  
  public void a(QQLiveSwitchRoom paramQQLiveSwitchRoom)
  {
    if (paramQQLiveSwitchRoom != null) {
      ((IQQLiveAudienceRoomService)QRoute.api(IQQLiveAudienceRoomService.class)).enterAudienceRoom(this.a, paramQQLiveSwitchRoom);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QQLiveGameRoomModule.a(this.b, paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.b.getAudienceRoomPager() != null) && (this.b.getAudienceRoomPager().getCurrentFragment() != null) && (this.b.getAudienceRoomPager().getCurrentFragment().getActivity() != null))
    {
      QQLiveGameRoomModule.b(this.b, paramBoolean);
      this.b.getAudienceRoomPager().getCurrentFragment().getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqlive.bizmodule.QQLiveGameRoomModule.1
 * JD-Core Version:    0.7.0.1
 */