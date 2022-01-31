import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCPUMonitor.1.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public final class rbx
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d(rbw.a(), 2, "Intent.ACTION_SCREEN_OFF");
      }
      if ((rbw.a().get() == 0) && (rbw.b().get() < rbw.a()))
      {
        rbw.a(new Thread(new VideoFeedsCPUMonitor.1.1(this)));
        rbw.a().set(1);
        rbw.a().start();
      }
    }
    do
    {
      do
      {
        return;
      } while (!"android.intent.action.SCREEN_ON".equals(paramContext));
      if (QLog.isColorLevel()) {
        QLog.d(rbw.a(), 2, "Intent.ACTION_SCREEN_ON");
      }
    } while (rbw.a().get() != 1);
    if ((rbw.a() != null) && (rbw.a().isAlive())) {
      rbw.a().interrupt();
    }
    rbw.a().set(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rbx
 * JD-Core Version:    0.7.0.1
 */