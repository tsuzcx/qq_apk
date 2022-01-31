import android.os.Message;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import mqq.os.MqqHandler;

public class rzc
  implements Runnable
{
  public rzc(ChatSettingActivity paramChatSettingActivity, StringBuilder paramStringBuilder) {}
  
  public void run()
  {
    Message localMessage = null;
    Object localObject = localMessage;
    if (this.jdField_a_of_type_JavaLangStringBuilder != null)
    {
      localObject = localMessage;
      if (this.jdField_a_of_type_JavaLangStringBuilder.length() > 0) {
        localObject = this.jdField_a_of_type_JavaLangStringBuilder.toString();
      }
    }
    if (ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity, ChatSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity), ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity), this.jdField_a_of_type_JavaLangStringBuilder) > 0)
    {
      localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.a.obtainMessage();
      localMessage.what = 18;
      localMessage.obj = localObject;
      localMessage.sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rzc
 * JD-Core Version:    0.7.0.1
 */