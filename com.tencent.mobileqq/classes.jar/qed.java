import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView;

public class qed
  extends OrientationEventListener
{
  public qed(VideoFeedsListView paramVideoFeedsListView, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (VideoFeedsListView.a(this.a)) {}
    label10:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                break label10;
                break label10;
                break label10;
                break label10;
                do
                {
                  return;
                } while ((!VideoFeedsListView.b(this.a)) || (!VideoFeedsListView.c(this.a)) || (VideoFeedsListView.a(this.a) == 1) || (VideoFeedsListView.d(this.a)) || (!VideoFeedsListView.a(this.a, paramInt)) || ((!VideoFeedsListView.e(this.a)) && (VideoFeedsListView.f(this.a))));
                if ((paramInt < 0) || ((paramInt > 30) && (paramInt < 330))) {
                  break;
                }
              } while ((VideoFeedsListView.b(this.a) != -1) && (VideoFeedsListView.b(this.a) != 0));
              VideoFeedsListView.a(this.a, -1);
            } while (VideoFeedsListView.c(this.a) == 0);
            this.a.a(true);
            return;
            if ((paramInt < 70) || (paramInt > 110)) {
              break;
            }
          } while ((VideoFeedsListView.b(this.a) != -1) && (VideoFeedsListView.b(this.a) != 2));
          VideoFeedsListView.a(this.a, -1);
        } while (VideoFeedsListView.c(this.a) == 2);
        VideoFeedsListView.a(this.a, 2, true);
        return;
      } while ((paramInt < 250) || (paramInt > 290) || ((VideoFeedsListView.b(this.a) != -1) && (VideoFeedsListView.b(this.a) != 1)));
      VideoFeedsListView.a(this.a, -1);
    } while (VideoFeedsListView.c(this.a) == 1);
    VideoFeedsListView.a(this.a, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qed
 * JD-Core Version:    0.7.0.1
 */