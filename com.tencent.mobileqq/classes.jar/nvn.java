import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader.GetVideoListEvent;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public class nvn
  extends UIBaseEventReceiver
{
  public nvn(StoryDetailPresenter paramStoryDetailPresenter)
  {
    super(paramStoryDetailPresenter);
  }
  
  public void a(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent)
  {
    if ((!paramGetVideoListEvent.jdField_a_of_type_JavaLangString.equals(StoryDetailPresenter.a(paramStoryDetailPresenter))) || (paramGetVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) || (StoryDetailPresenter.a(paramStoryDetailPresenter) == null))
    {
      SLog.b(this.TAG, "ignore this comment list event. %s.", paramGetVideoListEvent.toString());
      return;
    }
    if (!StoryDetailPresenter.a(paramStoryDetailPresenter).c())
    {
      SLog.e(this.TAG, "this feed does not support video list. ignore this comment list event. %s.", new Object[] { paramGetVideoListEvent.toString() });
      return;
    }
    SLog.a(this.TAG, "receive comment list event. %s.", paramGetVideoListEvent.toString());
    StoryDetailPresenter.a(paramStoryDetailPresenter).a(paramGetVideoListEvent.jdField_a_of_type_JavaUtilList, paramGetVideoListEvent.c);
    StoryDetailPresenter.a(paramStoryDetailPresenter).a().updateVideoInfo(paramGetVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoInfo);
    if (StoryDetailPresenter.a(paramStoryDetailPresenter).a().size() < 1)
    {
      StoryDetailPresenter.a(paramStoryDetailPresenter).b();
      return;
    }
    paramStoryDetailPresenter.a();
  }
  
  public Class acceptEventClass()
  {
    return VideoListPageLoader.GetVideoListEvent.class;
  }
  
  public void b(@NonNull StoryDetailPresenter paramStoryDetailPresenter, @NonNull VideoListPageLoader.GetVideoListEvent paramGetVideoListEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nvn
 * JD-Core Version:    0.7.0.1
 */