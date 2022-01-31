import android.content.Context;
import android.content.Intent;
import android.os.HandlerThread;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.utils.PTSLog;
import com.tencent.qphone.base.util.QLog;

public class pwt
{
  public static void a()
  {
    pxb.a.a();
    pwu.a().a();
  }
  
  private static void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    String str = pvw.a().a("3978");
    localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.AppName", "daily_feeds");
    pvy.a().getClass();
    localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.AppPath", str);
    QLog.i("PTSHelper", 1, "[jumpToPTSDailyPage], dailyAppPath = " + str);
    PublicFragmentActivity.a(paramContext, localIntent, PTSFragment.class);
  }
  
  public static boolean a(Context paramContext)
  {
    if (!pxb.a.b()) {}
    do
    {
      return false;
      int i = otf.b();
      if (!otf.a(i))
      {
        QLog.i("PTSHelper", 1, "[isAbleToJumpNewPTSDailyPage], it is not normal daily channel, channelID = " + i);
        return false;
      }
    } while ((!pvy.a().a()) || (!pvw.a().a("daily_feeds")));
    a(paramContext);
    return true;
  }
  
  public static void b()
  {
    PTSLog.registerLogger(new pwv());
    PTSNodeFactory.registerNodeBuilder("img", new pws());
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("readinjoy-common-pts-sub", 0);
    localHandlerThread.start();
    PTSThreadUtil.registerSubHandlerThread(localHandlerThread);
  }
  
  static void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pwt
 * JD-Core Version:    0.7.0.1
 */