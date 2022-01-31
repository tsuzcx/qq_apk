import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.AssociatedAccountManageActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class rnb
  implements Runnable
{
  rnb(rna paramrna) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountManage", 2, "deleteAccount begin to remove account view");
    }
    try
    {
      View localView = AssociatedAccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity, this.a.jdField_a_of_type_JavaLangString, 1);
      if (localView != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(localView);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel())
        {
          QLog.d("AssociatedAccountManage", 2, "deleteAccount runOnUiThread removeView error");
          continue;
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.jdField_a_of_type_AndroidViewView.setVisibility(4);
        }
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.b();
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.jdField_a_of_type_AndroidViewView.setVisibility(8);
      AssociatedAccountManageActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity);
      if (((this.a.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.b == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.b.size() == 0)) && ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.jdField_a_of_type_JavaUtilList.size() == 0))) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.onBackEvent();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rnb
 * JD-Core Version:    0.7.0.1
 */