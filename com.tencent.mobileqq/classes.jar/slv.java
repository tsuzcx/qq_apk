import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;

public class slv
  implements View.OnLayoutChangeListener
{
  public slv(VideoFeedsRecyclerView paramVideoFeedsRecyclerView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.a.removeOnLayoutChangeListener(this);
    if ((VideoFeedsRecyclerView.a(this.a) != null) && (VideoFeedsRecyclerView.a(this.a)))
    {
      paramInt1 = 0;
      if (VideoFeedsRecyclerView.a(this.a) != 0) {
        break label228;
      }
    }
    label227:
    label228:
    label244:
    do
    {
      paramInt1 = (int)(this.a.getHeight() * 0.3D);
      break label227;
      paramView = VideoFeedsRecyclerView.a(this.a).getLayoutParams();
      paramView.height = paramInt1;
      VideoFeedsRecyclerView.a(this.a).setLayoutParams(paramView);
      if (VideoFeedsRecyclerView.a(this.a) == 0)
      {
        paramView = this.a.getLayoutManager().findViewByPosition(1);
        if ((paramView != null) && (paramView.getHeight() > 0) && (VideoFeedsRecyclerView.b(this.a)))
        {
          paramInt1 = paramView.getHeight();
          paramInt1 = (int)(this.a.getHeight() / 2.0F - paramInt1 / 2.0F);
          VideoFeedsRecyclerView.a(this.a, paramInt1);
          if ((!VideoFeedsRecyclerView.a(this.a).a(1)) || (VideoFeedsRecyclerView.a(this.a).b() == 1)) {
            break label244;
          }
        }
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if ((paramInt1 == 0) && (VideoFeedsRecyclerView.a(this.a) != null) && (VideoFeedsRecyclerView.a(this.a).b() != 1)) {
            this.a.a(this.a.getChildViewHolder(paramView));
          }
          return;
          if (VideoFeedsRecyclerView.a(this.a) != 1) {
            break;
          }
          paramInt1 = 0;
          break;
        }
      }
    } while (VideoFeedsRecyclerView.a(this.a) != 1);
    VideoFeedsRecyclerView.a(this.a, VideoFeedsRecyclerView.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     slv
 * JD-Core Version:    0.7.0.1
 */