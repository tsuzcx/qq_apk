import android.os.Bundle;
import com.tencent.biz.qqstory.comment.FeedCommentEventHandler.PostCommentCallback;
import com.tencent.biz.qqstory.comment.FeedCommentLego;
import com.tencent.biz.qqstory.database.CommentEntry;

public class naj
  extends FeedCommentEventHandler.PostCommentCallback
{
  public naj(FeedCommentLego paramFeedCommentLego) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle, CommentEntry paramCommentEntry)
  {
    this.a.e();
    if (paramBoolean) {
      this.a.a(true, paramCommentEntry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     naj
 * JD-Core Version:    0.7.0.1
 */