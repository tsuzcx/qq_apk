import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class qfz
  implements DialogInterface.OnDismissListener
{
  qfz(qfy paramqfy) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a;
    StringBuilder localStringBuilder = new StringBuilder().append("DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    if (!qfy.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      qfy.a(paramDialogInterface, bool);
      if ((qfy.a(this.a) != null) && (qfy.a(this.a).b()) && (qfy.b(this.a)) && (qfy.a(this.a))) {
        qfy.a(this.a).c();
      }
      if (qfy.a(this.a) != null) {
        qfy.a(this.a).f();
      }
      qfy.a(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qfz
 * JD-Core Version:    0.7.0.1
 */