import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.qphone.base.util.QLog;

class rsl
  extends pfh
{
  rsl(rsk paramrsk) {}
  
  public void b(String paramString, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      if (rsk.a(this.a).a != null) {
        rsk.a(this.a).a.o();
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
      QLog.d("VideoFeedsRecommendPresenter", 2, "onViolaTopicVideoAnimStart mVideoFromType：" + rsk.a(this.a));
    }
    pfd.a().b(rsk.a(this.a));
    if (bnrf.g(rsk.a(this.a))) {
      rsk.a(this.a).finish();
    }
    do
    {
      return;
      rsk.a(this.a, true);
    } while (rsk.a(this.a) == null);
    rsk.a(this.a).a = null;
    rsk.a(this.a).d();
    rsk.a(this.a).b(rsk.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsl
 * JD-Core Version:    0.7.0.1
 */