import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class nnx
  extends Handler
{
  public nnx(nnw paramnnw, Looper paramLooper)
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
      nnw.a(this.a);
      return;
    case 153: 
      nnw.b(this.a);
      return;
    case 256: 
      int i = paramMessage.arg1;
      int j = paramMessage.arg2;
      long l = ((Long)paramMessage.obj).longValue();
      this.a.a(null, i, j, l);
      return;
    }
    nnw.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nnx
 * JD-Core Version:    0.7.0.1
 */