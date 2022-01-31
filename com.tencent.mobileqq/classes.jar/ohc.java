import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ohc
  implements bfob
{
  private List<bfob> a = new ArrayList();
  
  public void a(bfob parambfob)
  {
    if ((this.a != null) && (!this.a.contains(parambfob))) {
      this.a.add(parambfob);
    }
  }
  
  public void b(bfob parambfob)
  {
    if ((this.a != null) && (this.a.contains(parambfob))) {
      this.a.remove(parambfob);
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
        bfob localbfob = (bfob)localIterator.next();
        if (localbfob != null) {
          localbfob.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
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
        bfob localbfob = (bfob)localIterator.next();
        if (localbfob != null) {
          localbfob.onScrollStateChanged(paramAbsListView, paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ohc
 * JD-Core Version:    0.7.0.1
 */