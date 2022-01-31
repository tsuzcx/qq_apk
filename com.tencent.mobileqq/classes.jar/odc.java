import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;

public class odc
  implements Runnable
{
  public odc(FeedManager paramFeedManager) {}
  
  public void run()
  {
    if (FeedManager.a(this.a) == 0L)
    {
      SLog.d("Q.qqstory.home.position", "cache in use");
      return;
    }
    this.a.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache.a();
    }
    SLog.d("Q.qqstory.home.position", "release cache");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odc
 * JD-Core Version:    0.7.0.1
 */