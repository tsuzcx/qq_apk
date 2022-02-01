import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sgl
  implements blih
{
  List<blih> a = new ArrayList();
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(blih paramblih)
  {
    if (!this.a.contains(paramblih)) {
      this.a.add(paramblih);
    }
  }
  
  public void b(blih paramblih)
  {
    this.a.remove(paramblih);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      blih localblih = (blih)localIterator.next();
      try
      {
        localblih.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
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
      blih localblih = (blih)localIterator.next();
      try
      {
        localblih.onScrollStateChanged(paramAbsListView, paramInt);
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
 * Qualified Name:     sgl
 * JD-Core Version:    0.7.0.1
 */