import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyXListView;
import com.tencent.qphone.base.util.QLog;

public class rcc
  implements rbs
{
  public rcc(ReadInJoyDailyXListView paramReadInJoyDailyXListView) {}
  
  public void a()
  {
    if (ReadInJoyDailyXListView.a(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDailyXListView", 2, new Object[] { "preloadOptimize switch ON, mCurrentStatus = ", this.a.c + " mNoMoreData : " + this.a.b });
      }
      if ((this.a.c == 0) && ((!shu.a(this.a.d)) || (!this.a.b)))
      {
        this.a.a(4);
        QLog.d("ReadInJoyDailyXListView", 2, "preloadOptimize switch ON, loadingMore()");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rcc
 * JD-Core Version:    0.7.0.1
 */