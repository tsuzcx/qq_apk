import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.pull2refresh.XRecyclerView;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper;

public class ooo
  extends RecyclerView.OnScrollListener
{
  public ooo(XRecyclerView paramXRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (XRecyclerView.a(this.a) == 2)) {
      this.a.a();
    }
    if (paramInt == 2)
    {
      UIUtils.a(true);
      i = paramRecyclerView.getChildCount();
      if ((paramRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager))
      {
        paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.getLayoutManager();
        int j = paramRecyclerView.getItemCount();
        paramRecyclerView = paramRecyclerView.findFirstVisibleItemPositions(null);
        int k = XRecyclerView.a(this.a).a();
        if (j - i > paramRecyclerView[0] + k) {
          break label131;
        }
      }
    }
    label131:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        XRecyclerView.a(this.a).b(false);
      }
      XRecyclerView.a(this.a, paramInt);
      return;
      UIUtils.a(false);
      break;
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ooo
 * JD-Core Version:    0.7.0.1
 */