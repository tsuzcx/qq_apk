import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView;
import com.tencent.qphone.base.util.QLog;

public class tcl
  extends RecyclerView.OnScrollListener
{
  public tcl(ReadInjoyXRecyclerView paramReadInjoyXRecyclerView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    int i = 0;
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (ReadInjoyXRecyclerView.c(this.a) == 2)) {
      this.a.a();
    }
    int j = paramRecyclerView.getChildCount();
    boolean bool;
    if ((paramRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager))
    {
      paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.getLayoutManager();
      i = paramRecyclerView.getItemCount();
      paramRecyclerView = paramRecyclerView.findFirstVisibleItemPositions(null);
      int k = ReadInjoyXRecyclerView.a(this.a).a();
      if (i - j <= paramRecyclerView[0] + k)
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("XRecyclerView", 2, new Object[] { "totalItemCount=%d, firstVisibleItem=%d, visibleThreshold=%d, isCloseToTheEnd=%b", Integer.valueOf(i), Integer.valueOf(paramRecyclerView[0]), Integer.valueOf(k), Boolean.valueOf(bool) });
        }
        if (bool) {
          ReadInjoyXRecyclerView.a(this.a).b(true);
        }
      }
    }
    for (;;)
    {
      ReadInjoyXRecyclerView.c(this.a, paramInt);
      return;
      bool = false;
      break;
      if ((paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
      {
        paramRecyclerView = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
        if (paramRecyclerView.getItemCount() - j <= paramRecyclerView.findFirstVisibleItemPosition() + ReadInjoyXRecyclerView.a(this.a).a()) {
          i = 1;
        }
        if (i != 0) {
          ReadInjoyXRecyclerView.a(this.a).b(true);
        }
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    ReadInjoyXRecyclerView.a(this.a, ReadInjoyXRecyclerView.a(this.a) + paramInt1);
    ReadInjoyXRecyclerView.b(this.a, ReadInjoyXRecyclerView.b(this.a) + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tcl
 * JD-Core Version:    0.7.0.1
 */