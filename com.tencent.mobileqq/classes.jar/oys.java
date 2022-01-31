import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import java.util.HashMap;

public class oys
  implements View.OnClickListener
{
  public oys(ReadInJoyAdIMAXBrowserFragment paramReadInJoyAdIMAXBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = (beir)this.a.a.a(4);
    if ((paramView != null) && (paramView.a != null) && (paramView.a.isShowing())) {
      return;
    }
    ReadInJoyAdIMAXBrowserFragment.a(this.a);
    paramView = new HashMap();
    paramView.put("stat_src", "5");
    noy.a(new obk().a((AppInterface)ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(this.a.getActivity()).a(noy.u).b(noy.ae).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).d(noy.a(paramView)).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oys
 * JD-Core Version:    0.7.0.1
 */