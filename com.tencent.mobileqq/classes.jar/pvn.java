import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment;

public class pvn
  extends RecyclerView.OnScrollListener
{
  public pvn(PTSFragment paramPTSFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      abvl.a().a("list_kandian_daily_new", false);
      return;
    }
    abvl.a().a("list_kandian_daily_new");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pvn
 * JD-Core Version:    0.7.0.1
 */