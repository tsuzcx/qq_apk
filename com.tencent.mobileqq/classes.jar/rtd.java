import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class rtd
  implements DialogInterface.OnCancelListener
{
  rtd(rsx paramrsx) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    rsx.a(this.a, "mShareActionSheet cancle button OnClick");
    if (rsx.a(this.a) != null) {
      rsx.a(this.a).c();
    }
    paramDialogInterface = rsx.a(this.a);
    rsx.a(this.a, paramDialogInterface, String.valueOf(ozs.a()), paramDialogInterface.g, paramDialogInterface.a, paramDialogInterface.f, -1, -1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtd
 * JD-Core Version:    0.7.0.1
 */