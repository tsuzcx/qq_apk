import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;

public class mfq
  extends Handler
{
  public mfq(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
    }
    do
    {
      return;
      if (!this.a.d) {
        break;
      }
    } while (!this.a.c);
    ReadInJoyBaseAdapter.a(this.a, this.a.a);
    return;
    ReadInJoyBaseAdapter.a(this.a, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mfq
 * JD-Core Version:    0.7.0.1
 */