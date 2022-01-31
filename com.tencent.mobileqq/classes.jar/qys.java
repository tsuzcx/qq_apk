import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class qys
  extends Handler
{
  private qys(qyp paramqyp) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      qyp.a(this.a);
      qyp.a(this.a).sendEmptyMessageDelayed(0, qyp.a(this.a));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(qyp.a(this.a), 2, "prePlay timeout, try rePlay");
    }
    if ((this.a.e()) && (qyp.a(this.a).a() == qyp.a(this.a)))
    {
      qyp.b(this.a);
      return;
    }
    qyp.a(this.a, false);
    this.a.a(qyp.a(this.a));
    qyp.a(this.a, qyp.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qys
 * JD-Core Version:    0.7.0.1
 */