import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.LbsUpdateListener;
import com.tencent.biz.qqstory.storyHome.discover.model.DiscoverPagerLoader;
import com.tencent.biz.qqstory.storyHome.discover.view.DiscoverPresenter;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class nvy
  implements LbsManager.LbsUpdateListener
{
  public nvy(DiscoverPresenter paramDiscoverPresenter, LbsManager paramLbsManager) {}
  
  public void a(boolean paramBoolean, @Nullable BasicLocation paramBasicLocation)
  {
    SLog.e("Q.qqstory.discover.DiscoverPresenter", "lbs update %b %s", new Object[] { Boolean.valueOf(paramBoolean), paramBasicLocation });
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager.b(this);
    if (DiscoverPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewDiscoverPresenter).get())
    {
      SLog.d("Q.qqstory.discover.DiscoverPresenter", "is destroy");
      return;
    }
    DiscoverPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewDiscoverPresenter).a = paramBasicLocation;
    DiscoverPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewDiscoverPresenter).a(null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nvy
 * JD-Core Version:    0.7.0.1
 */