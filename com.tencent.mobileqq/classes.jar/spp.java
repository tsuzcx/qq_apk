import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyXListView;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.List;

public class spp
  implements ssc
{
  public spp(ReadInJoyDailyXListView paramReadInJoyDailyXListView) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext()) {
      ((bkmq)localIterator.next()).a(paramInt, paramView, paramListView);
    }
  }
  
  public void a(int paramInt1, View paramView, ListView paramListView, int paramInt2)
  {
    this.a.a(paramInt1, paramView, paramListView, paramInt2);
  }
  
  public void a(View paramView, ListView paramListView, int paramInt)
  {
    this.a.a(paramView, paramListView, paramInt);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.a.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      if (!((bkmq)localIterator.next()).a(paramInt, paramView, paramListView)) {
        break label57;
      }
      bool = true;
    }
    label57:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext()) {
      ((bkmq)localIterator.next()).b(paramInt, paramView, paramListView);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext()) {
      ((bkmq)localIterator.next()).c(paramInt, paramView, paramListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     spp
 * JD-Core Version:    0.7.0.1
 */