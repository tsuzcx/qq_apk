import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class rta
  implements DialogInterface.OnShowListener
{
  rta(rsx paramrsx) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    rsx.a(this.a, "mDisLikeActionSheet onShow() on VideoFeedsPlayActivity");
    rsx.a(this.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rta
 * JD-Core Version:    0.7.0.1
 */