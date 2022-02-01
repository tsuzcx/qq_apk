import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class npb
  implements View.OnClickListener
{
  public npb(AVGameRoomCenterFragment paramAVGameRoomCenterFragment) {}
  
  public void onClick(View paramView)
  {
    AVGameRoomCenterFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     npb
 * JD-Core Version:    0.7.0.1
 */