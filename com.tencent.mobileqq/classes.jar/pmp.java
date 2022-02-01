import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class pmp
  implements View.OnClickListener
{
  public pmp(ReadInJoyAdIMAXBrowserFragment paramReadInJoyAdIMAXBrowserFragment) {}
  
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
      obb.a(new trn().a((AppInterface)ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(this.a.getActivity()).a(obb.u).b(obb.ag).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).d(obb.a(localHashMap)).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pmp
 * JD-Core Version:    0.7.0.1
 */