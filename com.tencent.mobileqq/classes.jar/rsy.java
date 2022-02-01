import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class rsy
  implements DialogInterface.OnDismissListener
{
  rsy(rsx paramrsx) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a;
    StringBuilder localStringBuilder = new StringBuilder().append("DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    if (!rsx.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      rsx.a(paramDialogInterface, bool);
      if ((rsx.a(this.a) != null) && (rsx.a(this.a).b()) && (rsx.b(this.a)) && (rsx.a(this.a))) {
        rsx.a(this.a).c();
      }
      if (rsx.a(this.a) != null) {
        rsx.a(this.a).f();
      }
      rsx.a(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsy
 * JD-Core Version:    0.7.0.1
 */