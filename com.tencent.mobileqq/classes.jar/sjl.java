import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class sjl
  implements Runnable
{
  public sjl(ChatSettingForTroop paramChatSettingForTroop, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a != null) {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.show();
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop, 230);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.setMessage(this.jdField_a_of_type_JavaLangString);
      sjm localsjm = new sjm(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.setPositiveButton(2131432428, localsjm);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.setNegativeButton(2131433029, localsjm);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.isShowing());
    this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sjl
 * JD-Core Version:    0.7.0.1
 */