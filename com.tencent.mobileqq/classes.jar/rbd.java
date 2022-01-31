import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.26.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;

public class rbd
  implements rbz
{
  rbd(rap paramrap) {}
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    rap.d(this.a, false);
    if (!rap.c(this.a)) {
      return;
    }
    rap.a(this.a, false);
    if ((this.a.a()) && (rap.a(this.a) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onDrawFinish checkplayable!");
      }
      if (!rap.a(this.a).b()) {
        break label122;
      }
      rap.a(this.a).postDelayed(new ReadInJoyBaseAdapter.26.1(this, paramReadInJoyBaseListView), 1200L);
    }
    for (;;)
    {
      rap.a(this.a, this.a.a.getLastVisiblePosition() + 1, rap.c());
      return;
      label122:
      this.a.a(paramReadInJoyBaseListView, rap.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rbd
 * JD-Core Version:    0.7.0.1
 */