import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class smn
  implements DialogInterface.OnDismissListener
{
  smn(smg paramsmg) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    smg.a(this.a, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    if ((smg.a(this.a) != null) && (smg.a(this.a).b()) && (smg.b(this.a)) && (!smg.c(this.a)) && (smg.a(this.a)) && (!smg.d(this.a))) {
      smg.a(this.a).c();
    }
    if (smg.a(this.a) != null) {
      smg.a(this.a).f();
    }
    smg.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     smn
 * JD-Core Version:    0.7.0.1
 */