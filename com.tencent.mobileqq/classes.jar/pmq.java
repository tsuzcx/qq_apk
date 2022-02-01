import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class pmq
  implements View.OnClickListener
{
  public pmq(ReadInJoyAdIMAXBrowserFragment paramReadInJoyAdIMAXBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (bgww)this.a.mComponentsProvider.a(4);
    if ((localObject != null) && (((bgww)localObject).a != null) && (((bgww)localObject).a.isShowing())) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReadInJoyAdIMAXBrowserFragment.a(this.a);
      localObject = new HashMap();
      ((HashMap)localObject).put("stat_src", "5");
      obb.a(new trn().a((AppInterface)ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(this.a.getActivity()).a(obb.v).b(obb.ag).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).d(obb.a((HashMap)localObject)).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pmq
 * JD-Core Version:    0.7.0.1
 */