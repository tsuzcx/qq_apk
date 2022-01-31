import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class qrz
  implements DialogInterface.OnShowListener
{
  qrz(qrw paramqrw) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    qrw.a(this.a, "mDisLikeActionSheet onShow() on VideoFeedsPlayActivity");
    qrw.a(this.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qrz
 * JD-Core Version:    0.7.0.1
 */