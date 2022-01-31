import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment;
import com.tencent.common.app.AppInterface;
import java.util.HashMap;

public class oig
  implements View.OnClickListener
{
  public oig(ReadInJoyAdIMAXBrowserFragment paramReadInJoyAdIMAXBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = (bbbt)this.a.a.a(4);
    if ((paramView != null) && (paramView.a != null) && (paramView.a.a())) {
      return;
    }
    ReadInJoyAdIMAXBrowserFragment.a(this.a);
    paramView = new HashMap();
    paramView.put("stat_src", "5");
    nbe.a(new nmv().a((AppInterface)ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(this.a.getActivity()).a(nbe.u).b(nbe.ae).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).d(nbe.a(paramView)).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oig
 * JD-Core Version:    0.7.0.1
 */