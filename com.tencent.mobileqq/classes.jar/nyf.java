import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.storyHome.QQStoryMainController;
import com.tencent.mobileqq.app.QQAppInterface;

public class nyf
  implements Runnable
{
  public nyf(QQStoryMainController paramQQStoryMainController) {}
  
  public void run()
  {
    ((QQStoryHandler)QQStoryContext.a().a(98)).a(2001, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nyf
 * JD-Core Version:    0.7.0.1
 */