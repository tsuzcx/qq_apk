import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

class rpx
  implements View.OnClickListener
{
  rpx(rpw paramrpw, rpv paramrpv) {}
  
  public void onClick(View paramView)
  {
    awqx.b(this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005732", "0X8005732", 0, 0, "", "", "", "");
    awqx.b(this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800642F", "0X800642F", 0, 0, String.valueOf(this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpu.jdField_a_of_type_Long), "", "", "");
    if (this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpu != null)
    {
      paramView = String.valueOf(this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpu.jdField_a_of_type_Long);
      if (!TextUtils.isEmpty(paramView)) {}
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpu.jdField_a_of_type_Int == 0)
    {
      if (!badq.d(this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpv.jdField_a_of_type_AndroidAppActivity.getApplicationContext()))
      {
        bbmy.a(this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpv.jdField_a_of_type_AndroidAppActivity, 2131628948, 0).b(((BaseActivity)this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpv.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
        return;
      }
      this.jdField_a_of_type_Rpw.a(2);
      this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpu.jdField_a_of_type_Int = 2;
      MqqHandler localMqqHandler = this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(SubscriptFeedsActivity.class);
      if ((localMqqHandler != null) && (this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpv.jdField_a_of_type_AndroidAppActivity != null) && ((this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpv.jdField_a_of_type_AndroidAppActivity instanceof SubscriptFeedsActivity))) {
        localMqqHandler.sendEmptyMessage(1007);
      }
      rtr.a(this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpv.jdField_a_of_type_AndroidAppActivity, paramView, new rqb(this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpv, this.jdField_a_of_type_Rpw));
      return;
    }
    rpw.a(this.jdField_a_of_type_Rpw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rpx
 * JD-Core Version:    0.7.0.1
 */