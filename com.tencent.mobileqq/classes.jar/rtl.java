import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyScrollViewSwitcher;
import java.lang.ref.WeakReference;

public class rtl
  extends Handler
{
  private WeakReference a;
  
  public rtl(ReadInJoyScrollViewSwitcher paramReadInJoyScrollViewSwitcher)
  {
    this.a = new WeakReference(paramReadInJoyScrollViewSwitcher);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    paramMessage = (ReadInJoyScrollViewSwitcher)this.a.get();
    if (paramMessage != null)
    {
      paramMessage.a();
      paramMessage.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rtl
 * JD-Core Version:    0.7.0.1
 */