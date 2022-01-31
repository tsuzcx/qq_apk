import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;

class sms
  implements Runnable
{
  sms(smr paramsmr) {}
  
  public void run()
  {
    try
    {
      if (!TextUtils.isEmpty(this.a.a.a.a.a))
      {
        Object localObject = this.a.a.a.a.a;
        if (this.a.a.a.a.a.startsWith("+")) {
          localObject = this.a.a.a.a.a.substring(1);
        }
        localObject = new LpReportInfo_pf00064(699, 3, Long.valueOf((String)localObject).longValue());
        LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, false);
      }
      return;
    }
    catch (Exception localException)
    {
      QZLog.e("QzoneReport", "makeOrRefreshQZone", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sms
 * JD-Core Version:    0.7.0.1
 */