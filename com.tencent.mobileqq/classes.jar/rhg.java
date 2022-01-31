import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class rhg
  implements DialogInterface.OnDismissListener
{
  rhg(rhf paramrhf) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a;
    StringBuilder localStringBuilder = new StringBuilder().append("DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    if (!rhf.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      rhf.a(paramDialogInterface, bool);
      if ((rhf.a(this.a) != null) && (rhf.a(this.a).b()) && (rhf.b(this.a)) && (rhf.a(this.a))) {
        rhf.a(this.a).c();
      }
      if (rhf.a(this.a) != null) {
        rhf.a(this.a).g();
      }
      rhf.a(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rhg
 * JD-Core Version:    0.7.0.1
 */