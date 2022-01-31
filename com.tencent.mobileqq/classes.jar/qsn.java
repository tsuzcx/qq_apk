import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class qsn
  implements DialogInterface.OnShowListener
{
  qsn(qsk paramqsk) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    qrw.a(this.a.a, "mDisLikeActionSheet onShow() on VideoFeedsPlayActivity");
    qrw.a(this.a.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsn
 * JD-Core Version:    0.7.0.1
 */