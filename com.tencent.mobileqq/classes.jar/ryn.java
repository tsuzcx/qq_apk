import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XEditTextEx;

public class ryn
  implements View.OnClickListener
{
  public ryn(BaseChatPie paramBaseChatPie, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals("0"))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager = ((PasswdRedBagManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124));
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c);
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.M = true;
    paramView.insert(i, this.b);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.M = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(paramView.length());
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ryn
 * JD-Core Version:    0.7.0.1
 */