import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nzi
  implements View.OnClickListener
{
  public nzi(EqqAccountDetailActivity paramEqqAccountDetailActivity, String paramString, oji paramoji) {}
  
  public void onClick(View paramView)
  {
    EqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity, this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_Oji.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Oji.jdField_a_of_type_JavaLangString.contains(anvx.a(2131703658)))) {
      olh.a(EqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), "P_CliOper", "Pb_account_lifeservice", EqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), "0X8005A29", "0X8005A29", 0, 0, "", "", "", "", false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      EqqAccountDetailActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity, this.jdField_a_of_type_Oji.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzi
 * JD-Core Version:    0.7.0.1
 */