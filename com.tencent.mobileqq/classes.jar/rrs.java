import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rrs
  implements bhpo
{
  List<bhpo> a = new ArrayList();
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(bhpo parambhpo)
  {
    if (!this.a.contains(parambhpo)) {
      this.a.add(parambhpo);
    }
  }
  
  public void b(bhpo parambhpo)
  {
    this.a.remove(parambhpo);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      bhpo localbhpo = (bhpo)localIterator.next();
      try
      {
        localbhpo.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
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
      bhpo localbhpo = (bhpo)localIterator.next();
      try
      {
        localbhpo.onScrollStateChanged(paramAbsListView, paramInt);
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