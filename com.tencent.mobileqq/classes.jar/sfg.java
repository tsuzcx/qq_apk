import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings.System;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import mqq.os.MqqHandler;

public class sfg
  extends BroadcastReceiver
{
  public sfg(Conversation paramConversation) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("android.intent.action.TIME_SET".equals(paramContext)) || ("android.intent.action.TIMEZONE_CHANGED".equals(paramContext)) || ("android.intent.action.DATE_CHANGED".equals(paramContext)))
    {
      paramContext = Settings.System.getString(this.a.a().getContentResolver(), "date_format");
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (TimeManager.a().a(paramContext)) && (this.a.h)) {
        this.a.a(1014, 0L, false);
      }
      SubAccountControll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext);
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        paramContext = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(TroopAssistantActivity.class);
        if (paramContext != null) {
          paramContext.sendEmptyMessage(2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sfg
 * JD-Core Version:    0.7.0.1
 */