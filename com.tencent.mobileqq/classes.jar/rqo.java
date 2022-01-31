import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

public class rqo
  implements View.OnClickListener
{
  public rqo(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = QZoneHelper.UserInfo.a();
    paramView.a = this.a.app.getCurrentAccountUin();
    paramView.b = this.a.app.getCurrentNickname();
    QZoneHelper.a(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rqo
 * JD-Core Version:    0.7.0.1
 */