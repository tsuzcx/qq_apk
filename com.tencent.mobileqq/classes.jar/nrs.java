import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;

public class nrs
  implements Runnable
{
  public nrs(QQStoryBaseActivity paramQQStoryBaseActivity) {}
  
  public void run()
  {
    ((UserManager)SuperManager.a(2)).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrs
 * JD-Core Version:    0.7.0.1
 */