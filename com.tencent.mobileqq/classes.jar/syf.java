import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.util.ProfileParams;

final class syf
  implements DialogInterface.OnCancelListener
{
  syf(Activity paramActivity, ProfileParams paramProfileParams) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      arys.a(this.jdField_a_of_type_AndroidAppActivity, true, "shareToQzone", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams.a()).longValue());
      this.jdField_a_of_type_AndroidAppActivity.setResult(0);
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     syf
 * JD-Core Version:    0.7.0.1
 */