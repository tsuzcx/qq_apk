import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCPUMonitor.1.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public final class sia
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d(shz.a(), 2, "Intent.ACTION_SCREEN_OFF");
      }
      if ((shz.a().get() == 0) && (shz.b().get() < shz.a()))
      {
        shz.a(new Thread(new VideoFeedsCPUMonitor.1.1(this)));
        shz.a().set(1);
        shz.a().start();
      }
    }
    do
    {
      do
      {
        return;
      } while (!"android.intent.action.SCREEN_ON".equals(paramContext));
      if (QLog.isColorLevel()) {
        QLog.d(shz.a(), 2, "Intent.ACTION_SCREEN_ON");
      }
    } while (shz.a().get() != 1);
    if ((shz.a() != null) && (shz.a().isAlive())) {
      shz.a().interrupt();
    }
    shz.a().set(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sia
 * JD-Core Version:    0.7.0.1
 */