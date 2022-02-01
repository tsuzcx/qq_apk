import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class scz
  implements DialogInterface.OnShowListener
{
  scz(scw paramscw) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    sce.a(this.a.a, "mDisLikeActionSheet onShow() on VideoFeedsPlayActivity");
    sce.a(this.a.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     scz
 * JD-Core Version:    0.7.0.1
 */