import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;

public class rwy
  implements View.OnClickListener
{
  public rwy(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    if (RIJRedPacketManager.a().b()) {
      RIJRedPacketManager.a().a(this.a.a(), 1, 1, 0);
    }
    for (;;)
    {
      ReadinjoyTabFrame.a(this.a).b(1, false, null);
      return;
      ReadinjoyTabFrame.a(this.a).a(1, 1, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rwy
 * JD-Core Version:    0.7.0.1
 */