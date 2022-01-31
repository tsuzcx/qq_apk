import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class qsd
  implements DialogInterface.OnDismissListener
{
  qsd(qrw paramqrw) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    qrw.a(this.a, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    if ((qrw.a(this.a) != null) && (qrw.a(this.a).b()) && (qrw.b(this.a)) && (!qrw.c(this.a)) && (qrw.a(this.a)) && (!qrw.d(this.a))) {
      qrw.a(this.a).c();
    }
    if (qrw.a(this.a) != null) {
      qrw.a(this.a).f();
    }
    qrw.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsd
 * JD-Core Version:    0.7.0.1
 */