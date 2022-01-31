import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class rma
  implements ActionSheet.OnButtonClickListener
{
  int jdField_a_of_type_Int = -1;
  
  public rma(AccountManageActivity paramAccountManageActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.isFinishing()) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      switch (paramInt)
      {
      default: 
      case 0: 
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidAppDialog.show();
          if (this.jdField_a_of_type_Int < 0) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(this.jdField_a_of_type_Int, false);
          return;
        }
        catch (Throwable paramView)
        {
          for (;;)
          {
            paramView.printStackTrace();
            QLog.i("AccountManageActivity", 1, "MyOnButtonClickListener 0 error" + paramView.getMessage());
          }
        }
      case 1: 
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidAppDialog.show();
          if (this.jdField_a_of_type_Int < 0) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(this.jdField_a_of_type_Int, true);
          return;
        }
        catch (Throwable paramView)
        {
          for (;;)
          {
            paramView.printStackTrace();
            QLog.i("AccountManageActivity", 1, "MyOnButtonClickListener 1 error" + paramView.getMessage());
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rma
 * JD-Core Version:    0.7.0.1
 */