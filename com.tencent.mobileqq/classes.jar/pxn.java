import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class pxn
  implements View.OnClickListener
{
  public pxn(ReadInJoyAdIMAXBrowserFragment paramReadInJoyAdIMAXBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (biho)this.a.mComponentsProvider.a(4);
    if ((localObject != null) && (((biho)localObject).a != null) && (((biho)localObject).a.isShowing())) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReadInJoyAdIMAXBrowserFragment.a(this.a);
      localObject = new HashMap();
      ((HashMap)localObject).put("stat_src", "5");
      ois.a(new ufy().a((AppInterface)ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(this.a.getActivity()).a(21).b(27).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).d(ois.a((HashMap)localObject)).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxn
 * JD-Core Version:    0.7.0.1
 */