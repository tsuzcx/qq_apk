import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.model.DiscoverManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.HotTopicInfoItem;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.ActivityCardInfo;
import com.tencent.biz.qqstory.storyHome.discover.view.DiscoverPresenter;
import com.tencent.biz.qqstory.storyHome.discover.view.DiscoverPresenter.TopicInfoUpdateEvent;
import com.tencent.biz.qqstory.storyHome.discover.view.IDiscoverView;
import java.util.ArrayList;
import java.util.Iterator;

public class nuq
  extends UIBaseEventReceiver
{
  public nuq(DiscoverPresenter paramDiscoverPresenter)
  {
    super(paramDiscoverPresenter);
  }
  
  public void a(@NonNull DiscoverPresenter paramDiscoverPresenter, @NonNull DiscoverPresenter.TopicInfoUpdateEvent paramTopicInfoUpdateEvent)
  {
    Iterator localIterator = DiscoverPresenter.a(paramDiscoverPresenter).iterator();
    while (localIterator.hasNext())
    {
      CardItem localCardItem = (CardItem)localIterator.next();
      if ((localCardItem.gatherCardInfo != null) && (localCardItem.gatherCardInfo.a() == paramTopicInfoUpdateEvent.a.mTopicId))
      {
        localCardItem.gatherCardInfo.a(paramTopicInfoUpdateEvent.a.mJoinCount);
        DiscoverPresenter.a(paramDiscoverPresenter).a(localCardItem);
        if (!"share_to_discover_fake_item".equals(localCardItem.cardId)) {
          ((DiscoverManager)SuperManager.a(22)).a(localCardItem);
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return DiscoverPresenter.TopicInfoUpdateEvent.class;
  }
  
  public void b(@NonNull DiscoverPresenter paramDiscoverPresenter, @NonNull DiscoverPresenter.TopicInfoUpdateEvent paramTopicInfoUpdateEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nuq
 * JD-Core Version:    0.7.0.1
 */