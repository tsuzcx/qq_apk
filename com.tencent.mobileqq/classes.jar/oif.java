import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment;
import com.tencent.common.app.AppInterface;
import java.util.HashMap;

public class oif
  implements View.OnClickListener
{
  public oif(ReadInJoyAdIMAXBrowserFragment paramReadInJoyAdIMAXBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.f();
    if (ReadInJoyAdIMAXBrowserFragment.a(this.a)) {
      return;
    }
    ReadInJoyAdIMAXBrowserFragment.a(this.a, true);
    paramView = new HashMap();
    paramView.put("stat_src", "5");
    nbe.a(new nmv().a((AppInterface)ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(this.a.getActivity()).a(nbe.t).b(nbe.ae).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).d(nbe.a(paramView)).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oif
 * JD-Core Version:    0.7.0.1
 */