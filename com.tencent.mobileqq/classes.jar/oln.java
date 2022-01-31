import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class oln
  implements bhtv
{
  private List<bhtv> a = new ArrayList();
  
  public void a(bhtv parambhtv)
  {
    if ((this.a != null) && (!this.a.contains(parambhtv))) {
      this.a.add(parambhtv);
    }
  }
  
  public void b(bhtv parambhtv)
  {
    if ((this.a != null) && (this.a.contains(parambhtv))) {
      this.a.remove(parambhtv);
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
        bhtv localbhtv = (bhtv)localIterator.next();
        if (localbhtv != null) {
          localbhtv.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
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
        bhtv localbhtv = (bhtv)localIterator.next();
        if (localbhtv != null) {
          localbhtv.onScrollStateChanged(paramAbsListView, paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oln
 * JD-Core Version:    0.7.0.1
 */