import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class suf
  implements View.OnClickListener
{
  suf(sue paramsue, sud paramsud) {}
  
  public void onClick(View paramView)
  {
    azqs.b(this.jdField_a_of_type_Sue.jdField_a_of_type_Sud.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005732", "0X8005732", 0, 0, "", "", "", "");
    azqs.b(this.jdField_a_of_type_Sue.jdField_a_of_type_Sud.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800642F", "0X800642F", 0, 0, String.valueOf(this.jdField_a_of_type_Sue.jdField_a_of_type_Suc.jdField_a_of_type_Long), "", "", "");
    if (this.jdField_a_of_type_Sue.jdField_a_of_type_Suc != null)
    {
      paramView = String.valueOf(this.jdField_a_of_type_Sue.jdField_a_of_type_Suc.jdField_a_of_type_Long);
      if (!TextUtils.isEmpty(paramView)) {}
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_Sue.jdField_a_of_type_Suc.jdField_a_of_type_Int == 0)
    {
      if (!bdin.d(this.jdField_a_of_type_Sue.jdField_a_of_type_Sud.jdField_a_of_type_AndroidAppActivity.getApplicationContext()))
      {
        QQToast.a(this.jdField_a_of_type_Sue.jdField_a_of_type_Sud.jdField_a_of_type_AndroidAppActivity, 2131694768, 0).b(((BaseActivity)this.jdField_a_of_type_Sue.jdField_a_of_type_Sud.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
        return;
      }
      this.jdField_a_of_type_Sue.a(2);
      this.jdField_a_of_type_Sue.jdField_a_of_type_Suc.jdField_a_of_type_Int = 2;
      MqqHandler localMqqHandler = this.jdField_a_of_type_Sue.jdField_a_of_type_Sud.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(SubscriptFeedsActivity.class);
      if ((localMqqHandler != null) && (this.jdField_a_of_type_Sue.jdField_a_of_type_Sud.jdField_a_of_type_AndroidAppActivity != null) && ((this.jdField_a_of_type_Sue.jdField_a_of_type_Sud.jdField_a_of_type_AndroidAppActivity instanceof SubscriptFeedsActivity))) {
        localMqqHandler.sendEmptyMessage(1007);
      }
      syb.a(this.jdField_a_of_type_Sue.jdField_a_of_type_Sud.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Sue.jdField_a_of_type_Sud.jdField_a_of_type_AndroidAppActivity, paramView, new suj(this.jdField_a_of_type_Sue.jdField_a_of_type_Sud, this.jdField_a_of_type_Sue));
      return;
    }
    sue.a(this.jdField_a_of_type_Sue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     suf
 * JD-Core Version:    0.7.0.1
 */