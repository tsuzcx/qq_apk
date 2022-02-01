import android.app.Activity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter$onColumnActionObserver$1", "Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyObserver;", "onViolaPageFailed", "", "violaPageName", "", "fromType", "", "onViolaTopicVideoAnimStart", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class slt
  extends pvq
{
  public void f(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "violaPageName");
    if ((paramInt == 1) || (paramInt == 2))
    {
      paramString = this.a.a();
      if (paramString == null) {
        break label64;
      }
    }
    label64:
    for (paramString = paramString.a; paramString != null; paramString = null)
    {
      paramString = this.a.a();
      if (paramString != null)
      {
        paramString = paramString.a;
        if (paramString != null) {
          paramString.o();
        }
      }
      return;
    }
    QLog.e("VideoFeedsRecommendPresenter", 2, "onViolaPageFailed callback, attachVideoPlayer videoPlayer is null");
  }
  
  public void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecommendPresenter", 2, "onViolaTopicVideoAnimStart mVideoFromType：" + this.a.b());
    }
    pvm.a().b((pvq)this);
    if (bmhv.g(this.a.b()))
    {
      localObject = this.a.a();
      if (localObject != null) {
        ((Activity)localObject).finish();
      }
    }
    do
    {
      return;
      slr.a(this.a, true);
    } while (this.a.a() == null);
    Object localObject = this.a.a();
    if (localObject != null) {
      ((skq)localObject).a = ((spn)null);
    }
    this.a.a().b(ReportConstants.VideoEndType.EXIT_SCENE);
    this.a.a().b(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     slt
 * JD-Core Version:    0.7.0.1
 */