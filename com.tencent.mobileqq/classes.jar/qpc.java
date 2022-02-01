import android.content.Context;
import android.content.Intent;
import android.os.HandlerThread;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment;
import com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSNodeGif;
import com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSNodeImage;
import com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSNodeRIJAvatar;
import com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSNodeVideo;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSReportUtil;
import com.tencent.qphone.base.util.QLog;

public class qpc
{
  public static void a()
  {
    qpo.a.a();
    qph.a().a();
  }
  
  private static void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    String str = qog.a().a("3978");
    localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.PageName", "daily_feeds");
    qoi.a().getClass();
    localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.PagePath", str);
    QLog.i("PTSHelper", 1, "[jumpToPTSDailyPage], dailyAppPath = " + str);
    PublicFragmentActivity.a(paramContext, localIntent, PTSFragment.class);
  }
  
  public static boolean a(Context paramContext)
  {
    if (!qpo.a.b()) {}
    do
    {
      return false;
      int i = pil.b();
      if (!pil.a(i))
      {
        QLog.i("PTSHelper", 1, "[isAbleToJumpNewPTSDailyPage], it is not normal daily channel, channelID = " + i);
        return false;
      }
    } while ((!qoi.a().a()) || (!qog.a().a("daily_feeds")));
    a(paramContext);
    return true;
  }
  
  public static void b()
  {
    PTSLog.registerLogger(new qpi());
    d();
    if (bgjq.b())
    {
      PTSDeviceUtil.setTextHeightOffsetPerLine(0.1176471F);
      PTSDeviceUtil.setTextWidthOffsetPerLength(0.02941177F);
    }
    PTSNodeFactory.registerNodeVirtual("img", PTSNodeImage.class);
    PTSNodeFactory.registerCustomViewNodeVirtual("view", "qq-rij-video", PTSNodeVideo.class);
    PTSNodeFactory.registerCustomViewNodeVirtual("view", "qq-rij-gif", PTSNodeGif.class);
    PTSNodeFactory.registerCustomViewNodeVirtual("view", "rij-avatar-view", PTSNodeRIJAvatar.class);
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("readinjoy-common-pts-sub", 0);
    localHandlerThread.start();
    PTSThreadUtil.registerSubHandlerThread(localHandlerThread);
  }
  
  static void c() {}
  
  private static void d()
  {
    PTSReportUtil.registerPtsReport(new qpd());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qpc
 * JD-Core Version:    0.7.0.1
 */