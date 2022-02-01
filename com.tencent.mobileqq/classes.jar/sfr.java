import android.os.Handler;
import android.os.Message;

class sfr
  extends Handler
{
  sfr(sfq paramsfq) {}
  
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
        sfq.a(this.a);
        return;
        this.a.l();
        return;
        sfq.b(this.a);
        sendEmptyMessageDelayed(102, 1000L);
      } while (sfq.a(this.a) != 1);
      sfq.c(this.a);
      return;
    case 103: 
      sfq.a(this.a, 3);
      return;
    case 104: 
      sfq.d(this.a);
      return;
    }
    sfq.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sfr
 * JD-Core Version:    0.7.0.1
 */