import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nzr
  implements View.OnClickListener
{
  public nzr(EqqAccountDetailActivity paramEqqAccountDetailActivity, oji paramoji, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Oji.g)) || (TextUtils.isEmpty(this.jdField_a_of_type_Oji.f))) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.jdField_a_of_type_JavaLangString, 2, "buildMapItemForEqq no lat or lng");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity, QQMapActivity.class);
      localIntent.putExtra("lat", this.jdField_a_of_type_Oji.g);
      localIntent.putExtra("lon", this.jdField_a_of_type_Oji.f);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localIntent.putExtra("loc", this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.startActivity(localIntent);
      bdla.b(EqqAccountDetailActivity.h(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), "CliOper", "", "", "Biz_card", "Biz_card_map", 0, 0, EqqAccountDetailActivity.h(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity), "", "", "");
      EqqAccountDetailActivity.c(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity, this.jdField_a_of_type_Oji.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzr
 * JD-Core Version:    0.7.0.1
 */