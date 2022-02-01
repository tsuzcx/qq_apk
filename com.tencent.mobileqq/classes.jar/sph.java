import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sph
  implements bkhe
{
  List<bkhe> a = new ArrayList();
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(bkhe parambkhe)
  {
    if (!this.a.contains(parambkhe)) {
      this.a.add(parambkhe);
    }
  }
  
  public void b(bkhe parambkhe)
  {
    this.a.remove(parambkhe);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      bkhe localbkhe = (bkhe)localIterator.next();
      try
      {
        localbkhe.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
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
      bkhe localbkhe = (bkhe)localIterator.next();
      try
      {
        localbkhe.onScrollStateChanged(paramAbsListView, paramInt);
      }
      catch (Throwable localThrowable) {}
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseListView", 2, "onScrollStateChanged exp", localThrowable);
      }
    }
    if (paramInt == 0) {
      VideoReport.traverseExposure();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sph
 * JD-Core Version:    0.7.0.1
 */