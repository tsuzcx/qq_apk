import com.tencent.biz.qqstory.comment.FeedCommentLikeLego;
import com.tencent.biz.qqstory.newshare.callback.OnSimpleShareListener;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class nap
  extends OnSimpleShareListener
{
  nap(nam paramnam) {}
  
  public void a()
  {
    super.a();
    FeedCommentLikeLego.a(this.a.a, null);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    StoryReportor.a("home_page", "suc_share", 1, paramInt, new String[] { StoryReportor.b(this.a.a.a) + "", StoryReportor.a(this.a.a.a) + "", this.a.a.a.feedId });
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    StoryReportor.a("home_page", "share_chanel", 1, paramInt, new String[] { StoryReportor.b(this.a.a.a) + "", StoryReportor.a(this.a.a.a) + "", this.a.a.a.feedId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nap
 * JD-Core Version:    0.7.0.1
 */