import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class qgb
  implements DialogInterface.OnShowListener
{
  qgb(qfy paramqfy) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    qfy.a(this.a, "mDisLikeActionSheet onShow() on VideoFeedsPlayActivity");
    qfy.a(this.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qgb
 * JD-Core Version:    0.7.0.1
 */