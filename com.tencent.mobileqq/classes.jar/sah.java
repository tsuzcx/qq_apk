import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class sah
  implements DialogInterface.OnCancelListener
{
  sah(sab paramsab) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    sab.a(this.a, "mShareActionSheet cancle button OnClick");
    if (sab.a(this.a) != null) {
      sab.a(this.a).c();
    }
    paramDialogInterface = sab.a(this.a);
    sab.a(this.a, paramDialogInterface, String.valueOf(pay.a()), paramDialogInterface.g, paramDialogInterface.a, paramDialogInterface.f, -1, -1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sah
 * JD-Core Version:    0.7.0.1
 */