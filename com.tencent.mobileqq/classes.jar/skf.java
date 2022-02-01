import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView;

public class skf
  extends OrientationEventListener
{
  public skf(VideoFeedsListView paramVideoFeedsListView, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (VideoFeedsListView.a(this.a)) {}
    while ((!VideoFeedsListView.b(this.a)) || (!VideoFeedsListView.c(this.a)) || (VideoFeedsListView.a(this.a) == 1) || (VideoFeedsListView.d(this.a)) || (!VideoFeedsListView.a(this.a, paramInt)) || ((!VideoFeedsListView.e(this.a)) && (VideoFeedsListView.f(this.a)))) {
      return;
    }
    VideoFeedsListView.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     skf
 * JD-Core Version:    0.7.0.1
 */