import com.tencent.biz.qqstory.model.item.HotTopicInfoItem;
import com.tencent.biz.qqstory.storyHome.discover.view.DiscoverPresenter;
import com.tencent.biz.qqstory.storyHome.discover.view.IDiscoverView;
import com.tencent.biz.qqstory.support.logging.SLog;

public class nun
  implements Runnable
{
  public nun(DiscoverPresenter paramDiscoverPresenter, HotTopicInfoItem paramHotTopicInfoItem) {}
  
  public void run()
  {
    DiscoverPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewDiscoverPresenter).a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemHotTopicInfoItem);
    SLog.b("Q.qqstory.discover.DiscoverPresenter", "topic %d info %s", Long.valueOf(DiscoverPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewDiscoverPresenter)), this.jdField_a_of_type_ComTencentBizQqstoryModelItemHotTopicInfoItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nun
 * JD-Core Version:    0.7.0.1
 */