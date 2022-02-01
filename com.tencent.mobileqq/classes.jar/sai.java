import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class sai
  implements DialogInterface.OnDismissListener
{
  sai(sab paramsab) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    sab.a(this.a, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    if ((sab.a(this.a) != null) && (sab.a(this.a).b()) && (sab.b(this.a)) && (!sab.c(this.a)) && (sab.a(this.a)) && (!sab.d(this.a))) {
      sab.a(this.a).c();
    }
    if (sab.a(this.a) != null) {
      sab.a(this.a).f();
    }
    sab.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sai
 * JD-Core Version:    0.7.0.1
 */