import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class sgu
  extends MqqHandler
{
  public sgu(ChatSettingActivity paramChatSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 18: 
    case 16711681: 
      do
      {
        do
        {
          return;
          paramMessage = (String)paramMessage.obj;
          ChatSettingActivity.a(this.a, paramMessage);
          return;
        } while (ChatSettingActivity.a(this.a) != 0);
        paramMessage = (String)paramMessage.obj;
      } while ((ChatSettingActivity.b(this.a) == null) || (paramMessage == null) || (!ChatSettingActivity.b(this.a).equals(paramMessage)));
      this.a.finish();
      return;
    case 32: 
      String str;
      StringBuilder localStringBuilder;
      boolean bool;
      if ((ChatSettingActivity.a(this.a) != 1001) && (ChatSettingActivity.a(this.a) != 10002)) {
        if (ChatSettingActivity.a(this.a) == 1006)
        {
          if (TextUtils.isEmpty(ChatSettingActivity.c(this.a))) {
            ChatSettingActivity.b(this.a, false);
          }
        }
        else
        {
          paramMessage = (ShieldMsgManger)this.a.app.getManager(15);
          if ((paramMessage != null) && (!TextUtils.isEmpty(ChatSettingActivity.d(this.a)))) {
            ChatSettingActivity.a(this.a, paramMessage.a(ChatSettingActivity.d(this.a)));
          }
          if (QLog.isColorLevel())
          {
            str = this.a.jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder().append("handleMessage, shieldMsgManger=");
            if (paramMessage != null) {
              break label427;
            }
            bool = true;
            QLog.d(str, 2, bool);
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "handleMessage, REFRESH_STRANGER_SHIELD_BUTTON, mIsShield=" + ChatSettingActivity.a(this.a) + ", mIsFollowed=" + this.a.jdField_a_of_type_Boolean + ", mShieldEnable=" + ChatSettingActivity.b(this.a));
        }
        ChatSettingActivity.b(this.a);
        return;
        paramMessage = ContactUtils.g(this.a.app, ChatSettingActivity.c(this.a));
        if (TextUtils.isEmpty(paramMessage))
        {
          ChatSettingActivity.b(this.a, false);
          break;
        }
        ChatSettingActivity.b(this.a, true);
        ChatSettingActivity.a(this.a, paramMessage);
        break;
        bool = false;
        break label275;
        paramMessage = (FriendsManager)this.a.app.getManager(50);
        if (paramMessage != null)
        {
          paramMessage = paramMessage.c(ChatSettingActivity.d(this.a));
          if (QLog.isColorLevel())
          {
            str = this.a.jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder().append("handleMessage, f=");
            if (paramMessage != null) {
              break label538;
            }
          }
          for (bool = true;; bool = false)
          {
            QLog.d(str, 2, bool);
            if ((paramMessage == null) || (paramMessage.groupid != -1002)) {
              break label543;
            }
            ChatSettingActivity.a(this.a, true);
            break;
          }
          ChatSettingActivity.a(this.a, false);
        }
      }
    case 33: 
      label275:
      label427:
      ChatSettingActivity.c(this.a);
      label538:
      label543:
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sgu
 * JD-Core Version:    0.7.0.1
 */