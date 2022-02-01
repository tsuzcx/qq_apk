import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyXListView;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.List;

public class szp
  implements tax
{
  public szp(ReadInJoyDailyXListView paramReadInJoyDailyXListView) {}
  
  public void a(int paramInt1, View paramView, ListView paramListView, int paramInt2)
  {
    this.a.a(paramInt1, paramView, paramListView, paramInt2);
  }
  
  public void a(View paramView, ListView paramListView, int paramInt)
  {
    this.a.a(paramView, paramListView, paramInt);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext()) {
      ((bldp)localIterator.next()).onNotCompleteVisable(paramInt, paramView, paramListView);
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext()) {
      ((bldp)localIterator.next()).onViewCompleteVisable(paramInt, paramView, paramListView);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.a.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      if (!((bldp)localIterator.next()).onViewCompleteVisableAndReleased(paramInt, paramView, paramListView)) {
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
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext()) {
      ((bldp)localIterator.next()).onViewNotCompleteVisableAndReleased(paramInt, paramView, paramListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     szp
 * JD-Core Version:    0.7.0.1
 */