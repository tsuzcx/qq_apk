import android.os.Handler;
import android.os.Message;

class rkq
  extends Handler
{
  rkq(rkp paramrkp) {}
  
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
        rkp.a(this.a);
        return;
        this.a.k();
        return;
        rkp.b(this.a);
        sendEmptyMessageDelayed(102, 1000L);
      } while (rkp.a(this.a) != 1);
      rkp.c(this.a);
      return;
    case 103: 
      rkp.a(this.a, 3);
      return;
    case 104: 
      rkp.d(this.a);
      return;
    }
    rkp.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rkq
 * JD-Core Version:    0.7.0.1
 */