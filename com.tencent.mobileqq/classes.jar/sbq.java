import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;

public class sbq
  extends RecyclerView.OnScrollListener
{
  public sbq(VideoFeedsRecyclerView paramVideoFeedsRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = this.a;
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      VideoFeedsRecyclerView.a(paramRecyclerView, bool);
      return;
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbq
 * JD-Core Version:    0.7.0.1
 */