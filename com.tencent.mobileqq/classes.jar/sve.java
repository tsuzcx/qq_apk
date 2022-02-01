import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;

public class sve
  implements View.OnClickListener
{
  public sve(ReadinjoyTabbar paramReadinjoyTabbar) {}
  
  public void onClick(View paramView)
  {
    if ((ReadinjoyTabbar.a(this.a) != null) && (ReadinjoyTabbar.a(this.a).b())) {}
    try
    {
      ReadinjoyTabbar.a(this.a).a(3, 257, null, true);
      ReadinjoyTabbar.a(this.a).b();
      label49:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label49;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sve
 * JD-Core Version:    0.7.0.1
 */