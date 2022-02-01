import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyScrollViewSwitcher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class szi
  implements View.OnClickListener
{
  public szi(ReadInJoyScrollViewSwitcher paramReadInJoyScrollViewSwitcher, szl paramszl) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyScrollViewSwitcher.a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyScrollViewSwitcher.a.a(this.jdField_a_of_type_Szl);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     szi
 * JD-Core Version:    0.7.0.1
 */