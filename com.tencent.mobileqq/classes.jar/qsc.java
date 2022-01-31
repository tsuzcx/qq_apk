import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class qsc
  implements DialogInterface.OnCancelListener
{
  qsc(qrw paramqrw) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    qrw.a(this.a, "mShareActionSheet cancle button OnClick");
    if (qrw.a(this.a) != null) {
      qrw.a(this.a).c();
    }
    paramDialogInterface = qrw.a(this.a);
    qrw.a(this.a, paramDialogInterface, paramDialogInterface.j, paramDialogInterface.g, paramDialogInterface.a, paramDialogInterface.f, -1, -1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsc
 * JD-Core Version:    0.7.0.1
 */