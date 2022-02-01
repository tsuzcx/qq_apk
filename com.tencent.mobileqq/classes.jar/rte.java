import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class rte
  implements DialogInterface.OnDismissListener
{
  rte(rsx paramrsx) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    rsx.a(this.a, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    if ((rsx.a(this.a) != null) && (rsx.a(this.a).b()) && (rsx.b(this.a)) && (!rsx.c(this.a)) && (rsx.a(this.a)) && (!rsx.d(this.a))) {
      rsx.a(this.a).c();
    }
    if (rsx.a(this.a) != null) {
      rsx.a(this.a).f();
    }
    rsx.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rte
 * JD-Core Version:    0.7.0.1
 */