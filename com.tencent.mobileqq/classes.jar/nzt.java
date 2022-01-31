import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStepExector.CompletedHandler;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter;
import com.tencent.biz.qqstory.support.logging.SLog;

public class nzt
  implements SimpleStepExector.CompletedHandler
{
  public nzt(StoryListPresenter paramStoryListPresenter) {}
  
  public void a()
  {
    SLog.d("Q.qqstory.home.StoryListPresenter", "ParallelStepExecutor finish requestAllDataFromNet steps");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzt
 * JD-Core Version:    0.7.0.1
 */