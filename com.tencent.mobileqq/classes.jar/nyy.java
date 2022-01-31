import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidPollDataResultReceiver;

public class nyy
  implements Runnable
{
  public nyy(HomeFeedPresenter.SendVidPollDataResultReceiver paramSendVidPollDataResultReceiver, CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry) {}
  
  public void run()
  {
    CommentManager localCommentManager = (CommentManager)SuperManager.a(17);
    if (HomeFeedPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.type = 3;
      localCommentManager.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    }
    for (;;)
    {
      ((FeedManager)SuperManager.a(11)).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      return;
      localCommentManager.c(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nyy
 * JD-Core Version:    0.7.0.1
 */