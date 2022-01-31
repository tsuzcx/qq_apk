import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;

public class pqf
{
  public static void a()
  {
    pqj.a.a();
  }
  
  private static void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    String str = ppk.a().a("3978");
    localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.AppName", "daily_feeds");
    ppm.a().getClass();
    localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.AppPath", str);
    QLog.i("PTSHelper", 1, "[jumpToPTSDailyPage], dailyAppPath = " + str);
    PublicFragmentActivity.a(paramContext, localIntent, PTSFragment.class);
  }
  
  public static boolean a(Context paramContext)
  {
    if (!pqj.a.b()) {}
    do
    {
      return false;
      int i = oox.b();
      if (!oox.a(i))
      {
        QLog.i("PTSHelper", 1, "[isAbleToJumpNewPTSDailyPage], it is not normal daily channel, channelID = " + i);
        return false;
      }
    } while ((!ppm.a().a()) || (!ppk.a().a("daily_feeds")));
    a(paramContext);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pqf
 * JD-Core Version:    0.7.0.1
 */