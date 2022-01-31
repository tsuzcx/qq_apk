import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCClient;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager;

class mpc
  implements DialogInterface.OnClickListener
{
  mpc(mpb parammpb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("VALUE_IS_CONFIRM_IN_XG", true);
    FastWebVideoFeedsPlayManager.a(this.a.a).a("CMD_COMFIRM_VIDEO_PLAY_NEED_ALERT_IN_XG", localBundle);
    if (!this.a.a.c()) {
      FastWebVideoFeedsPlayManager.c(this.a.a);
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mpc
 * JD-Core Version:    0.7.0.1
 */