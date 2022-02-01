import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class nhf
  extends Handler
{
  public nhf(nhe paramnhe, Looper paramLooper)
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
      nhe.a(this.a);
      return;
    case 153: 
      nhe.b(this.a);
      return;
    case 256: 
      int i = paramMessage.arg1;
      int j = paramMessage.arg2;
      long l = ((Long)paramMessage.obj).longValue();
      this.a.a(null, i, j, l);
      return;
    }
    nhe.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nhf
 * JD-Core Version:    0.7.0.1
 */