import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCPUMonitor.1.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public final class ryc
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d(ryb.a(), 2, "Intent.ACTION_SCREEN_OFF");
      }
      if ((ryb.a().get() == 0) && (ryb.b().get() < ryb.a()))
      {
        ryb.a(new Thread(new VideoFeedsCPUMonitor.1.1(this)));
        ryb.a().set(1);
        ryb.a().start();
      }
    }
    do
    {
      do
      {
        return;
      } while (!"android.intent.action.SCREEN_ON".equals(paramContext));
      if (QLog.isColorLevel()) {
        QLog.d(ryb.a(), 2, "Intent.ACTION_SCREEN_ON");
      }
    } while (ryb.a().get() != 1);
    if ((ryb.a() != null) && (ryb.a().isAlive())) {
      ryb.a().interrupt();
    }
    ryb.a().set(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ryc
 * JD-Core Version:    0.7.0.1
 */