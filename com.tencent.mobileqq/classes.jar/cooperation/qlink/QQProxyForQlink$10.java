package cooperation.qlink;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class QQProxyForQlink$10
  extends BroadcastReceiver
{
  QQProxyForQlink$10(QQProxyForQlink paramQQProxyForQlink) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    if ((paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) || (paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) || (paramContext.equals("mqq.intent.action.ACCOUNT_EXPIRED")) || (paramContext.equals("mqq.intent.action.LOGOUT")))
    {
      paramIntent = new StringBuilder();
      paramIntent.append("receive qqAccountbroacast action=");
      paramIntent.append(paramContext);
      QLog.w("QQProxyForQlink", 1, paramIntent.toString());
      QQProxyForQlink.a(this.a, new QlAndQQInterface.WorkState(false, 1, null, null, 0, 0, false));
      QQProxyForQlink.f(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qlink.QQProxyForQlink.10
 * JD-Core Version:    0.7.0.1
 */