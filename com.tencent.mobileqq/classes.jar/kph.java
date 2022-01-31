import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.mobileqq.data.AccountDetail;

public class kph
  implements View.OnClickListener
{
  public kph(AccountDetailBaseAdapter paramAccountDetailBaseAdapter) {}
  
  public void onClick(View paramView)
  {
    ((AccountDetailActivity)this.a.jdField_a_of_type_AndroidAppActivity).B();
    String str = this.a.jdField_a_of_type_JavaLangString;
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1) {}
    for (paramView = "02";; paramView = "01")
    {
      PublicAccountReportUtils.a(null, str, "0X8007CA4", "0X8007CA4", 0, 0, paramView, String.valueOf(AccountDetailBaseAdapter.a(this.a)), "", "", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kph
 * JD-Core Version:    0.7.0.1
 */