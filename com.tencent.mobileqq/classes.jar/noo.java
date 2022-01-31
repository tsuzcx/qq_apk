import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.PreloadItem;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.PreloadListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class noo
  implements Runnable
{
  public noo(TVKPreloader.PreloadItem paramPreloadItem) {}
  
  public void run()
  {
    Iterator localIterator = TVKPreloader.a().iterator();
    while (localIterator.hasNext()) {
      ((TVKPreloader.PreloadListener)localIterator.next()).c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     noo
 * JD-Core Version:    0.7.0.1
 */