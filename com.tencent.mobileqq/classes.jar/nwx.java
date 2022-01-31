import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.CommentListener;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.GetFeedCommentEvent;
import com.tencent.biz.qqstory.storyHome.model.FeedCommentSync;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import java.util.List;

class nwx
  implements CommentListPageLoader.CommentListener
{
  nwx(nww paramnww, JobContext paramJobContext, FeedCommentSync paramFeedCommentSync) {}
  
  public void a(CommentListPageLoader.GetFeedCommentEvent paramGetFeedCommentEvent)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      SLog.d("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment is cancel, feedId:%d", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedCommentSync });
      return;
    }
    nww.a(this.jdField_a_of_type_Nww);
    SLog.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "on comment back loop count:%d, event:%s", Integer.valueOf(nww.b(this.jdField_a_of_type_Nww)), paramGetFeedCommentEvent);
    if (paramGetFeedCommentEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      nww.a(this.jdField_a_of_type_Nww).addAll(paramGetFeedCommentEvent.jdField_a_of_type_JavaUtilList);
      if ((!paramGetFeedCommentEvent.jdField_a_of_type_Boolean) && (nww.b(this.jdField_a_of_type_Nww) < 10))
      {
        SLog.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull next page, loop count:%d", Integer.valueOf(nww.b(this.jdField_a_of_type_Nww)));
        nww.a(this.jdField_a_of_type_Nww).c();
        return;
      }
      paramGetFeedCommentEvent.jdField_a_of_type_JavaUtilList = nww.a(this.jdField_a_of_type_Nww);
      SLog.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment end, comment count:%d", Integer.valueOf(nww.a(this.jdField_a_of_type_Nww).size()));
      nww.a(this.jdField_a_of_type_Nww, paramGetFeedCommentEvent);
      return;
    }
    paramGetFeedCommentEvent.jdField_a_of_type_JavaUtilList = nww.a(this.jdField_a_of_type_Nww);
    SLog.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "pull comment error, comment count:%d", Integer.valueOf(nww.a(this.jdField_a_of_type_Nww).size()));
    nww.b(this.jdField_a_of_type_Nww, paramGetFeedCommentEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwx
 * JD-Core Version:    0.7.0.1
 */