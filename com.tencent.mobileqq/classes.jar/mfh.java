import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.FirstCommentEvent;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCommentManager;

public class mfh
  implements ReadInJoyCommentUtils.FirstCommentEvent
{
  public mfh(VideoFeedsCommentManager paramVideoFeedsCommentManager) {}
  
  public void a(int paramInt)
  {
    VideoFeedsCommentManager.a(this.a).e += paramInt;
    VideoFeedsCommentManager.a(this.a).b(VideoFeedsCommentManager.a(this.a).g);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.a(paramBoolean, false);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (VideoFeedsCommentManager.a(this.a) != null)
    {
      if (VideoFeedsCommentManager.a(this.a).a(VideoFeedsCommentManager.a(this.a)))
      {
        this.a.a(false, true);
        return;
      }
      this.a.a(false, false);
      return;
    }
    this.a.a(false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mfh
 * JD-Core Version:    0.7.0.1
 */