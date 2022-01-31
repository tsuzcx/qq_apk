import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment;
import com.tencent.common.app.AppInterface;
import java.util.HashMap;

public class oyr
  implements View.OnClickListener
{
  public oyr(ReadInJoyAdIMAXBrowserFragment paramReadInJoyAdIMAXBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.f();
    if (ReadInJoyAdIMAXBrowserFragment.a(this.a)) {
      return;
    }
    ReadInJoyAdIMAXBrowserFragment.a(this.a, true);
    paramView = new HashMap();
    paramView.put("stat_src", "5");
    noy.a(new obk().a((AppInterface)ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(this.a.getActivity()).a(noy.t).b(noy.ae).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).d(noy.a(paramView)).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oyr
 * JD-Core Version:    0.7.0.1
 */