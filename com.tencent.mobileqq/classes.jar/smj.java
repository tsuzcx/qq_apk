import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class smj
  implements DialogInterface.OnShowListener
{
  smj(smg paramsmg) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    smg.a(this.a, "mDisLikeActionSheet onShow() on VideoFeedsPlayActivity");
    smg.a(this.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     smj
 * JD-Core Version:    0.7.0.1
 */