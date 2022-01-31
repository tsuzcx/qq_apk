import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class set
  implements Runnable
{
  public set(ChatSettingForTroop paramChatSettingForTroop, String paramString) {}
  
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
      seu localseu = new seu(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.setPositiveButton(2131432417, localseu);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.setNegativeButton(2131433015, localseu);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.isShowing());
    this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     set
 * JD-Core Version:    0.7.0.1
 */