import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.tencent.av.gaudio.BaseGaInvite;

@SuppressLint({"HandlerLeak"})
public class jkj
  extends Handler
{
  public jkj(BaseGaInvite paramBaseGaInvite) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.a.b();
      return;
    }
    this.a.a("Msg");
    super.sendEmptyMessageDelayed(1, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jkj
 * JD-Core Version:    0.7.0.1
 */