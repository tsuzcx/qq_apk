package cooperation.qlink;

import bkmt;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class QQProxyForQlink$9
  extends TimerTask
{
  public QQProxyForQlink$9(bkmt parambkmt) {}
  
  public void run()
  {
    bkmt.a(this.this$0);
    if (bkmt.b(this.this$0) > 1)
    {
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ qlink pulgin is dead:");
      bkmt.a(this.this$0, new QlAndQQInterface.WorkState(false, 1, null, null, 0, 0, false));
      bkmt.c(this.this$0);
      return;
    }
    this.this$0.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qlink.QQProxyForQlink.9
 * JD-Core Version:    0.7.0.1
 */