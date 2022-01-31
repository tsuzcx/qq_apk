import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.qphone.base.util.QLog;

public class sul
  extends Handler
{
  public sul(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "mWaitingDialogControlHandler operationFinished = " + GroupManagerActivity.b(this.a));
    }
    GroupManagerActivity.b(this.a, true);
    if (GroupManagerActivity.b(this.a))
    {
      this.a.a(true);
      return;
    }
    paramMessage = GroupManagerActivity.a(this.a).obtainMessage(0);
    GroupManagerActivity.a(this.a).sendMessageDelayed(paramMessage, 60000L);
    GroupManagerActivity.c(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sul
 * JD-Core Version:    0.7.0.1
 */