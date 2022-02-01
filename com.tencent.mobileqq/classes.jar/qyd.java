import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment;
import com.tencent.mfsdk.collector.DropFrameMonitor;

public class qyd
  extends RecyclerView.OnScrollListener
{
  public qyd(PTSFragment paramPTSFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      DropFrameMonitor.getInstance().stopMonitorScene("list_kandian_daily_new", false);
      return;
    }
    DropFrameMonitor.getInstance().startMonitorScene("list_kandian_daily_new");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qyd
 * JD-Core Version:    0.7.0.1
 */