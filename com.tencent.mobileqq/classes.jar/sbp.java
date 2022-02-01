import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.qphone.base.util.QLog;

class sbp
  extends pmn
{
  sbp(sbo paramsbo) {}
  
  public void b(String paramString, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      if (sbo.a(this.a).a != null) {
        sbo.a(this.a).a.o();
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
      QLog.d("VideoFeedsRecommendPresenter", 2, "onViolaTopicVideoAnimStart mVideoFromType：" + sbo.a(this.a));
    }
    pmk.a().b(sbo.a(this.a));
    if (sbo.a(this.a) == 124) {
      sbo.a(this.a).finish();
    }
    do
    {
      return;
      sbo.a(this.a, true);
    } while (sbo.a(this.a) == null);
    sbo.a(this.a).a = null;
    sbo.a(this.a).d();
    sbo.a(this.a).b(sbo.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbp
 * JD-Core Version:    0.7.0.1
 */