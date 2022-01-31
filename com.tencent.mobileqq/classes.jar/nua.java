import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.GetLikeListEvent;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter;
import com.tencent.biz.qqstory.support.logging.SLog;

public class nua
  extends UIBaseEventReceiver
{
  public nua(StoryDetailPresenter paramStoryDetailPresenter)
  {
    super(paramStoryDetailPresenter);
  }
  
  public void a(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull DetailLikeListLoader.GetLikeListEvent paramGetLikeListEvent)
  {
    if ((!paramGetLikeListEvent.jdField_a_of_type_Boolean) || (!paramGetLikeListEvent.jdField_a_of_type_JavaLangString.equals(StoryDetailPresenter.a(paramStoryDetailPresenter))) || (paramGetLikeListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (StoryDetailPresenter.a(paramStoryDetailPresenter) == null))
    {
      SLog.b(this.TAG, "ignore this like list event. %s.", paramGetLikeListEvent.toString());
      return;
    }
    SLog.a(this.TAG, "receive like list event. %s.", paramGetLikeListEvent.toString());
    boolean bool2 = StoryDetailPresenter.a(paramStoryDetailPresenter);
    if (paramGetLikeListEvent.jdField_a_of_type_Int == 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      StoryDetailPresenter.a(paramStoryDetailPresenter).b(bool1, paramGetLikeListEvent.b);
      StoryDetailPresenter.a(paramStoryDetailPresenter).b(paramGetLikeListEvent.jdField_a_of_type_JavaUtilList, true, bool1);
      if (bool2 != bool1) {
        break;
      }
      paramStoryDetailPresenter.a();
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return DetailLikeListLoader.GetLikeListEvent.class;
  }
  
  public void b(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull DetailLikeListLoader.GetLikeListEvent paramGetLikeListEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nua
 * JD-Core Version:    0.7.0.1
 */