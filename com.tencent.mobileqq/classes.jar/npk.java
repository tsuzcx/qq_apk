import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.avgame.ui.AVGameRoomListFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class npk
  implements View.OnClickListener
{
  public npk(AVGameRoomListFragment paramAVGameRoomListFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (this.a.a != null)
    {
      localObject = this.a.a;
      bdla.b(null, "dc00898", "", "", "0X800B01D", "0X800B01D", 0, 0, "", "", (String)localObject, "");
      if (!nqi.a(this.a.getActivity(), this.a.a)) {
        break label75;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = "";
      break;
      label75:
      localObject = (ncz)this.a.getActivity().app.getManager(QQManagerFactory.AV_GAME_MANAGER);
      if (localObject != null) {
        ((ncz)localObject).a(this.a.getActivity(), 6, this.a.a, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     npk
 * JD-Core Version:    0.7.0.1
 */