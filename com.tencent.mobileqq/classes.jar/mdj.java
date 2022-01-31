import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsScrollLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsScrollLayout.ContentLayoutListener;

public class mdj
  implements Runnable
{
  public mdj(VideoFeedsScrollLayout paramVideoFeedsScrollLayout) {}
  
  public void run()
  {
    if (VideoFeedsScrollLayout.a(this.a) != null) {
      VideoFeedsScrollLayout.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mdj
 * JD-Core Version:    0.7.0.1
 */