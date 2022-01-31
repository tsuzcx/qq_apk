import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.util.ProfilePerformanceReport;

public class snp
  implements OnDrawCompleteListener
{
  public snp(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void a()
  {
    ProfilePerformanceReport localProfilePerformanceReport = ProfilePerformanceReport.a;
    if ((localProfilePerformanceReport != null) && (localProfilePerformanceReport.a()))
    {
      if (!localProfilePerformanceReport.a(1)) {
        localProfilePerformanceReport.b(1);
      }
      if ((!localProfilePerformanceReport.a(8)) && (localProfilePerformanceReport.a(5)) && (localProfilePerformanceReport.a(7))) {
        localProfilePerformanceReport.b(8);
      }
      if ((!localProfilePerformanceReport.a(9)) && (localProfilePerformanceReport.a(6)) && (localProfilePerformanceReport.a(7))) {
        localProfilePerformanceReport.b(9);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     snp
 * JD-Core Version:    0.7.0.1
 */