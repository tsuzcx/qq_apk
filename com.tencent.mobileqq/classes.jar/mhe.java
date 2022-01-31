import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCommentManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsInterruptedAdManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoStatusListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class mhe
  extends VideoFeedsPlayManager.VideoStatusListener
{
  public mhe(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    boolean bool;
    if ((VideoFeedsPlayActivity.d(this.a)) && (VideoFeedsPlayActivity.a(this.a) != null))
    {
      bool = VideoFeedsPlayActivity.a(this.a).c();
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "video play completion!, in weishi mode! interrupted weishi ad");
      }
      if (!bool) {}
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "video play completion!, move to next position");
      }
      bool = VideoFeedsPlayActivity.f(this.a);
      if (VideoFeedsPlayActivity.f(this.a)) {
        VideoFeedsPlayActivity.a(this.a).post(new mhf(this));
      }
      if (VideoFeedsPlayActivity.a(this.a))
      {
        if (!bool) {
          VideoFeedsPlayActivity.d(this.a);
        }
        VideoFeedsPlayActivity.a(this.a).b(5);
        return;
      }
    } while ((this.a.a() == VideoFeedsPlayActivity.a(this.a).size() - 1) || (NetworkUtil.b(VideoFeedsPlayActivity.a(this.a).getApplication().getApplicationContext())));
    if (VideoFeedsPlayActivity.a(this.a).a())
    {
      VideoFeedsPlayActivity.d(this.a, true);
      return;
    }
    VideoFeedsPlayActivity.a(this.a).postDelayed(new mhg(this, paramVideoPlayParam), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mhe
 * JD-Core Version:    0.7.0.1
 */