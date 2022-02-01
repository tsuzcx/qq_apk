import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCPUMonitor.1.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public final class rvz
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d(rvy.a(), 2, "Intent.ACTION_SCREEN_OFF");
      }
      if ((rvy.a().get() == 0) && (rvy.b().get() < rvy.a()))
      {
        rvy.a(new Thread(new VideoFeedsCPUMonitor.1.1(this)));
        rvy.a().set(1);
        rvy.a().start();
      }
    }
    do
    {
      do
      {
        return;
      } while (!"android.intent.action.SCREEN_ON".equals(paramContext));
      if (QLog.isColorLevel()) {
        QLog.d(rvy.a(), 2, "Intent.ACTION_SCREEN_ON");
      }
    } while (rvy.a().get() != 1);
    if ((rvy.a() != null) && (rvy.a().isAlive())) {
      rvy.a().interrupt();
    }
    rvy.a().set(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvz
 * JD-Core Version:    0.7.0.1
 */