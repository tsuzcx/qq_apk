import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;

public class rgs
  extends RecyclerView.OnScrollListener
{
  public rgs(VideoFeedsRecyclerView paramVideoFeedsRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      VideoFeedsRecyclerView.a(this.a, false);
      return;
    }
    VideoFeedsRecyclerView.a(this.a, true);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rgs
 * JD-Core Version:    0.7.0.1
 */