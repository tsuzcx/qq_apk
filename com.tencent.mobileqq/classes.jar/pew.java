import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.ReadInJoyCommentLikeView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class pew
  implements View.OnClickListener
{
  public pew(ReadInJoyCommentLikeView paramReadInJoyCommentLikeView) {}
  
  public void onClick(View paramView)
  {
    if (pha.l()) {}
    while (ReadInJoyCommentLikeView.a(this.a) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (ReadInJoyCommentLikeView.a(this.a).isLiked()) {
      if (ReadInJoyCommentLikeView.a(this.a) != null) {
        ReadInJoyCommentLikeView.a(this.a).a(ReadInJoyCommentLikeView.a(this.a).commentId, 0, 0);
      }
    }
    for (;;)
    {
      ReadInJoyCommentLikeView.a(this.a, ReadInJoyCommentLikeView.a(this.a));
      ReadInJoyCommentLikeView.a(this.a);
      break;
      if (ReadInJoyCommentLikeView.a(this.a) != null) {
        ReadInJoyCommentLikeView.a(this.a).a(ReadInJoyCommentLikeView.a(this.a).commentId, 1, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pew
 * JD-Core Version:    0.7.0.1
 */