import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class pxm
  implements View.OnClickListener
{
  public pxm(ReadInJoyAdIMAXBrowserFragment paramReadInJoyAdIMAXBrowserFragment) {}
  
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
      ois.a(new ufy().a((AppInterface)ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(this.a.getActivity()).a(20).b(27).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).d(ois.a(localHashMap)).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxm
 * JD-Core Version:    0.7.0.1
 */