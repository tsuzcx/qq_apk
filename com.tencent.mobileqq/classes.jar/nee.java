import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class nee
  extends Handler
{
  public nee(ned paramned, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 257: 
    default: 
      return;
    case 152: 
      ned.a(this.a);
      return;
    case 153: 
      ned.b(this.a);
      return;
    case 256: 
      int i = paramMessage.arg1;
      int j = paramMessage.arg2;
      long l = ((Long)paramMessage.obj).longValue();
      this.a.a(null, i, j, l);
      return;
    }
    ned.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nee
 * JD-Core Version:    0.7.0.1
 */