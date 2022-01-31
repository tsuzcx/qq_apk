import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class rhl
  implements DialogInterface.OnCancelListener
{
  rhl(rhf paramrhf) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    rhf.a(this.a, "mShareActionSheet cancle button OnClick");
    if (rhf.a(this.a) != null) {
      rhf.a(this.a).c();
    }
    paramDialogInterface = rhf.a(this.a);
    rhf.a(this.a, paramDialogInterface, paramDialogInterface.j, paramDialogInterface.g, paramDialogInterface.a, paramDialogInterface.f, -1, -1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rhl
 * JD-Core Version:    0.7.0.1
 */