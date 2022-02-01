import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class sac
  implements DialogInterface.OnDismissListener
{
  sac(sab paramsab) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a;
    StringBuilder localStringBuilder = new StringBuilder().append("DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    if (!sab.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      sab.a(paramDialogInterface, bool);
      if ((sab.a(this.a) != null) && (sab.a(this.a).b()) && (sab.b(this.a)) && (sab.a(this.a))) {
        sab.a(this.a).c();
      }
      if (sab.a(this.a) != null) {
        sab.a(this.a).f();
      }
      sab.a(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sac
 * JD-Core Version:    0.7.0.1
 */