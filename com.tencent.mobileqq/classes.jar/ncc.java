import com.tencent.biz.qqstory.comment.FeedLikeLego;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

public class ncc
  implements Runnable
{
  public ncc(FeedLikeLego paramFeedLikeLego, UserManager paramUserManager, String paramString, LikeEntry paramLikeEntry) {}
  
  public void run()
  {
    QQUserUIItem localQQUserUIItem = this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager.b(this.jdField_a_of_type_JavaLangString);
    LikeEntry localLikeEntry;
    if (localQQUserUIItem != null)
    {
      localLikeEntry = this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry;
      if (!localQQUserUIItem.isVip) {
        break label104;
      }
    }
    label104:
    for (long l = 2L;; l = 0L)
    {
      localLikeEntry.role = l;
      this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeLego.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry);
      this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeLego.jdField_a_of_type_ComTencentBizQqstoryModelLikeManager.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLikeEntry);
      this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeLego.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedManager.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeLego.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      ThreadManager.getUIHandler().post(new ncd(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ncc
 * JD-Core Version:    0.7.0.1
 */