import com.tencent.biz.qqstory.model.DiscoverManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.discover.model.DiscoverPagerLoader;
import com.tencent.biz.qqstory.storyHome.discover.view.DiscoverPresenter;

public class oam
  implements Runnable
{
  public oam(DiscoverPresenter paramDiscoverPresenter) {}
  
  public void run()
  {
    byte[] arrayOfByte = ((DiscoverManager)SuperManager.a(22)).a(DiscoverPresenter.a(this.a));
    if (arrayOfByte != null)
    {
      DiscoverPresenter.a(this.a, arrayOfByte);
      DiscoverPresenter.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oam
 * JD-Core Version:    0.7.0.1
 */