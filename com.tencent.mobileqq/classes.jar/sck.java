import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;

class sck
  implements DialogInterface.OnCancelListener
{
  sck(sce paramsce) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    sce.a(this.a, "mShareActionSheet cancle button OnClick");
    if (sce.a(this.a) != null) {
      sce.a(this.a).c();
    }
    paramDialogInterface = sce.a(this.a);
    sce.a(this.a, paramDialogInterface, String.valueOf(pha.a()), paramDialogInterface.g, paramDialogInterface.a, paramDialogInterface.f, -1, -1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sck
 * JD-Core Version:    0.7.0.1
 */