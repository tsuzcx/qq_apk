import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.PreloadItem;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.PreloadListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class nnd
  implements Runnable
{
  public nnd(TVKPreloader.PreloadItem paramPreloadItem) {}
  
  public void run()
  {
    Iterator localIterator = TVKPreloader.a().iterator();
    while (localIterator.hasNext()) {
      ((TVKPreloader.PreloadListener)localIterator.next()).a(this.a, new Throwable("TVK_ICacheMgr create failed !"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nnd
 * JD-Core Version:    0.7.0.1
 */