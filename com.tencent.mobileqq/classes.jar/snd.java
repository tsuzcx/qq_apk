import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class snd
  implements DialogInterface.OnShowListener
{
  snd(sna paramsna) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    smg.a(this.a.a, "mDisLikeActionSheet onShow() on VideoFeedsPlayActivity");
    smg.a(this.a.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     snd
 * JD-Core Version:    0.7.0.1
 */