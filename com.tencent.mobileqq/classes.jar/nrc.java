import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nrc
  implements View.OnClickListener
{
  public nrc(EqqAccountDetailActivity paramEqqAccountDetailActivity, oag paramoag) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a = this.jdField_a_of_type_Oag.d;
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(this.jdField_a_of_type_Oag, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nrc
 * JD-Core Version:    0.7.0.1
 */