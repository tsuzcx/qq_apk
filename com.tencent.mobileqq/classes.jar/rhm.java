import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class rhm
  implements DialogInterface.OnDismissListener
{
  rhm(rhf paramrhf) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    rhf.a(this.a, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    if ((rhf.a(this.a) != null) && (rhf.a(this.a).b()) && (rhf.b(this.a)) && (!rhf.c(this.a)) && (rhf.a(this.a)) && (!rhf.d(this.a))) {
      rhf.a(this.a).c();
    }
    if (rhf.a(this.a) != null) {
      rhf.a(this.a).g();
    }
    rhf.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rhm
 * JD-Core Version:    0.7.0.1
 */