import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.qphone.base.util.QLog;

class rzp
  extends pkt
{
  rzp(rzo paramrzo) {}
  
  public void b(String paramString, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      if (rzo.a(this.a).a != null) {
        rzo.a(this.a).a.o();
      }
    }
    else {
      return;
    }
    QLog.e("VideoFeedsRecommendPresenter", 2, "onViolaPageFailed callback, attachVideoPlayer videoPlayer is null");
  }
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecommendPresenter", 2, "onViolaTopicVideoAnimStart mVideoFromType：" + rzo.a(this.a));
    }
    pkp.a().b(rzo.a(this.a));
    if (bkwm.g(rzo.a(this.a))) {
      rzo.a(this.a).finish();
    }
    do
    {
      return;
      rzo.a(this.a, true);
    } while (rzo.a(this.a) == null);
    rzo.a(this.a).a = null;
    rzo.a(this.a).d();
    rzo.a(this.a).b(rzo.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzp
 * JD-Core Version:    0.7.0.1
 */