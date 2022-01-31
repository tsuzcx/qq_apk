import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.model.GeneralHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedData;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.HomeFeedPresenterListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Collections;

public class odj
  implements Runnable
{
  public odj(HomeFeedPresenter paramHomeFeedPresenter, HomeFeedData paramHomeFeedData) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedData.c) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedData.errorInfo.isSuccess())) {
      HomeFeedPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter).clear();
    }
    HomeFeedPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter).addAll(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedData.b);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter.a(HomeFeedPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter));
    Collections.sort(HomeFeedPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter), GeneralHomeFeed.a);
    HomeFeedPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedData.a);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedData.b = HomeFeedPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter);
    SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "had load feed size:%d, take time:%d", Integer.valueOf(HomeFeedPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter).size()), Long.valueOf(System.currentTimeMillis() - l));
    if (HomeFeedPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter) != null) {
      HomeFeedPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedPresenter).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odj
 * JD-Core Version:    0.7.0.1
 */