import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class rel
  implements ActionSheet.OnButtonClickListener
{
  int jdField_a_of_type_Int = -1;
  
  public rel(AccountManageActivity paramAccountManageActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidAppDialog.show();
      } while (this.jdField_a_of_type_Int < 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(this.jdField_a_of_type_Int, false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidAppDialog.show();
    } while (this.jdField_a_of_type_Int < 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(this.jdField_a_of_type_Int, true);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rel
 * JD-Core Version:    0.7.0.1
 */