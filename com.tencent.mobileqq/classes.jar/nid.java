import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl;
import com.tencent.avgame.gameroom.GameRoomFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nid
  implements View.OnClickListener
{
  public nid(GameRoomFragment paramGameRoomFragment) {}
  
  public void onClick(View paramView)
  {
    bdla.b(null, "dc00898", "", "", "0X800B51B", "0X800B51B", 0, 0, "", "", "", "");
    GameActivityCenterCtrl.a().c(this.a.getActivity());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nid
 * JD-Core Version:    0.7.0.1
 */