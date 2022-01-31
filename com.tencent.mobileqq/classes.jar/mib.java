import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsScrollLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsScrollLayout.ContentLayoutListener;

public class mib
  implements Runnable
{
  public mib(VideoFeedsScrollLayout paramVideoFeedsScrollLayout) {}
  
  public void run()
  {
    if (VideoFeedsScrollLayout.a(this.a) != null) {
      VideoFeedsScrollLayout.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mib
 * JD-Core Version:    0.7.0.1
 */