import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment;
import com.tencent.common.app.AppInterface;
import java.util.HashMap;

public class oto
  implements View.OnClickListener
{
  public oto(ReadInJoyAdIMAXBrowserFragment paramReadInJoyAdIMAXBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = (bcfh)this.a.a.a(4);
    if ((paramView != null) && (paramView.a != null) && (paramView.a.a())) {
      return;
    }
    ReadInJoyAdIMAXBrowserFragment.a(this.a);
    paramView = new HashMap();
    paramView.put("stat_src", "5");
    nmc.a(new nyd().a((AppInterface)ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(this.a.getActivity()).a(nmc.u).b(nmc.ae).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).d(nmc.a(paramView)).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oto
 * JD-Core Version:    0.7.0.1
 */