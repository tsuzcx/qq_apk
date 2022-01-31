import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DBUtils;

public class sht
  implements Runnable
{
  public sht(ChatSettingForTroop paramChatSettingForTroop, String paramString) {}
  
  public void run()
  {
    DBUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app.getCurrentAccountUin(), "troop_game_feed", this.jdField_a_of_type_JavaLangString, 0);
    DBUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app.getCurrentAccountUin(), "troop_game_last_visit_time", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sht
 * JD-Core Version:    0.7.0.1
 */