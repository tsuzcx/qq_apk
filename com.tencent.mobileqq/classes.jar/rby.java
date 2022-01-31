import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rby
  implements bfob
{
  List<bfob> a = new ArrayList();
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(bfob parambfob)
  {
    if (!this.a.contains(parambfob)) {
      this.a.add(parambfob);
    }
  }
  
  public void b(bfob parambfob)
  {
    this.a.remove(parambfob);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      bfob localbfob = (bfob)localIterator.next();
      try
      {
        localbfob.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
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
      bfob localbfob = (bfob)localIterator.next();
      try
      {
        localbfob.onScrollStateChanged(paramAbsListView, paramInt);
      }
      catch (Throwable localThrowable) {}
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseListView", 2, "onScrollStateChanged exp", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rby
 * JD-Core Version:    0.7.0.1
 */