import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nsh
  implements View.OnClickListener
{
  public nsh(EqqAccountDetailActivity paramEqqAccountDetailActivity, String paramString, obr paramobr) {}
  
  public void onClick(View paramView)
  {
    EqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity, this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_Obr.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Obr.jdField_a_of_type_JavaLangString.contains(amtj.a(2131703307)))) {
      odq.a(EqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), "P_CliOper", "Pb_account_lifeservice", EqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), "0X8005A29", "0X8005A29", 0, 0, "", "", "", "", false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      EqqAccountDetailActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity, this.jdField_a_of_type_Obr.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nsh
 * JD-Core Version:    0.7.0.1
 */