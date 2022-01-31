import com.tencent.biz.qqstory.comment.FeedLikeLego;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

public class nfz
  implements Runnable
{
  public nfz(FeedLikeLego paramFeedLikeLego, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeLego.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeLego.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeLego.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount > 0)
    {
      CommentLikeFeedItem localCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeLego.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
      localCommentLikeFeedItem.mLikeCount -= 1;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeLego.jdField_a_of_type_JavaUtilList.size())
    {
      if (((LikeEntry)this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeLego.jdField_a_of_type_JavaUtilList.get(i)).unionId.equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeLego.jdField_a_of_type_ComTencentBizQqstoryModelLikeManager.b((LikeEntry)this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeLego.jdField_a_of_type_JavaUtilList.get(i));
        this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeLego.jdField_a_of_type_JavaUtilList.remove(i);
      }
      i += 1;
    }
    ThreadManager.getUIHandler().post(new nga(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfz
 * JD-Core Version:    0.7.0.1
 */