package dov.com.qq.im.ae.view;

import android.app.Activity;
import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class AECameraErrorDialog
{
  private static final String jdField_a_of_type_JavaLangString = AECameraErrorDialog.class.getSimpleName();
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  
  public AECameraErrorDialog(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private void b(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      return;
    }
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131699097);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230).setMessage(str).setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131693935), new AECameraErrorDialog.1(this, paramRunnable));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.hide();
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    try
    {
      b(paramRunnable);
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
    catch (WindowManager.BadTokenException paramRunnable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(jdField_a_of_type_JavaLangString, 2, "", paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.view.AECameraErrorDialog
 * JD-Core Version:    0.7.0.1
 */