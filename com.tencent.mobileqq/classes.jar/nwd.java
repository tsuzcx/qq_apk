import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter;
import com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesProfileSegment;

public class nwd
  implements Runnable
{
  public nwd(MemoriesProfileSegment paramMemoriesProfileSegment) {}
  
  public void run()
  {
    ((UserManager)SuperManager.a(2)).a(MemoriesProfileSegment.a(this.a).a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwd
 * JD-Core Version:    0.7.0.1
 */