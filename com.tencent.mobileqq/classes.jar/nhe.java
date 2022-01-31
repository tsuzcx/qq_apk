import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import java.util.ArrayList;
import java.util.List;

public class nhe
  implements Runnable
{
  public nhe(UserManager paramUserManager) {}
  
  public void run()
  {
    this.a.a = false;
    if (!UserManager.a(this.a).isEmpty())
    {
      new GetUserInfoHandler().a(1, UserManager.a(this.a));
      UserManager.a(this.a, new ArrayList());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhe
 * JD-Core Version:    0.7.0.1
 */