import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;

public class rtv
  implements DialogInterface.OnDismissListener
{
  public rtv(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (ReadInJoyDeliverUGCActivity.f(this.a))
    {
      ReadInJoyDeliverUGCActivity.e(this.a, false);
      ReadInJoyDeliverUGCActivity.e(this.a);
      if (!ReadInJoyDeliverUGCActivity.g(this.a)) {
        ReadInJoyDeliverUGCActivity.d(this.a, 1, this.a.getString(2131717708));
      }
      if (ReadInJoyDeliverUGCActivity.a(this.a) != null) {
        ReadInJoyDeliverUGCActivity.a(this.a).removeCallbacksAndMessages(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtv
 * JD-Core Version:    0.7.0.1
 */