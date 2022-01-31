import com.tencent.biz.pubaccount.util.SwipeBackLayout;
import com.tencent.qphone.base.util.QLog;

public class nar
  implements Runnable
{
  public nar(SwipeBackLayout paramSwipeBackLayout) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_SwipeBackLayout", 2, "isFling:" + SwipeBackLayout.b(this.a));
    }
    if (!SwipeBackLayout.b(this.a)) {
      SwipeBackLayout.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nar
 * JD-Core Version:    0.7.0.1
 */