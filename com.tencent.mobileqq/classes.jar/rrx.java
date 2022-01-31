import android.view.View;
import com.tencent.mobileqq.activity.AssociatedAccountManageActivity;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class rrx
  implements ActionSheet.OnButtonClickListener
{
  SimpleAccount jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount;
  
  public rrx(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.b != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.b.dismiss();
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount, false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount, true);
  }
  
  public void a(SimpleAccount paramSimpleAccount)
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = paramSimpleAccount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rrx
 * JD-Core Version:    0.7.0.1
 */