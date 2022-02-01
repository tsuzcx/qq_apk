import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;

public class rak
  implements DialogInterface.OnDismissListener
{
  public rak(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (ReadInJoyDeliverUGCActivity.c(this.a))
    {
      ReadInJoyDeliverUGCActivity.c(this.a, false);
      ReadInJoyDeliverUGCActivity.e(this.a);
      if (!ReadInJoyDeliverUGCActivity.g(this.a)) {
        ReadInJoyDeliverUGCActivity.g(this.a, 1, this.a.getString(2131717105));
      }
      if (ReadInJoyDeliverUGCActivity.a(this.a) != null) {
        ReadInJoyDeliverUGCActivity.a(this.a).removeCallbacksAndMessages(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rak
 * JD-Core Version:    0.7.0.1
 */