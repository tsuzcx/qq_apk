import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nzs
  implements View.OnClickListener
{
  public nzs(EqqAccountDetailActivity paramEqqAccountDetailActivity, boolean paramBoolean1, String paramString, boolean paramBoolean2, oji paramoji) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, this.b);
    EqqAccountDetailActivity.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity, this.jdField_a_of_type_Oji.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzs
 * JD-Core Version:    0.7.0.1
 */