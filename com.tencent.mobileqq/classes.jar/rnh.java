import android.view.View;
import com.tencent.mobileqq.activity.AssociatedAccountManageActivity;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class rnh
  implements ActionSheet.OnButtonClickListener
{
  SubAccountInfo jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo;
  
  public rnh(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.a.dismiss();
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.b(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo);
  }
  
  public void a(SubAccountInfo paramSubAccountInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = paramSubAccountInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rnh
 * JD-Core Version:    0.7.0.1
 */