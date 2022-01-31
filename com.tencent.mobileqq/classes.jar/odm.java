import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.GetLikeListEvent;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.HomeFeedPresenterListener;
import com.tencent.biz.qqstory.support.logging.SLog;

public class odm
  extends UIBaseEventReceiver
{
  public odm(HomeFeedPresenter paramHomeFeedPresenter)
  {
    super(paramHomeFeedPresenter);
  }
  
  public void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull DetailLikeListLoader.GetLikeListEvent paramGetLikeListEvent)
  {
    Object localObject = paramHomeFeedPresenter.a(paramGetLikeListEvent.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (paramGetLikeListEvent.jdField_a_of_type_Boolean))
    {
      SLog.d(this.TAG, "is not my like, %s, isForDetail:%b", new Object[] { paramGetLikeListEvent.jdField_a_of_type_JavaLangString, Boolean.valueOf(paramGetLikeListEvent.jdField_a_of_type_Boolean) });
      return;
    }
    if (!(localObject instanceof CommentLikeHomeFeed))
    {
      SLog.e(this.TAG, "that is error type!");
      return;
    }
    localObject = (CommentLikeHomeFeed)localObject;
    ((CommentLikeFeedItem)((CommentLikeHomeFeed)localObject).a).mLikeCount = paramGetLikeListEvent.b;
    ((CommentLikeHomeFeed)localObject).b(paramGetLikeListEvent.jdField_a_of_type_JavaUtilList, true);
    HomeFeedPresenter.a(paramHomeFeedPresenter).b(paramGetLikeListEvent.jdField_a_of_type_JavaLangString);
  }
  
  public Class acceptEventClass()
  {
    return DetailLikeListLoader.GetLikeListEvent.class;
  }
  
  public void b(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull DetailLikeListLoader.GetLikeListEvent paramGetLikeListEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odm
 * JD-Core Version:    0.7.0.1
 */