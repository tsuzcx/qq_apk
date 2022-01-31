import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.PreloadItem;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.PreloadListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

class ntb
  implements Runnable
{
  ntb(nsz paramnsz, TVKPreloader.PreloadItem paramPreloadItem, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    Iterator localIterator = TVKPreloader.a().iterator();
    while (localIterator.hasNext()) {
      ((TVKPreloader.PreloadListener)localIterator.next()).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoTVKPreloader$PreloadItem, new Throwable(this.jdField_a_of_type_JavaLangString + "|" + String.valueOf(this.jdField_a_of_type_Int) + "|" + this.b));
    }
    TVKPreloader.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntb
 * JD-Core Version:    0.7.0.1
 */