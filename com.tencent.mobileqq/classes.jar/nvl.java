import android.text.TextUtils;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.notification.StoryPushMsg;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter;
import com.tencent.biz.qqstory.support.logging.SLog;

public class nvl
  extends QQStoryObserver
{
  public nvl(StoryDetailPresenter paramStoryDetailPresenter) {}
  
  public void a(StoryPushMsg paramStoryPushMsg)
  {
    if ((!TextUtils.equals(StoryDetailPresenter.a(this.a), paramStoryPushMsg.d)) || (StoryDetailPresenter.a(this.a) == null))
    {
      SLog.a("Q.qqstory.detail.StoryDetailPresenter", "onPushMessage Push feed id = %s not equal to current feed %s, ignore!", paramStoryPushMsg.d, StoryDetailPresenter.a(this.a));
      return;
    }
    if ((paramStoryPushMsg.a == 15) || (paramStoryPushMsg.a == 19))
    {
      SLog.a("Q.qqstory.detail.StoryDetailPresenter", "Receive new comment PUSH: %s, refreshing comments......", paramStoryPushMsg);
      StoryDetailPresenter.a(this.a);
    }
    for (;;)
    {
      this.a.i();
      return;
      if ((paramStoryPushMsg.a == 14) || (paramStoryPushMsg.a == 16) || (paramStoryPushMsg.a == 18))
      {
        SLog.a("Q.qqstory.detail.StoryDetailPresenter", "Receive new like PUSH: %s, refreshing likes......", paramStoryPushMsg);
        StoryDetailPresenter.b(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nvl
 * JD-Core Version:    0.7.0.1
 */