import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

public class tez
  implements Runnable
{
  public tez(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void run()
  {
    int i = ((FriendsManager)this.a.app.getManager(50)).c();
    Object localObject = (PhoneContactManagerImp)this.a.app.getManager(10);
    int j = ((PhoneContactManagerImp)localObject).c();
    if ((((PhoneContactManagerImp)localObject).c()) || (j == 8)) {
      i = ((PhoneContactManagerImp)localObject).a(false).size() + i;
    }
    for (;;)
    {
      if (i > 0) {}
      for (localObject = i + "人";; localObject = "暂无")
      {
        ThreadManager.getUIHandler().post(new tfa(this, (String)localObject));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tez
 * JD-Core Version:    0.7.0.1
 */