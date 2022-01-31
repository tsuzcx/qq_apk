import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class qyp
  extends Handler
{
  private qyp(qym paramqym) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      qym.a(this.a);
      qym.a(this.a).sendEmptyMessageDelayed(0, qym.a(this.a));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(qym.a(this.a), 2, "prePlay timeout, try rePlay");
    }
    if ((this.a.e()) && (qym.a(this.a).a() == qym.a(this.a)))
    {
      qym.b(this.a);
      return;
    }
    qym.a(this.a, false);
    this.a.a(qym.a(this.a));
    qym.a(this.a, qym.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qyp
 * JD-Core Version:    0.7.0.1
 */