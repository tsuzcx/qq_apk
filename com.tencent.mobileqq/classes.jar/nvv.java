import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.DiscoverManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.discover.model.DiscoverPagerLoader;
import com.tencent.biz.qqstory.storyHome.discover.model.DiscoverPagerLoader.GetDiscoverCardsEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.List;

public class nvv
  implements Runnable
{
  public nvv(DiscoverPagerLoader paramDiscoverPagerLoader) {}
  
  public void run()
  {
    ??? = ((DiscoverManager)SuperManager.a(22)).a(DiscoverPagerLoader.a(this.a), DiscoverPagerLoader.a(this.a));
    DiscoverPagerLoader.GetDiscoverCardsEvent localGetDiscoverCardsEvent = new DiscoverPagerLoader.GetDiscoverCardsEvent(new ErrorMessage(), DiscoverPagerLoader.a(this.a), DiscoverPagerLoader.a(this.a));
    localGetDiscoverCardsEvent.b = true;
    localGetDiscoverCardsEvent.jdField_a_of_type_JavaUtilList = ((List)???);
    localGetDiscoverCardsEvent.jdField_a_of_type_Boolean = true;
    synchronized (this.a)
    {
      if (!this.a.b)
      {
        Dispatchers.get().dispatch(localGetDiscoverCardsEvent);
        SLog.a("Q.qqstory.discover:DiscoverPagerLoader", "dispatch video list return from cache: %s", localGetDiscoverCardsEvent);
        return;
      }
      SLog.d("Q.qqstory.discover:DiscoverPagerLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nvv
 * JD-Core Version:    0.7.0.1
 */