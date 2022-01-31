import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.26.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;

public class rba
  implements rbw
{
  rba(ram paramram) {}
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    ram.d(this.a, false);
    if (!ram.c(this.a)) {
      return;
    }
    ram.a(this.a, false);
    if ((this.a.a()) && (ram.a(this.a) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onDrawFinish checkplayable!");
      }
      if (!ram.a(this.a).b()) {
        break label122;
      }
      ram.a(this.a).postDelayed(new ReadInJoyBaseAdapter.26.1(this, paramReadInJoyBaseListView), 1200L);
    }
    for (;;)
    {
      ram.a(this.a, this.a.a.getLastVisiblePosition() + 1, ram.c());
      return;
      label122:
      this.a.a(paramReadInJoyBaseListView, ram.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rba
 * JD-Core Version:    0.7.0.1
 */