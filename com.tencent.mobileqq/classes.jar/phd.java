import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class phd
  implements View.OnClickListener
{
  public phd(ReadInJoyAdIMAXBrowserFragment paramReadInJoyAdIMAXBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (biqq)this.a.mComponentsProvider.a(4);
    if ((localObject != null) && (((biqq)localObject).a != null) && (((biqq)localObject).a.isShowing())) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReadInJoyAdIMAXBrowserFragment.a(this.a);
      localObject = new HashMap();
      ((HashMap)localObject).put("stat_src", "5");
      nzq.a(new tlx().a((AppInterface)ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(this.a.getActivity()).a(nzq.v).b(nzq.ag).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).d(nzq.a((HashMap)localObject)).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phd
 * JD-Core Version:    0.7.0.1
 */