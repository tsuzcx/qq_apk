import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStepExector.ErrorHandler;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter;
import com.tencent.biz.qqstory.support.logging.SLog;

public class oej
  implements SimpleStepExector.ErrorHandler
{
  public oej(StoryListPresenter paramStoryListPresenter) {}
  
  public void a(ErrorMessage paramErrorMessage)
  {
    SLog.e("Q.qqstory.home.StoryListPresenter", "step %s error occur when requestAllDataFromNet error=%s", new Object[] { paramErrorMessage.extraMsg, paramErrorMessage.getErrorMessage() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oej
 * JD-Core Version:    0.7.0.1
 */