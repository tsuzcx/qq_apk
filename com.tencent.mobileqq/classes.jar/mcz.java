import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCommentManager.CommentEventListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;

public class mcz
  implements VideoFeedsCommentManager.CommentEventListener
{
  public mcz(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (VideoFeedsPlayActivity.h(this.a)))
    {
      VideoFeedsPlayActivity.a(this.a).postDelayed(new mda(this), 1000L);
      VideoFeedsPlayActivity.d(this.a, false);
    }
    if (!paramBoolean) {
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mcz
 * JD-Core Version:    0.7.0.1
 */