import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class npa
  implements View.OnClickListener
{
  public npa(AVGameRoomCenterFragment paramAVGameRoomCenterFragment) {}
  
  public void onClick(View paramView)
  {
    AVGameRoomCenterFragment.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     npa
 * JD-Core Version:    0.7.0.1
 */