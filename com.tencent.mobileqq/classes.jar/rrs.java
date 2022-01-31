import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rrs
  implements bhtv
{
  List<bhtv> a = new ArrayList();
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(bhtv parambhtv)
  {
    if (!this.a.contains(parambhtv)) {
      this.a.add(parambhtv);
    }
  }
  
  public void b(bhtv parambhtv)
  {
    this.a.remove(parambhtv);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      bhtv localbhtv = (bhtv)localIterator.next();
      try
      {
        localbhtv.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      catch (Throwable localThrowable) {}
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyBaseListView", 2, "onScroll exp", localThrowable);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      bhtv localbhtv = (bhtv)localIterator.next();
      try
      {
        localbhtv.onScrollStateChanged(paramAbsListView, paramInt);
      }
      catch (Throwable localThrowable) {}
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseListView", 2, "onScrollStateChanged exp", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rrs
 * JD-Core Version:    0.7.0.1
 */