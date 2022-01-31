import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoStatusListener;
import java.util.ArrayList;
import java.util.Iterator;

class mdx
  implements Runnable
{
  mdx(mdv parammdv) {}
  
  public void run()
  {
    if (VideoFeedsPlayManager.a(this.a.a) != null)
    {
      Iterator localIterator = VideoFeedsPlayManager.a(this.a.a).iterator();
      while (localIterator.hasNext()) {
        ((VideoFeedsPlayManager.VideoStatusListener)localIterator.next()).a(VideoFeedsPlayManager.a(this.a.a));
      }
    }
    this.a.a.b(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mdx
 * JD-Core Version:    0.7.0.1
 */