import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class mey
  implements DialogInterface.OnShowListener
{
  public mey(VideoFeedsAdapter paramVideoFeedsAdapter) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "mDisLikeActionSheet onShow() on VideoFeedsPlayActivity");
    }
    VideoFeedsAdapter.b(this.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mey
 * JD-Core Version:    0.7.0.1
 */