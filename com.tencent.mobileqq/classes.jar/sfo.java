import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.37.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;

public class sfo
  implements sgm
{
  sfo(sel paramsel) {}
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    sel.d(this.a, false);
    if (!sel.c(this.a)) {
      return;
    }
    sel.a(this.a, false);
    if ((this.a.a()) && (sel.a(this.a) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onDrawFinish checkplayable!");
      }
      if (!sel.a(this.a).b()) {
        break label122;
      }
      sel.a(this.a).postDelayed(new ReadInJoyBaseAdapter.37.1(this, paramReadInJoyBaseListView), 1200L);
    }
    for (;;)
    {
      sel.a(this.a, this.a.a.getLastVisiblePosition() + 1, sel.c());
      return;
      label122:
      this.a.a(paramReadInJoyBaseListView, sel.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sfo
 * JD-Core Version:    0.7.0.1
 */