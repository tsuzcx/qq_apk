import android.os.Handler;
import android.os.Message;

class qiz
  extends Handler
{
  qiz(qiy paramqiy) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 100: 
    case 101: 
    case 102: 
      do
      {
        return;
        qiy.a(this.a);
        return;
        this.a.i();
        return;
        qiy.b(this.a);
        sendEmptyMessageDelayed(102, 1000L);
      } while (qiy.a(this.a) != 1);
      qiy.c(this.a);
      return;
    case 103: 
      qiy.a(this.a, 3);
      return;
    case 104: 
      qiy.d(this.a);
      return;
    }
    qiy.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qiz
 * JD-Core Version:    0.7.0.1
 */