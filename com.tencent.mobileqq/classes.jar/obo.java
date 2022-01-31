import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetYearNodeListReceiver;

public class obo
  implements Runnable
{
  public obo(MemoriesProfilePresenter.GetYearNodeListReceiver paramGetYearNodeListReceiver, MemoriesProfilePresenter paramMemoriesProfilePresenter) {}
  
  public void run()
  {
    ((UserManager)SuperManager.a(2)).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obo
 * JD-Core Version:    0.7.0.1
 */