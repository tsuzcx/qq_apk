import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager;
import java.lang.ref.WeakReference;

public class rqy
  extends Handler
{
  private WeakReference<ReadInJoySkinAnimManager> a;
  
  public rqy(ReadInJoySkinAnimManager paramReadInJoySkinAnimManager)
  {
    this.a = new WeakReference(paramReadInJoySkinAnimManager);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ReadInJoySkinAnimManager localReadInJoySkinAnimManager = (ReadInJoySkinAnimManager)this.a.get();
    if (localReadInJoySkinAnimManager == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      ReadInJoySkinAnimManager.b(localReadInJoySkinAnimManager);
      return;
    }
    ReadInJoySkinAnimManager.a(localReadInJoySkinAnimManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rqy
 * JD-Core Version:    0.7.0.1
 */