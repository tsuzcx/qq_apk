import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class qrz
  implements DialogInterface.OnCancelListener
{
  qrz(qrt paramqrt) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    qrt.a(this.a, "mShareActionSheet cancle button OnClick");
    if (qrt.a(this.a) != null) {
      qrt.a(this.a).c();
    }
    paramDialogInterface = qrt.a(this.a);
    qrt.a(this.a, paramDialogInterface, paramDialogInterface.j, paramDialogInterface.g, paramDialogInterface.a, paramDialogInterface.f, -1, -1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qrz
 * JD-Core Version:    0.7.0.1
 */