import android.view.View;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.Iterator;

public class rjm
  implements ActionSheet.OnButtonClickListener
{
  public rjm(AssociatedAccountActivity paramAssociatedAccountActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    paramView = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.app.getManager(60);
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.a.iterator();
    while (localIterator.hasNext()) {
      paramView.c(((SubAccountInfo)localIterator.next()).subuin);
    }
    AssociatedAccountActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.getString(2131434029));
    AssociatedAccountActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rjm
 * JD-Core Version:    0.7.0.1
 */