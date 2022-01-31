import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class qsa
  implements DialogInterface.OnDismissListener
{
  qsa(qrt paramqrt) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    qrt.a(this.a, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    if ((qrt.a(this.a) != null) && (qrt.a(this.a).b()) && (qrt.b(this.a)) && (!qrt.c(this.a)) && (qrt.a(this.a)) && (!qrt.d(this.a))) {
      qrt.a(this.a).c();
    }
    if (qrt.a(this.a) != null) {
      qrt.a(this.a).f();
    }
    qrt.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsa
 * JD-Core Version:    0.7.0.1
 */