package cooperation.qlink;

import blyb;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class QQProxyForQlink$9
  extends TimerTask
{
  public QQProxyForQlink$9(blyb paramblyb) {}
  
  public void run()
  {
    blyb.a(this.this$0);
    if (blyb.b(this.this$0) > 1)
    {
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ qlink pulgin is dead:");
      blyb.a(this.this$0, new QlAndQQInterface.WorkState(false, 1, null, null, 0, 0, false));
      blyb.c(this.this$0);
      return;
    }
    this.this$0.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qlink.QQProxyForQlink.9
 * JD-Core Version:    0.7.0.1
 */