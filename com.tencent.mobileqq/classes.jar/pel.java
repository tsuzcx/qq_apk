import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;

public class pel
{
  public static void a()
  {
    pep.a.a();
  }
  
  private static void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    String str = pds.a().a("3978");
    localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.AppName", "daily_feeds");
    pdu.a().getClass();
    localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.AppPath", str);
    QLog.i("PTSHelper", 1, "[jumpToPTSDailyPage], dailyAppPath = " + str);
    PublicFragmentActivity.a(paramContext, localIntent, PTSFragment.class);
  }
  
  public static boolean a(Context paramContext)
  {
    if (!pep.a.a()) {}
    while ((!pdu.a().a()) || (!pds.a().a("daily_feeds"))) {
      return false;
    }
    a(paramContext);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pel
 * JD-Core Version:    0.7.0.1
 */