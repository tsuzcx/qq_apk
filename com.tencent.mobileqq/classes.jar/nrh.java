import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nrh
  implements View.OnClickListener
{
  public nrh(EqqAccountDetailActivity paramEqqAccountDetailActivity, oag paramoag, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Oag.g)) || (TextUtils.isEmpty(this.jdField_a_of_type_Oag.f))) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.jdField_a_of_type_JavaLangString, 2, "buildMapItemForEqq no lat or lng");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity, QQMapActivity.class);
      localIntent.putExtra("lat", this.jdField_a_of_type_Oag.g);
      localIntent.putExtra("lon", this.jdField_a_of_type_Oag.f);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localIntent.putExtra("loc", this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.startActivity(localIntent);
      bdll.b(EqqAccountDetailActivity.h(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), "CliOper", "", "", "Biz_card", "Biz_card_map", 0, 0, EqqAccountDetailActivity.h(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), "", "", "");
      EqqAccountDetailActivity.c(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity, this.jdField_a_of_type_Oag.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nrh
 * JD-Core Version:    0.7.0.1
 */