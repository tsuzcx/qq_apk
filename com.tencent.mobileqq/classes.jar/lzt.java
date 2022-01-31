import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class lzt
  implements View.OnClickListener
{
  public lzt(VideoFeedsAdapter paramVideoFeedsAdapter) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "mShareActionSheet cancle button OnClick");
    }
    if (VideoFeedsAdapter.a(this.a).isShowing()) {
      VideoFeedsAdapter.a(this.a).dismiss();
    }
    if (VideoFeedsAdapter.a(this.a) != null) {
      VideoFeedsAdapter.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lzt
 * JD-Core Version:    0.7.0.1
 */