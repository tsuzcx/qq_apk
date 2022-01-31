import android.os.Message;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class tdd
  extends MqqHandler
{
  public tdd(Leba paramLeba) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.a != null) && ("0".equals(this.a.a.getCurrentAccountUin()))) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1134006: 
      this.a.b();
      return;
    case 11340002: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.leba", 2, "handler refresh leba config");
      }
      this.a.l();
      return;
    case 11340005: 
      Leba.c(this.a);
      return;
    case 1134008: 
      this.a.a(paramMessage);
      return;
    }
    this.a.r();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tdd
 * JD-Core Version:    0.7.0.1
 */