import com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedData;
import java.util.List;

public class nxj
  implements Runnable
{
  public nxj(ProfileFeedPresenter paramProfileFeedPresenter, HomeFeedData paramHomeFeedData) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedData.d)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedData);
      return;
    }
    ProfileFeedPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedData);
    ProfileFeedPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter).remove(ProfileFeedPresenter.a());
    ProfileFeedPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxj
 * JD-Core Version:    0.7.0.1
 */