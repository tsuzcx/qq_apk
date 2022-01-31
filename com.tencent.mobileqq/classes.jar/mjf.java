import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer.OnTipClickListener;

public class mjf
  extends Handler
{
  public mjf(ReadInJoySearchTipsContainer paramReadInJoySearchTipsContainer, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (this.a.a != null)
    {
      if (paramMessage.obj != null) {
        this.a.a.a((String)paramMessage.obj);
      }
    }
    else {
      return;
    }
    this.a.a.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mjf
 * JD-Core Version:    0.7.0.1
 */