import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar;
import java.util.concurrent.atomic.AtomicBoolean;

public class sls
  extends Handler
{
  public sls(BaseTabbar paramBaseTabbar) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
      int i;
      do
      {
        return;
        BaseTabbar.a(this.a, 0.0F);
        BaseTabbar.a(this.a, (float)(BaseTabbar.a(this.a) + 0.05D));
        this.a.invalidate();
        i = paramMessage.arg1;
        sendMessageDelayed(BaseTabbar.a(this.a).obtainMessage(1), 10L);
      } while (i == 1);
      BaseTabbar.a(this.a, BaseTabbar.a(this.a), BaseTabbar.b(this.a));
      return;
    case 1: 
      if (BaseTabbar.a(this.a) < 1.0F)
      {
        BaseTabbar.a(this.a, (float)(BaseTabbar.a(this.a) + 0.05D));
        this.a.invalidate();
        sendMessageDelayed(BaseTabbar.a(this.a).obtainMessage(1), 10L);
        return;
      }
      sendMessageDelayed(BaseTabbar.a(this.a).obtainMessage(2), 10L);
      return;
    }
    BaseTabbar.a(this.a);
    this.a.a(BaseTabbar.a(this.a), BaseTabbar.b(this.a));
    BaseTabbar.a(this.a, 1.0F);
    BaseTabbar.a(this.a, BaseTabbar.b(this.a));
    this.a.invalidate();
    BaseTabbar.a(this.a).set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sls
 * JD-Core Version:    0.7.0.1
 */