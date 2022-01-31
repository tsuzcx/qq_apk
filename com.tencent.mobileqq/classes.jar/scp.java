import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

class scp
  implements View.OnClickListener
{
  scp(sco paramsco, scn paramscn) {}
  
  public void onClick(View paramView)
  {
    axqw.b(this.jdField_a_of_type_Sco.jdField_a_of_type_Scn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005732", "0X8005732", 0, 0, "", "", "", "");
    axqw.b(this.jdField_a_of_type_Sco.jdField_a_of_type_Scn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800642F", "0X800642F", 0, 0, String.valueOf(this.jdField_a_of_type_Sco.jdField_a_of_type_Scm.jdField_a_of_type_Long), "", "", "");
    if (this.jdField_a_of_type_Sco.jdField_a_of_type_Scm != null)
    {
      paramView = String.valueOf(this.jdField_a_of_type_Sco.jdField_a_of_type_Scm.jdField_a_of_type_Long);
      if (!TextUtils.isEmpty(paramView)) {}
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_Sco.jdField_a_of_type_Scm.jdField_a_of_type_Int == 0)
    {
      if (!bbev.d(this.jdField_a_of_type_Sco.jdField_a_of_type_Scn.jdField_a_of_type_AndroidAppActivity.getApplicationContext()))
      {
        bcpw.a(this.jdField_a_of_type_Sco.jdField_a_of_type_Scn.jdField_a_of_type_AndroidAppActivity, 2131694609, 0).b(((BaseActivity)this.jdField_a_of_type_Sco.jdField_a_of_type_Scn.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
        return;
      }
      this.jdField_a_of_type_Sco.a(2);
      this.jdField_a_of_type_Sco.jdField_a_of_type_Scm.jdField_a_of_type_Int = 2;
      MqqHandler localMqqHandler = this.jdField_a_of_type_Sco.jdField_a_of_type_Scn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(SubscriptFeedsActivity.class);
      if ((localMqqHandler != null) && (this.jdField_a_of_type_Sco.jdField_a_of_type_Scn.jdField_a_of_type_AndroidAppActivity != null) && ((this.jdField_a_of_type_Sco.jdField_a_of_type_Scn.jdField_a_of_type_AndroidAppActivity instanceof SubscriptFeedsActivity))) {
        localMqqHandler.sendEmptyMessage(1007);
      }
      sgj.a(this.jdField_a_of_type_Sco.jdField_a_of_type_Scn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Sco.jdField_a_of_type_Scn.jdField_a_of_type_AndroidAppActivity, paramView, new sct(this.jdField_a_of_type_Sco.jdField_a_of_type_Scn, this.jdField_a_of_type_Sco));
      return;
    }
    sco.a(this.jdField_a_of_type_Sco);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     scp
 * JD-Core Version:    0.7.0.1
 */