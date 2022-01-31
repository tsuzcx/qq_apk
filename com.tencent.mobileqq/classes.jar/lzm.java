import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.qphone.base.util.QLog;

public class lzm
  implements DialogInterface.OnDismissListener
{
  public lzm(VideoFeedsAdapter paramVideoFeedsAdapter) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    }
    if ((VideoFeedsAdapter.a(this.a) != null) && (VideoFeedsAdapter.a(this.a).b()) && (VideoFeedsAdapter.g(this.a)) && (VideoFeedsAdapter.h(this.a))) {
      VideoFeedsAdapter.a(this.a).d();
    }
    VideoFeedsAdapter.a(this.a).setNeedDetectScreenOrientation(true);
    VideoFeedsAdapter.e(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lzm
 * JD-Core Version:    0.7.0.1
 */