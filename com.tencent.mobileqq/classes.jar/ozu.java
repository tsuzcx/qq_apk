import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ozu
  implements bkhe
{
  private List<bkhe> a = new ArrayList();
  
  public void a(bkhe parambkhe)
  {
    if ((this.a != null) && (!this.a.contains(parambkhe))) {
      this.a.add(parambkhe);
    }
  }
  
  public void b(bkhe parambkhe)
  {
    if (this.a != null) {
      this.a.remove(parambkhe);
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
        bkhe localbkhe = (bkhe)localIterator.next();
        if (localbkhe != null) {
          localbkhe.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
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
        bkhe localbkhe = (bkhe)localIterator.next();
        if (localbkhe != null) {
          localbkhe.onScrollStateChanged(paramAbsListView, paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ozu
 * JD-Core Version:    0.7.0.1
 */