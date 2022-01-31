import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoStatusListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;

class met
  implements Runnable
{
  met(meq parammeq) {}
  
  public void run()
  {
    if (VideoPlayManager.a(this.a.a) != null) {
      VideoPlayManager.a(this.a.a).a(VideoPlayManager.a(this.a.a));
    }
    VideoPlayManager.a(this.a.a, VideoPlayManager.a(this.a.a), VideoPlayManager.a(this.a.a), 7, null);
    if (VideoPlayManager.a(this.a.a) != null)
    {
      VideoPlayManager.a(this.a.a).d = -1;
      VideoPlayManager.a(this.a.a).b = 0L;
      VideoPlayManager.a(this.a.a, null);
    }
    if (VideoPlayManager.a(this.a.a) != null)
    {
      VideoPlayManager.a(this.a.a).h();
      VideoPlayManager.a(this.a.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     met
 * JD-Core Version:    0.7.0.1
 */