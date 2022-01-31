import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import java.lang.ref.WeakReference;

public class mmr
  extends Handler
{
  private WeakReference a;
  
  public mmr(ReadInJoyNavigationGridview paramReadInJoyNavigationGridview)
  {
    this.a = new WeakReference(paramReadInJoyNavigationGridview);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ReadInJoyNavigationGridview localReadInJoyNavigationGridview = (ReadInJoyNavigationGridview)this.a.get();
    if ((localReadInJoyNavigationGridview == null) || (ReadInJoyNavigationGridview.a(localReadInJoyNavigationGridview))) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    ReadInJoyNavigationGridview.a(localReadInJoyNavigationGridview);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mmr
 * JD-Core Version:    0.7.0.1
 */