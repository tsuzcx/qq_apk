import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.utils.QQUtils;

public class sbv
  implements Runnable
{
  public sbv(ChatSettingActivity paramChatSettingActivity) {}
  
  public void run()
  {
    QQUtils.a(this.a.app, ChatSettingActivity.b(this.a), ChatSettingActivity.f(this.a), this.a.getTitleBarHeight(), this.a.a, 500, "0", ChatSettingActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sbv
 * JD-Core Version:    0.7.0.1
 */