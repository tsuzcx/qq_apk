import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.DiscoverManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.NearbyCardInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.NormalCardInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.OperationCardInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.DiscoverPagerLoader;
import com.tencent.biz.qqstory.storyHome.discover.model.DiscoverPagerLoader.GetDiscoverCardsEvent;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.Iterator;
import java.util.List;

public class oal
  extends SimpleJob
{
  public oal(DiscoverPagerLoader paramDiscoverPagerLoader, DiscoverPagerLoader.GetDiscoverCardsEvent paramGetDiscoverCardsEvent, boolean paramBoolean) {}
  
  protected Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object[] paramArrayOfObject)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelDiscoverPagerLoader.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelDiscoverPagerLoader.b();
    ((DiscoverManager)SuperManager.a(22)).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelDiscoverPagerLoader$GetDiscoverCardsEvent.a, DiscoverPagerLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelDiscoverPagerLoader), DiscoverPagerLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelDiscoverPagerLoader), this.jdField_a_of_type_Boolean);
    paramJobContext = (UserManager)SuperManager.a(2);
    paramArrayOfObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelDiscoverPagerLoader$GetDiscoverCardsEvent.a.iterator();
    while (paramArrayOfObject.hasNext())
    {
      CardItem localCardItem = (CardItem)paramArrayOfObject.next();
      switch (localCardItem.cardType)
      {
      default: 
        break;
      case 1: 
        paramJobContext.a(localCardItem.normalCardInfo.a());
        break;
      case 2: 
        paramJobContext.a(localCardItem.nearByCardInfo.a());
        break;
      case 3: 
        paramJobContext.a(localCardItem.operationCardInfo.a());
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelDiscoverPagerLoader.a("Q.qqstory.discover:DiscoverPagerLoader");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oal
 * JD-Core Version:    0.7.0.1
 */