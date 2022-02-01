import android.os.Handler;
import android.os.Message;

class rwv
  extends Handler
{
  rwv(rwu paramrwu) {}
  
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
        rwu.a(this.a);
        return;
        this.a.l();
        return;
        rwu.b(this.a);
        sendEmptyMessageDelayed(102, 1000L);
      } while (rwu.a(this.a) != 1);
      rwu.c(this.a);
      return;
    case 103: 
      rwu.a(this.a, 3);
      return;
    case 104: 
      rwu.d(this.a);
      return;
    }
    rwu.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwv
 * JD-Core Version:    0.7.0.1
 */