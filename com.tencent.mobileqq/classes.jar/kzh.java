import com.tencent.biz.pubaccount.SuperWebView;
import java.util.ArrayList;
import java.util.Iterator;

public class kzh
  implements Runnable
{
  public kzh(SuperWebView paramSuperWebView) {}
  
  public void run()
  {
    Iterator localIterator = SuperWebView.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      SuperWebView.a(this.a, str);
    }
    SuperWebView.a(this.a).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kzh
 * JD-Core Version:    0.7.0.1
 */