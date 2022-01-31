import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.StaggeredGridLayoutManager;

public class sjr
  extends StaggeredGridLayoutManager
{
  public sjr(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    try
    {
      super.onLayoutChildren(paramRecycler, paramState);
      return;
    }
    catch (Exception paramRecycler)
    {
      sne.d("WSStaggeredGridLayoutManager", "onLayoutChildren exception: " + paramRecycler.getLocalizedMessage());
    }
  }
  
  public void scrollToPosition(int paramInt)
  {
    try
    {
      super.scrollToPosition(paramInt);
      return;
    }
    catch (Exception localException)
    {
      sne.d("WSStaggeredGridLayoutManager", "scrollToPosition exception: " + localException.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sjr
 * JD-Core Version:    0.7.0.1
 */