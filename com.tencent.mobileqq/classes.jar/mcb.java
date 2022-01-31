import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;

public class mcb
  implements Runnable
{
  public mcb(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void run()
  {
    VideoFeedsPlayActivity.b(this.a).setVisibility(8);
    VideoFeedsPlayActivity.b(this.a).findViewById(2131365627).setVisibility(8);
    VideoFeedsPlayActivity.b(this.a).findViewById(2131365561).setVisibility(8);
    VideoFeedsPlayActivity.b(this.a).findViewById(2131365562).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mcb
 * JD-Core Version:    0.7.0.1
 */