import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.26.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;

public class qos
  implements qpo
{
  qos(qoe paramqoe) {}
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    qoe.d(this.a, false);
    if (!qoe.c(this.a)) {
      return;
    }
    qoe.a(this.a, false);
    if ((this.a.a()) && (qoe.a(this.a) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onDrawFinish checkplayable!");
      }
      if (!qoe.a(this.a).b()) {
        break label122;
      }
      qoe.a(this.a).postDelayed(new ReadInJoyBaseAdapter.26.1(this, paramReadInJoyBaseListView), 1200L);
    }
    for (;;)
    {
      qoe.a(this.a, this.a.a.getLastVisiblePosition() + 1, qoe.c());
      return;
      label122:
      this.a.a(paramReadInJoyBaseListView, qoe.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qos
 * JD-Core Version:    0.7.0.1
 */