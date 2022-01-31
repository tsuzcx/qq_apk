import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class qge
  implements DialogInterface.OnCancelListener
{
  qge(qfy paramqfy) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    qfy.a(this.a, "mShareActionSheet cancle button OnClick");
    if (qfy.a(this.a) != null) {
      qfy.a(this.a).c();
    }
    paramDialogInterface = qfy.a(this.a);
    qfy.a(this.a, paramDialogInterface, paramDialogInterface.j, paramDialogInterface.g, paramDialogInterface.a, paramDialogInterface.f, -1, -1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qge
 * JD-Core Version:    0.7.0.1
 */