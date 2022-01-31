import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCommentManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoStatusListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class mcn
  extends VideoFeedsPlayManager.VideoStatusListener
{
  public mcn(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "video play completion!, move to next position");
    }
    boolean bool = VideoFeedsPlayActivity.f(this.a);
    if (VideoFeedsPlayActivity.f(this.a)) {
      VideoFeedsPlayActivity.a(this.a).post(new mco(this));
    }
    if (VideoFeedsPlayActivity.a(this.a))
    {
      if (!bool) {
        VideoFeedsPlayActivity.d(this.a);
      }
      VideoFeedsPlayActivity.a(this.a).b(5);
    }
    while ((this.a.a() == VideoFeedsPlayActivity.a(this.a).size() - 1) || (NetworkUtil.b(VideoFeedsPlayActivity.a(this.a).getApplication().getApplicationContext()))) {
      return;
    }
    if (VideoFeedsPlayActivity.a(this.a).a())
    {
      VideoFeedsPlayActivity.d(this.a, true);
      return;
    }
    VideoFeedsPlayActivity.a(this.a).postDelayed(new mcp(this, paramVideoPlayParam), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mcn
 * JD-Core Version:    0.7.0.1
 */