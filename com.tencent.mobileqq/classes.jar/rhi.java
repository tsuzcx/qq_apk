import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class rhi
  implements DialogInterface.OnShowListener
{
  rhi(rhf paramrhf) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    rhf.a(this.a, "mDisLikeActionSheet onShow() on VideoFeedsPlayActivity");
    rhf.a(this.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rhi
 * JD-Core Version:    0.7.0.1
 */