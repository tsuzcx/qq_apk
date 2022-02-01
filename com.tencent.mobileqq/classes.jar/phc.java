import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class phc
  implements View.OnClickListener
{
  public phc(ReadInJoyAdIMAXBrowserFragment paramReadInJoyAdIMAXBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.doOnBackEvent();
    if (ReadInJoyAdIMAXBrowserFragment.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReadInJoyAdIMAXBrowserFragment.a(this.a, true);
      HashMap localHashMap = new HashMap();
      localHashMap.put("stat_src", "5");
      nzq.a(new tlx().a((AppInterface)ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(this.a.getActivity()).a(nzq.u).b(nzq.ag).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).d(nzq.a(localHashMap)).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phc
 * JD-Core Version:    0.7.0.1
 */