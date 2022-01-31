import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.CommentListener;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.GetFeedCommentEvent;
import com.tencent.biz.qqstory.storyHome.model.FeedCommentSync;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import java.util.List;

class ocz
  implements CommentListPageLoader.CommentListener
{
  ocz(ocy paramocy, JobContext paramJobContext, FeedCommentSync paramFeedCommentSync) {}
  
  public void a(CommentListPageLoader.GetFeedCommentEvent paramGetFeedCommentEvent)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      SLog.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment is cancel, feedId:%d", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync });
      return;
    }
    ocy.a(this.jdField_a_of_type_Ocy);
    SLog.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "on comment back loop count:%d, event:%s", Integer.valueOf(ocy.b(this.jdField_a_of_type_Ocy)), paramGetFeedCommentEvent);
    if (paramGetFeedCommentEvent.errorInfo.isSuccess())
    {
      ocy.a(this.jdField_a_of_type_Ocy).addAll(paramGetFeedCommentEvent.jdField_a_of_type_JavaUtilList);
      if ((!paramGetFeedCommentEvent.jdField_a_of_type_Boolean) && (ocy.b(this.jdField_a_of_type_Ocy) < 10))
      {
        SLog.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull next page, loop count:%d", Integer.valueOf(ocy.b(this.jdField_a_of_type_Ocy)));
        ocy.a(this.jdField_a_of_type_Ocy).c();
        return;
      }
      paramGetFeedCommentEvent.jdField_a_of_type_JavaUtilList = ocy.a(this.jdField_a_of_type_Ocy);
      SLog.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment end, comment count:%d", Integer.valueOf(ocy.a(this.jdField_a_of_type_Ocy).size()));
      ocy.a(this.jdField_a_of_type_Ocy, paramGetFeedCommentEvent);
      return;
    }
    paramGetFeedCommentEvent.jdField_a_of_type_JavaUtilList = ocy.a(this.jdField_a_of_type_Ocy);
    SLog.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment error, comment count:%d", Integer.valueOf(ocy.a(this.jdField_a_of_type_Ocy).size()));
    ocy.b(this.jdField_a_of_type_Ocy, paramGetFeedCommentEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocz
 * JD-Core Version:    0.7.0.1
 */