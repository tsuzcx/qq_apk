import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.LbsUpdateListener;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class odi
  implements LbsManager.LbsUpdateListener
{
  public odi(HomeFeedPresenter paramHomeFeedPresenter, LbsManager paramLbsManager) {}
  
  public void a(boolean paramBoolean, @Nullable BasicLocation paramBasicLocation)
  {
    SLog.e("Q.qqstory.home.data.HomeFeedPresenter", "lbs update %b %s", new Object[] { Boolean.valueOf(paramBoolean), paramBasicLocation });
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager.b(this);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a.get())
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "is destroy");
      return;
    }
    HomeFeedPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter).a = paramBasicLocation;
    HomeFeedPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter).a(null, 0);
    ((FeedManager)SuperManager.a(11)).a = paramBasicLocation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odi
 * JD-Core Version:    0.7.0.1
 */