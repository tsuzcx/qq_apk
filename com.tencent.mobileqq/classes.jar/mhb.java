import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView.OnDrawCompleteListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;

public class mhb
  implements ReadInJoyBaseListView.OnDrawCompleteListener
{
  public mhb(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter) {}
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    ReadInJoyBaseAdapter.e(this.a, false);
    if (!ReadInJoyBaseAdapter.d(this.a)) {
      return;
    }
    ReadInJoyBaseAdapter.b(this.a, false);
    if ((this.a.a()) && (ReadInJoyBaseAdapter.a(this.a) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onDrawFinish checkplayable!");
      }
      if (!ReadInJoyBaseAdapter.a(this.a).b()) {
        break label122;
      }
      ReadInJoyBaseAdapter.a(this.a).postDelayed(new mhc(this, paramReadInJoyBaseListView), 1200L);
    }
    for (;;)
    {
      ReadInJoyBaseAdapter.a(this.a, this.a.a.getLastVisiblePosition() + 1, ReadInJoyBaseAdapter.b());
      return;
      label122:
      ReadInJoyBaseAdapter.a(this.a, paramReadInJoyBaseListView, ReadInJoyBaseAdapter.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mhb
 * JD-Core Version:    0.7.0.1
 */