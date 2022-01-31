import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class svz
  implements Runnable
{
  svz(svy paramsvy) {}
  
  public void run()
  {
    Object localObject = (FriendsManager)this.a.a.app.getManager(50);
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((FriendsManager)localObject).c(this.a.a.a.a.a);
    } while ((localObject == null) || ((((Friends)localObject).abilityBits & 0x2) == 0L));
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "mReportPCCameraAblibityRunnable-->report");
    }
    ReportController.b(null, "CliOper", "", "", "0X8004991", "0X8004991", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     svz
 * JD-Core Version:    0.7.0.1
 */