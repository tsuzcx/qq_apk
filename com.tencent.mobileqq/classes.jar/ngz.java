import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.avgame.ui.AVGameRoomListFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ngz
  implements View.OnClickListener
{
  public ngz(AVGameRoomListFragment paramAVGameRoomListFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngz
 * JD-Core Version:    0.7.0.1
 */