import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class oti
  implements AbsListView.OnScrollListener
{
  private List<AbsListView.OnScrollListener> a = new ArrayList();
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    if ((this.a != null) && (!this.a.contains(paramOnScrollListener))) {
      this.a.add(paramOnScrollListener);
    }
  }
  
  public void b(AbsListView.OnScrollListener paramOnScrollListener)
  {
    if (this.a != null) {
      this.a.remove(paramOnScrollListener);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.a == null) || (this.a.size() <= 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        AbsListView.OnScrollListener localOnScrollListener = (AbsListView.OnScrollListener)localIterator.next();
        if (localOnScrollListener != null) {
          localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
        }
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.a == null) || (this.a.size() <= 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        AbsListView.OnScrollListener localOnScrollListener = (AbsListView.OnScrollListener)localIterator.next();
        if (localOnScrollListener != null) {
          localOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oti
 * JD-Core Version:    0.7.0.1
 */