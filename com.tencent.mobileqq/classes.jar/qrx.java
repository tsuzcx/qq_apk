import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class qrx
  implements DialogInterface.OnDismissListener
{
  qrx(qrw paramqrw) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a;
    StringBuilder localStringBuilder = new StringBuilder().append("DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    if (!qrw.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      qrw.a(paramDialogInterface, bool);
      if ((qrw.a(this.a) != null) && (qrw.a(this.a).b()) && (qrw.b(this.a)) && (qrw.a(this.a))) {
        qrw.a(this.a).c();
      }
      if (qrw.a(this.a) != null) {
        qrw.a(this.a).f();
      }
      qrw.a(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qrx
 * JD-Core Version:    0.7.0.1
 */