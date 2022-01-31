import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.GetFeedCommentEvent;
import com.tencent.biz.qqstory.storyHome.model.FeedCommentBackgroundSyncer.CommentPullConsumer;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.reactive.SimpleObserver;
import java.util.List;

public class ocx
  extends SimpleObserver
{
  public ocx(FeedCommentBackgroundSyncer.CommentPullConsumer paramCommentPullConsumer) {}
  
  public void a(CommentListPageLoader.GetFeedCommentEvent paramGetFeedCommentEvent)
  {
    super.onNext(paramGetFeedCommentEvent);
    if (paramGetFeedCommentEvent.errorInfo.isSuccess())
    {
      CommentManager localCommentManager = (CommentManager)SuperManager.a(17);
      localCommentManager.a(paramGetFeedCommentEvent.jdField_a_of_type_JavaUtilList, paramGetFeedCommentEvent.jdField_a_of_type_JavaLangString, false, false);
      paramGetFeedCommentEvent.jdField_a_of_type_JavaUtilList.addAll(localCommentManager.b(paramGetFeedCommentEvent.jdField_a_of_type_JavaLangString, false));
    }
    Dispatchers.get().dispatch(paramGetFeedCommentEvent);
    this.a.b();
    SLog.b("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull next");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.b();
    SLog.a("Q.qqstory.home.data.FeedCommentBackgroundSyncer", "comment pull error", paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocx
 * JD-Core Version:    0.7.0.1
 */