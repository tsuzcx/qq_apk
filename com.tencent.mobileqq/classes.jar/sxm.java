import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sxm
  extends Handler
{
  public List<Handler.Callback> a = new ArrayList();
  
  public void handleMessage(Message paramMessage)
  {
    Iterator localIterator = this.a.iterator();
    while ((localIterator.hasNext()) && (!((Handler.Callback)localIterator.next()).handleMessage(paramMessage))) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sxm
 * JD-Core Version:    0.7.0.1
 */