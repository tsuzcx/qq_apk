import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

public class rum
  implements Runnable
{
  public rum(BaseChatPie paramBaseChatPie, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.E)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.setText(this.b);
      if (!this.b.equals("")) {
        break label90;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aJ();
      if (ChatActivityConstants.N) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setLeftContentDescription(this.c);
      }
      return;
      label90:
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rum
 * JD-Core Version:    0.7.0.1
 */