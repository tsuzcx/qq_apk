import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class sbv
  implements Runnable
{
  public sbv(ChatSettingForTroop paramChatSettingForTroop, String paramString) {}
  
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
      sbw localsbw = new sbw(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.setPositiveButton(2131432400, localsbw);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.setNegativeButton(2131432998, localsbw);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.isShowing());
    this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sbv
 * JD-Core Version:    0.7.0.1
 */