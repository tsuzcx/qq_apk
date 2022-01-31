import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyAdVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;

public class mdd
  implements Runnable
{
  public mdd(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  public void run()
  {
    if ((VideoFeedsPlayManager.a(this.a) != null) && ((VideoFeedsPlayManager.a(this.a).c() == 5) || (VideoFeedsPlayManager.a(this.a).c() == 2)))
    {
      VideoFeedsPlayManager.a(this.a).e();
      VideoFeedsPlayManager.a(this.a, 8);
      if ((VideoFeedsPlayManager.a(this.a) == null) || (VideoFeedsPlayManager.a(this.a).c.getVisibility() != 0)) {
        break label118;
      }
      this.a.b(3);
    }
    for (;;)
    {
      if (VideoFeedsPlayManager.d(this.a)) {
        VideoFeedsPlayManager.a(this.a).a.f = ReadinjoyAdVideoReportData.b;
      }
      return;
      label118:
      this.a.b(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mdd
 * JD-Core Version:    0.7.0.1
 */