import android.os.Handler;
import android.os.Message;

class sqe
  extends Handler
{
  sqe(sqd paramsqd) {}
  
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
        sqd.a(this.a);
        return;
        this.a.l();
        return;
        sqd.b(this.a);
        sendEmptyMessageDelayed(102, 1000L);
      } while (sqd.a(this.a) != 1);
      sqd.c(this.a);
      return;
    case 103: 
      sqd.a(this.a, 3);
      return;
    case 104: 
      sqd.d(this.a);
      return;
    }
    sqd.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sqe
 * JD-Core Version:    0.7.0.1
 */