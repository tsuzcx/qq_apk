import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule;

public class lsa
  extends Handler
{
  public lsa(SubscriptionInfoModule paramSubscriptionInfoModule, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lsa
 * JD-Core Version:    0.7.0.1
 */