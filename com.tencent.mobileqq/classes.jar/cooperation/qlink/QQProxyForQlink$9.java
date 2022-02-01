package cooperation.qlink;

import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

class QQProxyForQlink$9
  extends TimerTask
{
  QQProxyForQlink$9(QQProxyForQlink paramQQProxyForQlink) {}
  
  public void run()
  {
    QQProxyForQlink.d(this.this$0);
    if (QQProxyForQlink.e(this.this$0) > 1)
    {
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ qlink pulgin is dead:");
      QQProxyForQlink.a(this.this$0, new QlAndQQInterface.WorkState(false, 1, null, null, 0, 0, false));
      QQProxyForQlink.f(this.this$0);
      return;
    }
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qlink.QQProxyForQlink.9
 * JD-Core Version:    0.7.0.1
 */