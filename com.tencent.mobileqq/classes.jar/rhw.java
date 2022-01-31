import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class rhw
  implements DialogInterface.OnShowListener
{
  rhw(rht paramrht) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    rhf.a(this.a.a, "mDisLikeActionSheet onShow() on VideoFeedsPlayActivity");
    rhf.a(this.a.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rhw
 * JD-Core Version:    0.7.0.1
 */