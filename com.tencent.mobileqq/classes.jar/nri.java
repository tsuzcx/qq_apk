import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nri
  implements View.OnClickListener
{
  public nri(EqqAccountDetailActivity paramEqqAccountDetailActivity, boolean paramBoolean1, String paramString, boolean paramBoolean2, oag paramoag) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, this.b);
    EqqAccountDetailActivity.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity, this.jdField_a_of_type_Oag.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nri
 * JD-Core Version:    0.7.0.1
 */