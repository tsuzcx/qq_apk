import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class nfx
  extends Handler
{
  public nfx(nfw paramnfw, Looper paramLooper)
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
      nfw.a(this.a);
      return;
    case 153: 
      nfw.b(this.a);
      return;
    case 256: 
      int i = paramMessage.arg1;
      int j = paramMessage.arg2;
      long l = ((Long)paramMessage.obj).longValue();
      this.a.a(null, i, j, l);
      return;
    }
    nfw.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nfx
 * JD-Core Version:    0.7.0.1
 */