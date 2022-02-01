import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyXListView;
import com.tencent.qphone.base.util.QLog;

public class sgs
  implements sgg
{
  public sgs(ReadInJoyDailyXListView paramReadInJoyDailyXListView) {}
  
  public void a()
  {
    if (ReadInJoyDailyXListView.a(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDailyXListView", 2, new Object[] { "preloadOptimize switch ON, mCurrentStatus = ", this.a.c + " mNoMoreData : " + this.a.b });
      }
      if ((this.a.c == 0) && ((!ubg.a(this.a.d)) || (!this.a.b)))
      {
        this.a.a(4);
        QLog.d("ReadInJoyDailyXListView", 2, "preloadOptimize switch ON, loadingMore()");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgs
 * JD-Core Version:    0.7.0.1
 */