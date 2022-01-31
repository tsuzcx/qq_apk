import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseFragment;

public class nrx
  implements Runnable
{
  public nrx(QQStoryBaseFragment paramQQStoryBaseFragment) {}
  
  public void run()
  {
    ((UserManager)SuperManager.a(2)).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrx
 * JD-Core Version:    0.7.0.1
 */