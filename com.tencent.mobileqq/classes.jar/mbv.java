import android.view.View.OnSystemUiVisibilityChangeListener;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCommentManager;

public class mbv
  implements View.OnSystemUiVisibilityChangeListener
{
  public mbv(VideoFeedsCommentManager paramVideoFeedsCommentManager) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment;
    if (VideoFeedsCommentManager.a(this.a) != null)
    {
      localReadInJoyCommentListFragment = VideoFeedsCommentManager.a(this.a);
      if ((paramInt & 0x2) != 0) {
        break label32;
      }
    }
    label32:
    for (boolean bool = true;; bool = false)
    {
      localReadInJoyCommentListFragment.e_(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mbv
 * JD-Core Version:    0.7.0.1
 */