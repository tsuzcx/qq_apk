import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.avgame.ui.AVGameRoomListFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nin
  implements View.OnClickListener
{
  public nin(AVGameRoomListFragment paramAVGameRoomListFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (this.a.a != null)
    {
      localObject = this.a.a;
      bcef.b(null, "dc00898", "", "", "0X800B01D", "0X800B01D", 0, 0, "", "", (String)localObject, "");
      if (!njk.a(this.a.getActivity(), this.a.a)) {
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
      localObject = (mxn)this.a.getActivity().app.getManager(373);
      if (localObject != null) {
        ((mxn)localObject).a(this.a.getActivity(), 6, this.a.a, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nin
 * JD-Core Version:    0.7.0.1
 */