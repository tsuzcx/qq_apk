import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.qphone.base.util.QLog;

public class rrr
  implements rrp
{
  public rrr(ReadInJoyBaseListView paramReadInJoyBaseListView) {}
  
  public void a()
  {
    if (ork.a(ork.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseListView", 2, new Object[] { "preloadOptimize switch ON, mCurrentStatus = ", Integer.valueOf(this.a.c) });
      }
      if ((this.a.c == 0) && ((!szp.a(this.a.d)) || (!this.a.b)))
      {
        this.a.a(4);
        QLog.d("ReadInJoyBaseListView", 2, "preloadOptimize switch ON, loadingMore()");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseListView", 2, new Object[] { "preloadOptimize switch OFF, mCurrentStatus = ", Integer.valueOf(this.a.c) });
      }
    } while ((szp.a(this.a.d)) && ((this.a.c != 0) || (this.a.b)));
    this.a.a(4);
    QLog.d("ReadInJoyBaseListView", 2, "preloadOptimize switch OFF, loadingMore()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rrr
 * JD-Core Version:    0.7.0.1
 */