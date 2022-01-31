import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import java.util.Locale;

public class svd
  implements Runnable
{
  public svd(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    LocalRedTouchManager localLocalRedTouchManager;
    Object localObject1;
    if (this.a.a.a.a == 0)
    {
      localLocalRedTouchManager = (LocalRedTouchManager)this.a.app.getManager(159);
      i = localLocalRedTouchManager.a();
      localObject1 = null;
    }
    Object localObject2;
    switch (i)
    {
    default: 
      localObject2 = null;
      if (localObject1 != null)
      {
        ReportController.b(this.a.app, "dc00898", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
        ReportController.b(this.a.app, "dc00898", "", "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
      }
      localLocalRedTouchManager.a(true);
      if (ProfileCardUtil.b())
      {
        localObject2 = Locale.getDefault().getCountry();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = this.a.app;
        if (this.a.a.a.a != 0) {
          break label235;
        }
      }
      break;
    }
    label235:
    for (int i = 1;; i = 2)
    {
      ReportController.b((QQAppInterface)localObject2, "dc00898", "", "", "0X8008CA2", "0X8008CA2", i, 0, "", "", (String)localObject1, "");
      return;
      localObject1 = "0X8007394";
      localObject2 = "0X8007393";
      break;
      localObject1 = "0X8007399";
      localObject2 = "0X8007398";
      break;
      localObject1 = "0X80073B9";
      localObject2 = "0X80073BA";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     svd
 * JD-Core Version:    0.7.0.1
 */