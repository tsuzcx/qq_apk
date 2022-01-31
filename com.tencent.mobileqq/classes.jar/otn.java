import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment;
import com.tencent.common.app.AppInterface;
import java.util.HashMap;

public class otn
  implements View.OnClickListener
{
  public otn(ReadInJoyAdIMAXBrowserFragment paramReadInJoyAdIMAXBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.f();
    if (ReadInJoyAdIMAXBrowserFragment.a(this.a)) {
      return;
    }
    ReadInJoyAdIMAXBrowserFragment.a(this.a, true);
    paramView = new HashMap();
    paramView.put("stat_src", "5");
    nmc.a(new nyd().a((AppInterface)ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(this.a.getActivity()).a(nmc.t).b(nmc.ae).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).d(nmc.a(paramView)).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     otn
 * JD-Core Version:    0.7.0.1
 */