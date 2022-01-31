import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment;

public class pdq
  extends RecyclerView.OnScrollListener
{
  public pdq(PTSFragment paramPTSFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      zqk.a().a("list_kandian_daily_new", false);
      return;
    }
    zqk.a().a("list_kandian_daily_new");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pdq
 * JD-Core Version:    0.7.0.1
 */