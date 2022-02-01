import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.avgame.ui.AVGameRoomListFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nfg
  implements View.OnClickListener
{
  public nfg(AVGameRoomListFragment paramAVGameRoomListFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (this.a.a != null)
    {
      localObject = this.a.a;
      bcst.b(null, "dc00898", "", "", "0X800B01D", "0X800B01D", 0, 0, "", "", (String)localObject, "");
      if (!nga.a(this.a.getActivity(), this.a.a)) {
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
      localObject = (mwd)this.a.getActivity().app.getManager(373);
      if (localObject != null) {
        ((mwd)localObject).a(this.a.getActivity(), 6, this.a.a, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nfg
 * JD-Core Version:    0.7.0.1
 */