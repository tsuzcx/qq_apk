import android.os.Handler;
import android.os.Message;

class qvb
  extends Handler
{
  qvb(qva paramqva) {}
  
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
        qva.a(this.a);
        return;
        this.a.i();
        return;
        qva.b(this.a);
        sendEmptyMessageDelayed(102, 1000L);
      } while (qva.a(this.a) != 1);
      qva.c(this.a);
      return;
    case 103: 
      qva.a(this.a, 3);
      return;
    case 104: 
      qva.d(this.a);
      return;
    }
    qva.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qvb
 * JD-Core Version:    0.7.0.1
 */