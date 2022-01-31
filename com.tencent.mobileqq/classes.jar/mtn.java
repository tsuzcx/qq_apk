import com.tencent.biz.pubaccount.util.PreloadManager;
import java.util.Iterator;
import java.util.List;

public class mtn
  implements Runnable
{
  public mtn(PreloadManager paramPreloadManager) {}
  
  public void run()
  {
    ??? = PreloadManager.a(this.a).iterator();
    while (((Iterator)???).hasNext())
    {
      String str = (String)((Iterator)???).next();
      PreloadManager.a(this.a, str);
    }
    synchronized (this.a.b)
    {
      PreloadManager.a(this.a).clear();
      if (PreloadManager.b(this.a).size() > 0)
      {
        this.a.a();
        return;
      }
      this.a.a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mtn
 * JD-Core Version:    0.7.0.1
 */