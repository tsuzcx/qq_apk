import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class qrw
  implements DialogInterface.OnShowListener
{
  qrw(qrt paramqrt) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    qrt.a(this.a, "mDisLikeActionSheet onShow() on VideoFeedsPlayActivity");
    qrt.a(this.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qrw
 * JD-Core Version:    0.7.0.1
 */