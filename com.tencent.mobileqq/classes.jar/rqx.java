import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.26.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;

public class rqx
  implements rrt
{
  rqx(rqj paramrqj) {}
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    rqj.d(this.a, false);
    if (!rqj.c(this.a)) {
      return;
    }
    rqj.a(this.a, false);
    if ((this.a.a()) && (rqj.a(this.a) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onDrawFinish checkplayable!");
      }
      if (!rqj.a(this.a).b()) {
        break label122;
      }
      rqj.a(this.a).postDelayed(new ReadInJoyBaseAdapter.26.1(this, paramReadInJoyBaseListView), 1200L);
    }
    for (;;)
    {
      rqj.a(this.a, this.a.a.getLastVisiblePosition() + 1, rqj.c());
      return;
      label122:
      this.a.a(paramReadInJoyBaseListView, rqj.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rqx
 * JD-Core Version:    0.7.0.1
 */