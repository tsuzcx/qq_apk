import com.tencent.biz.qqstory.storyHome.discover.view.DiscoverPresenter;
import com.tencent.biz.qqstory.storyHome.discover.view.QQStoryDiscoverFragment;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper.OnLoadMoreListener;

public class nur
  implements LoadingMoreHelper.OnLoadMoreListener
{
  public nur(QQStoryDiscoverFragment paramQQStoryDiscoverFragment) {}
  
  public void a() {}
  
  public boolean a(boolean paramBoolean)
  {
    QQStoryDiscoverFragment.a(this.a).c();
    StoryReportor.a("content_flow", "load_more", 0, 0, new String[0]);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nur
 * JD-Core Version:    0.7.0.1
 */