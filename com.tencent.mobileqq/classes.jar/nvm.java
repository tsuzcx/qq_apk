import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader.GetFeedCommentEvent;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter;
import com.tencent.biz.qqstory.support.logging.SLog;

public class nvm
  extends UIBaseEventReceiver
{
  public nvm(StoryDetailPresenter paramStoryDetailPresenter)
  {
    super(paramStoryDetailPresenter);
  }
  
  public void a(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull CommentListPageLoader.GetFeedCommentEvent paramGetFeedCommentEvent)
  {
    if ((!paramGetFeedCommentEvent.jdField_a_of_type_JavaLangString.equals(StoryDetailPresenter.a(paramStoryDetailPresenter))) || (paramGetFeedCommentEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (StoryDetailPresenter.a(paramStoryDetailPresenter) == null)) {
      SLog.b(this.TAG, "ignore this comment list event. %s.", paramGetFeedCommentEvent.toString());
    }
    boolean bool2;
    boolean bool1;
    do
    {
      return;
      SLog.a(this.TAG, "receive comment list event. %s.", paramGetFeedCommentEvent.toString());
      bool2 = StoryDetailPresenter.a(paramStoryDetailPresenter);
      bool1 = true;
      if (paramGetFeedCommentEvent.jdField_a_of_type_Int == 0) {
        bool1 = false;
      }
      StoryDetailPresenter.a(paramStoryDetailPresenter).a(bool1);
      StoryDetailPresenter.a(paramStoryDetailPresenter).a(bool1, paramGetFeedCommentEvent.b);
      StoryDetailPresenter.a(paramStoryDetailPresenter).a(bool1, paramGetFeedCommentEvent.jdField_a_of_type_Boolean);
      StoryDetailPresenter.a(paramStoryDetailPresenter).a(paramGetFeedCommentEvent.jdField_a_of_type_JavaUtilList, paramGetFeedCommentEvent.c, bool1);
    } while (bool2 != bool1);
    paramStoryDetailPresenter.b(paramGetFeedCommentEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return CommentListPageLoader.GetFeedCommentEvent.class;
  }
  
  public void b(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull CommentListPageLoader.GetFeedCommentEvent paramGetFeedCommentEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nvm
 * JD-Core Version:    0.7.0.1
 */