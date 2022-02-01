import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class smh
  implements DialogInterface.OnDismissListener
{
  smh(smg paramsmg) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a;
    StringBuilder localStringBuilder = new StringBuilder().append("DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    if (!smg.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      smg.a(paramDialogInterface, bool);
      if ((smg.a(this.a) != null) && (smg.a(this.a).b()) && (smg.b(this.a)) && (smg.a(this.a))) {
        smg.a(this.a).c();
      }
      if (smg.a(this.a) != null) {
        smg.a(this.a).f();
      }
      smg.a(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     smh
 * JD-Core Version:    0.7.0.1
 */