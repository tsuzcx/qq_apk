import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class sch
  implements DialogInterface.OnShowListener
{
  sch(sce paramsce) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    sce.a(this.a, "mDisLikeActionSheet onShow() on VideoFeedsPlayActivity");
    sce.a(this.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sch
 * JD-Core Version:    0.7.0.1
 */