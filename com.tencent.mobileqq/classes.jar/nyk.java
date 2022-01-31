import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.CommentListener;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.GetFeedCommentEvent;
import com.tencent.biz.qqstory.storyHome.model.FeedCommentSync;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import java.util.List;

class nyk
  implements CommentListPageLoader.CommentListener
{
  nyk(nyj paramnyj, JobContext paramJobContext, FeedCommentSync paramFeedCommentSync) {}
  
  public void a(CommentListPageLoader.GetFeedCommentEvent paramGetFeedCommentEvent)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      SLog.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment is cancel, feedId:%d", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync });
      return;
    }
    nyj.a(this.jdField_a_of_type_Nyj);
    SLog.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "on comment back loop count:%d, event:%s", Integer.valueOf(nyj.b(this.jdField_a_of_type_Nyj)), paramGetFeedCommentEvent);
    if (paramGetFeedCommentEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      nyj.a(this.jdField_a_of_type_Nyj).addAll(paramGetFeedCommentEvent.jdField_a_of_type_JavaUtilList);
      if ((!paramGetFeedCommentEvent.jdField_a_of_type_Boolean) && (nyj.b(this.jdField_a_of_type_Nyj) < 10))
      {
        SLog.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull next page, loop count:%d", Integer.valueOf(nyj.b(this.jdField_a_of_type_Nyj)));
        nyj.a(this.jdField_a_of_type_Nyj).c();
        return;
      }
      paramGetFeedCommentEvent.jdField_a_of_type_JavaUtilList = nyj.a(this.jdField_a_of_type_Nyj);
      SLog.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment end, comment count:%d", Integer.valueOf(nyj.a(this.jdField_a_of_type_Nyj).size()));
      nyj.a(this.jdField_a_of_type_Nyj, paramGetFeedCommentEvent);
      return;
    }
    paramGetFeedCommentEvent.jdField_a_of_type_JavaUtilList = nyj.a(this.jdField_a_of_type_Nyj);
    SLog.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment error, comment count:%d", Integer.valueOf(nyj.a(this.jdField_a_of_type_Nyj).size()));
    nyj.b(this.jdField_a_of_type_Nyj, paramGetFeedCommentEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nyk
 * JD-Core Version:    0.7.0.1
 */