import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;

public class rso
  implements View.OnLayoutChangeListener
{
  public rso(VideoFeedsRecyclerView paramVideoFeedsRecyclerView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.a.removeOnLayoutChangeListener(this);
    if (VideoFeedsRecyclerView.a(this.a) != null) {
      VideoFeedsRecyclerView.a(this.a).a(VideoFeedsRecyclerView.a(this.a).itemView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rso
 * JD-Core Version:    0.7.0.1
 */