import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.util.ProfileParams;

public class mwh
  implements DialogInterface.OnClickListener
{
  public mwh(AccountDetailActivity paramAccountDetailActivity, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.i = true;
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.doOnBackPressed();
      apln.a(this.jdField_a_of_type_AndroidAppActivity, true, "shareToQQ", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a.a()).longValue());
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.f();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwh
 * JD-Core Version:    0.7.0.1
 */