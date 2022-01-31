import android.os.Bundle;
import com.tencent.biz.qqstory.comment.FeedCommentEventHandler;
import com.tencent.biz.qqstory.comment.FeedCommentEventHandler.OnActionSheetButtonClickListener;
import com.tencent.biz.qqstory.comment.FeedCommentEventHandler.PostCommentCallback;
import com.tencent.biz.qqstory.comment.FeedCommentLego;
import com.tencent.biz.qqstory.database.CommentEntry;

public class nbt
  extends FeedCommentEventHandler.PostCommentCallback
{
  public nbt(FeedCommentEventHandler.OnActionSheetButtonClickListener paramOnActionSheetButtonClickListener) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle, CommentEntry paramCommentEntry)
  {
    this.a.a.a.e();
    if (paramBoolean) {
      this.a.a.a.a(true, paramCommentEntry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbt
 * JD-Core Version:    0.7.0.1
 */