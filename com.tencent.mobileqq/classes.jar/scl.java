import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class scl
  implements DialogInterface.OnDismissListener
{
  scl(sce paramsce) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    sce.a(this.a, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    if ((sce.a(this.a) != null) && (sce.a(this.a).b()) && (sce.b(this.a)) && (!sce.c(this.a)) && (sce.a(this.a)) && (!sce.d(this.a))) {
      sce.a(this.a).c();
    }
    if (sce.a(this.a) != null) {
      sce.a(this.a).g();
    }
    sce.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     scl
 * JD-Core Version:    0.7.0.1
 */