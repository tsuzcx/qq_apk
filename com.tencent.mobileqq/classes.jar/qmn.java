import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class qmn
  extends Handler
{
  private qmn(qmk paramqmk) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      qmk.a(this.a);
      qmk.a(this.a).sendEmptyMessageDelayed(0, qmk.a(this.a));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(qmk.a(this.a), 2, "prePlay timeout, try rePlay");
    }
    if ((this.a.e()) && (qmk.a(this.a).a() == qmk.a(this.a)))
    {
      qmk.b(this.a);
      return;
    }
    qmk.a(this.a, false);
    this.a.a(qmk.a(this.a));
    qmk.a(this.a, qmk.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qmn
 * JD-Core Version:    0.7.0.1
 */