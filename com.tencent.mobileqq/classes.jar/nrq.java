import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nrq
  implements View.OnClickListener
{
  nrq(nrk paramnrk) {}
  
  public void onClick(View paramView)
  {
    ((AccountDetailActivity)this.a.jdField_a_of_type_AndroidAppActivity).E();
    String str2 = this.a.jdField_a_of_type_JavaLangString;
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1) {}
    for (String str1 = "02";; str1 = "01")
    {
      ocd.a(null, str2, "0X8007CA4", "0X8007CA4", 0, 0, str1, String.valueOf(nrk.a(this.a)), "", "", false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nrq
 * JD-Core Version:    0.7.0.1
 */