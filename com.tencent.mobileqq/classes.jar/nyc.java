import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep.Response;
import com.tencent.biz.qqstory.support.logging.SLog;

public class nyc
  implements Runnable
{
  public nyc(GetUserSelfInfoStep paramGetUserSelfInfoStep, GetUserSelfInfoStep.Response paramResponse) {}
  
  public void run()
  {
    boolean bool = true;
    SLog.a("Q.qqstory.home.GetUserSelfInfoStep", "receive the user self info: %s", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep$Response);
    Object localObject = GetUserSelfInfoStep.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep).a();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep$Response.jdField_b_of_type_Int == 1) {}
    for (;;)
    {
      ((MyStorys)localObject).jdField_c_of_type_Boolean = bool;
      GetUserSelfInfoStep.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep).a().jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep$Response.jdField_c_of_type_Int;
      GetUserSelfInfoStep.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep).a().jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep$Response.jdField_d_of_type_Int;
      GetUserSelfInfoStep.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep).a().a = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep$Response.e;
      GetUserSelfInfoStep.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep).a().jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep$Response.jdField_c_of_type_JavaLangString;
      GetUserSelfInfoStep.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep).a().jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep$Response.jdField_d_of_type_JavaLangString;
      GetUserSelfInfoStep.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep).a().jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep$Response.a;
      localObject = (StoryConfigManager)SuperManager.a(10);
      ((StoryConfigManager)localObject).b("qqstory_my_fans_count", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep$Response.jdField_c_of_type_Int));
      ((StoryConfigManager)localObject).b("qqstory_i_am_vip", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep$Response.jdField_b_of_type_Int));
      ((StoryConfigManager)localObject).b("qqstory_my_vidoe_count", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep$Response.jdField_d_of_type_Int));
      ((StoryConfigManager)localObject).b("qqstory_my_visiter_count", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep$Response.e));
      ((StoryConfigManager)localObject).b("qqstory_my_newest_video_cover", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep$Response.jdField_c_of_type_JavaLangString);
      ((StoryConfigManager)localObject).b("qqstory_my_newest_video_vid", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep$Response.jdField_d_of_type_JavaLangString);
      QQStoryContext.a().a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep$Response.a);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestGetUserSelfInfoStep.d();
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nyc
 * JD-Core Version:    0.7.0.1
 */