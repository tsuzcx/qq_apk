import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class smm
  implements DialogInterface.OnCancelListener
{
  smm(smg paramsmg) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    smg.a(this.a, "mShareActionSheet cancle button OnClick");
    if (smg.a(this.a) != null) {
      smg.a(this.a).c();
    }
    paramDialogInterface = smg.a(this.a);
    smg.a(this.a, paramDialogInterface, String.valueOf(pkh.a()), paramDialogInterface.g, paramDialogInterface.a, paramDialogInterface.f, -1, -1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     smm
 * JD-Core Version:    0.7.0.1
 */