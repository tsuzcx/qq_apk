import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;

public class mgr
  implements Runnable
{
  public mgr(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void run()
  {
    VideoFeedsPlayActivity.c(this.a).setVisibility(8);
    VideoFeedsPlayActivity.c(this.a).findViewById(2131365659).setVisibility(8);
    VideoFeedsPlayActivity.c(this.a).findViewById(2131365593).setVisibility(8);
    VideoFeedsPlayActivity.c(this.a).findViewById(2131365594).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mgr
 * JD-Core Version:    0.7.0.1
 */