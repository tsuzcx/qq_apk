import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class osj
  implements blih
{
  private List<blih> a = new ArrayList();
  
  public void a(blih paramblih)
  {
    if ((this.a != null) && (!this.a.contains(paramblih))) {
      this.a.add(paramblih);
    }
  }
  
  public void b(blih paramblih)
  {
    if (this.a != null) {
      this.a.remove(paramblih);
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
        blih localblih = (blih)localIterator.next();
        if (localblih != null) {
          localblih.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
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
        blih localblih = (blih)localIterator.next();
        if (localblih != null) {
          localblih.onScrollStateChanged(paramAbsListView, paramInt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osj
 * JD-Core Version:    0.7.0.1
 */