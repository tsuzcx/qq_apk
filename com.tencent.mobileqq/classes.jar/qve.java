import android.os.Handler;
import android.os.Message;

class qve
  extends Handler
{
  qve(qvd paramqvd) {}
  
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
        qvd.a(this.a);
        return;
        this.a.i();
        return;
        qvd.b(this.a);
        sendEmptyMessageDelayed(102, 1000L);
      } while (qvd.a(this.a) != 1);
      qvd.c(this.a);
      return;
    case 103: 
      qvd.a(this.a, 3);
      return;
    case 104: 
      qvd.d(this.a);
      return;
    }
    qvd.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qve
 * JD-Core Version:    0.7.0.1
 */