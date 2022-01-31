import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;

public class tbd
  extends RecyclerView.OnScrollListener
{
  public tbd(WSFollowFragment paramWSFollowFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 1) {
      WSFollowFragment.a(this.a, true);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if (WSFollowFragment.a(this.a).a == null)
    {
      paramInt1 = WSFollowFragment.a(this.a).findFirstVisibleItemPosition();
      paramRecyclerView = WSFollowFragment.a(this.a, paramInt1, false);
      tlo.d("WSFollowContinuePlayLog", "mAdapter.mPlayingHolder is null. startPosition:" + paramInt1 + ", lastOrNextVideoHolder:" + paramRecyclerView);
      if (WSFollowFragment.a(this.a, paramRecyclerView))
      {
        if (!WSFollowFragment.a(this.a)) {
          break label149;
        }
        tlo.d("WSFollowContinuePlayLog", "[WSFollowFragment.java][onScrolled] mIsHandlingBackFromVertical true.");
      }
    }
    else
    {
      paramRecyclerView = this.a;
      localObject = WSFollowFragment.a(this.a).a;
      if (paramInt2 > 0) {}
      for (bool1 = true;; bool1 = false)
      {
        paramRecyclerView = paramRecyclerView.a((tgd)localObject, bool1, false);
        break;
      }
    }
    label149:
    tlo.g("WSFollowContinuePlayLog", "[WSFollowFragment.java][onScrolled] playVideo title:" + paramRecyclerView.a.d + ", mPlayingHolder:" + paramRecyclerView);
    WSFollowFragment.a(this.a, paramRecyclerView);
    Object localObject = this.a;
    boolean bool1 = bool2;
    if (paramInt2 > 0) {
      bool1 = true;
    }
    paramRecyclerView = ((WSFollowFragment)localObject).a(paramRecyclerView, bool1, true);
    tlo.a("WS_VIDEO_PRE_PLAY", "[WSFollowFragment.java][onScrolled] setPrePlayingHolder prePlayHolder:" + paramRecyclerView);
    WSFollowFragment.a(this.a).b(paramRecyclerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tbd
 * JD-Core Version:    0.7.0.1
 */