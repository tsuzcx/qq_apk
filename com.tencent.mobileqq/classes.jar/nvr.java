import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class nvr
  implements begh
{
  private List<begh> a = new ArrayList();
  
  public void a(begh parambegh)
  {
    if ((this.a != null) && (!this.a.contains(parambegh))) {
      this.a.add(parambegh);
    }
  }
  
  public void b(begh parambegh)
  {
    if ((this.a != null) && (this.a.contains(parambegh))) {
      this.a.remove(parambegh);
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
        begh localbegh = (begh)localIterator.next();
        if (localbegh != null) {
          localbegh.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
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
        begh localbegh = (begh)localIterator.next();
        if (localbegh != null) {
          localbegh.onScrollStateChanged(paramAbsListView, paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nvr
 * JD-Core Version:    0.7.0.1
 */