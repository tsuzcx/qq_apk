import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class oln
  implements bhpo
{
  private List<bhpo> a = new ArrayList();
  
  public void a(bhpo parambhpo)
  {
    if ((this.a != null) && (!this.a.contains(parambhpo))) {
      this.a.add(parambhpo);
    }
  }
  
  public void b(bhpo parambhpo)
  {
    if ((this.a != null) && (this.a.contains(parambhpo))) {
      this.a.remove(parambhpo);
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
        bhpo localbhpo = (bhpo)localIterator.next();
        if (localbhpo != null) {
          localbhpo.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
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
        bhpo localbhpo = (bhpo)localIterator.next();
        if (localbhpo != null) {
          localbhpo.onScrollStateChanged(paramAbsListView, paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oln
 * JD-Core Version:    0.7.0.1
 */