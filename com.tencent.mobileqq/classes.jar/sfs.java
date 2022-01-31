import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.TimeZone;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class sfs
  implements Runnable
{
  public sfs(ChatHistoryForC2C paramChatHistoryForC2C, boolean paramBoolean, View paramView) {}
  
  public void run()
  {
    boolean bool1 = false;
    if (VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_JavaLangString = "svip";
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.b = "2";
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app, "vip", "0X8004FAB", "0X8004FAB", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_JavaLangString });
    }
    for (;;)
    {
      try
      {
        SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
        if (1 != localSharedPreferences.getInt("setting_guide_tips_flag" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.getCurrentAccountUin(), -1))
        {
          SharedPreferences.Editor localEditor = localSharedPreferences.edit();
          int j = localSharedPreferences.getInt("setting_guide_tips_show_time" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.getCurrentAccountUin(), 1);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.b.equals("2")) {
            continue;
          }
          i = 1;
          if (i != 0) {
            localEditor.putInt("setting_guide_tips_flag" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.getCurrentAccountUin(), 1);
          }
          i = TimeZone.getTimeZone("GMT+8").getRawOffset();
          i = (int)Math.ceil((System.currentTimeMillis() + i) / 86400000L);
          if (j != i) {
            bool1 = true;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryForC2C", 2, "settingGuideFlag isShow: " + bool1 + ", showDay: " + j + ", nowDay: " + i);
          }
          if (bool1)
          {
            localEditor.putInt("setting_guide_tips_show_time" + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.getCurrentAccountUin(), i).commit();
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(10, this.jdField_a_of_type_AndroidViewView));
          }
        }
        return;
        if (VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_JavaLangString = "vip";
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.b = "1";
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_JavaLangString = "notvip";
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.b = "0";
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.b.equals("1"))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_Int >= 3) {
            i = 1;
          }
        }
        else
        {
          boolean bool2 = this.jdField_a_of_type_Boolean;
          if (bool2)
          {
            i = 1;
            continue;
          }
        }
        int i = 0;
      }
      catch (Exception localException)
      {
        QLog.d("ChatHistoryForC2C", 2, "settingGuideFlag Exception: " + localException.getMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sfs
 * JD-Core Version:    0.7.0.1
 */