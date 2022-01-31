import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class qsk
  implements DialogInterface.OnShowListener
{
  qsk(qsh paramqsh) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    qrt.a(this.a.a, "mDisLikeActionSheet onShow() on VideoFeedsPlayActivity");
    qrt.a(this.a.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsk
 * JD-Core Version:    0.7.0.1
 */