import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class skg
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  
  public skg(BaseTabbar paramBaseTabbar, int paramInt) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 300L)
    {
      this.jdField_a_of_type_Long = 0L;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar.a != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar.a.a(this.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar.setSelectedTab(this.jdField_a_of_type_Int, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     skg
 * JD-Core Version:    0.7.0.1
 */