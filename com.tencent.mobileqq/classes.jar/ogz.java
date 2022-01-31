import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ogz
  implements bfos
{
  private List<bfos> a = new ArrayList();
  
  public void a(bfos parambfos)
  {
    if ((this.a != null) && (!this.a.contains(parambfos))) {
      this.a.add(parambfos);
    }
  }
  
  public void b(bfos parambfos)
  {
    if ((this.a != null) && (this.a.contains(parambfos))) {
      this.a.remove(parambfos);
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
        bfos localbfos = (bfos)localIterator.next();
        if (localbfos != null) {
          localbfos.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
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
        bfos localbfos = (bfos)localIterator.next();
        if (localbfos != null) {
          localbfos.onScrollStateChanged(paramAbsListView, paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ogz
 * JD-Core Version:    0.7.0.1
 */