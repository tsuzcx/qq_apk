import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;

public class pqc
{
  public static void a()
  {
    pqg.a.a();
  }
  
  private static void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    String str = pph.a().a("3978");
    localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.AppName", "daily_feeds");
    ppj.a().getClass();
    localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.AppPath", str);
    QLog.i("PTSHelper", 1, "[jumpToPTSDailyPage], dailyAppPath = " + str);
    PublicFragmentActivity.a(paramContext, localIntent, PTSFragment.class);
  }
  
  public static boolean a(Context paramContext)
  {
    if (!pqg.a.b()) {}
    do
    {
      return false;
      int i = oou.b();
      if (!oou.a(i))
      {
        QLog.i("PTSHelper", 1, "[isAbleToJumpNewPTSDailyPage], it is not normal daily channel, channelID = " + i);
        return false;
      }
    } while ((!ppj.a().a()) || (!pph.a().a("daily_feeds")));
    a(paramContext);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pqc
 * JD-Core Version:    0.7.0.1
 */