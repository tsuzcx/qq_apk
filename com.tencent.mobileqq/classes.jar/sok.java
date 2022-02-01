import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.37.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;

public class sok
  implements spi
{
  sok(snh paramsnh) {}
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    snh.d(this.a, false);
    if (!snh.c(this.a)) {
      return;
    }
    snh.a(this.a, false);
    if ((this.a.a()) && (snh.a(this.a) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onDrawFinish checkplayable!");
      }
      if (!snh.a(this.a).b()) {
        break label122;
      }
      snh.a(this.a).postDelayed(new ReadInJoyBaseAdapter.37.1(this, paramReadInJoyBaseListView), 1200L);
    }
    for (;;)
    {
      snh.a(this.a, this.a.a.getLastVisiblePosition() + 1, snh.c());
      return;
      label122:
      this.a.a(paramReadInJoyBaseListView, snh.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sok
 * JD-Core Version:    0.7.0.1
 */