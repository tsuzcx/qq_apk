import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.PreloadItem;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.PreloadListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

class nsy
  implements Runnable
{
  nsy(nsx paramnsx, TVKPreloader.PreloadItem paramPreloadItem) {}
  
  public void run()
  {
    Iterator localIterator = TVKPreloader.a().iterator();
    while (localIterator.hasNext()) {
      ((TVKPreloader.PreloadListener)localIterator.next()).b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoTVKPreloader$PreloadItem);
    }
    TVKPreloader.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsy
 * JD-Core Version:    0.7.0.1
 */