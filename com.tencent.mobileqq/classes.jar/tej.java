import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.mobileqq.activity.Now;

public class tej
  implements Runnable
{
  public tej(Now paramNow) {}
  
  public void run()
  {
    ((UserManager)SuperManager.a(2)).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tej
 * JD-Core Version:    0.7.0.1
 */