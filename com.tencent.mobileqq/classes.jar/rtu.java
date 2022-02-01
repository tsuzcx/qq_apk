import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class rtu
  implements DialogInterface.OnShowListener
{
  rtu(rtr paramrtr) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    rsx.a(this.a.a, "mDisLikeActionSheet onShow() on VideoFeedsPlayActivity");
    rsx.a(this.a.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtu
 * JD-Core Version:    0.7.0.1
 */