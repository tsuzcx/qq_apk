import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyScrollViewSwitcher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class tdi
  implements View.OnClickListener
{
  public tdi(ReadInJoyScrollViewSwitcher paramReadInJoyScrollViewSwitcher, tdl paramtdl) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyScrollViewSwitcher.a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyScrollViewSwitcher.a.a(this.jdField_a_of_type_Tdl);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tdi
 * JD-Core Version:    0.7.0.1
 */