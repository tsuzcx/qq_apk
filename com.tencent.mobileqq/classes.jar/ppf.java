import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment;

public class ppf
  extends RecyclerView.OnScrollListener
{
  public ppf(PTSFragment paramPTSFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      zzz.a().a("list_kandian_daily_new", false);
      return;
    }
    zzz.a().a("list_kandian_daily_new");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ppf
 * JD-Core Version:    0.7.0.1
 */