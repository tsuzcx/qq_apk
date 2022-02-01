package cooperation.qlink;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.utils.QQCustomDialog;

class QQProxyForQlink$11
  extends BroadcastReceiver
{
  QQProxyForQlink$11(QQProxyForQlink paramQQProxyForQlink) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.qlink.finishworkingdlg".equalsIgnoreCase(paramIntent.getAction())) && (QQProxyForQlink.a(this.a) != null))
    {
      QQProxyForQlink.a(this.a).dismiss();
      QQProxyForQlink.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qlink.QQProxyForQlink.11
 * JD-Core Version:    0.7.0.1
 */