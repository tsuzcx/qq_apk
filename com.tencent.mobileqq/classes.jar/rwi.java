import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class rwi
  implements Handler.Callback
{
  rwi(rwh paramrwh) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        do
        {
          return true;
          rwh.a(this.a, false);
          rwh.a(this.a).removeMessages(0);
        } while (rwh.a(this.a) == null);
        rwh.a(this.a).a(true);
        return true;
        rwh.a(this.a, false);
        rwh.a(this.a).removeMessages(1);
      } while (rwh.a(this.a) == null);
      rwh.a(this.a).a(false);
      return true;
    }
    rwh.a(this.a, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwi
 * JD-Core Version:    0.7.0.1
 */