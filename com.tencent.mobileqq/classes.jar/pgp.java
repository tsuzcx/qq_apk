import com.tencent.biz.webviewplugin.OfflinePlugin;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class pgp
  implements Runnable
{
  public pgp(OfflinePlugin paramOfflinePlugin) {}
  
  public void run()
  {
    if ((this.a.a == null) || (this.a.a.size() == 0)) {
      return;
    }
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.a.b(str);
    }
    this.a.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgp
 * JD-Core Version:    0.7.0.1
 */