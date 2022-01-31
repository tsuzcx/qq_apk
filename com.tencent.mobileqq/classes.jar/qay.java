import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCPUMonitor.1.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public final class qay
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d(qax.a(), 2, "Intent.ACTION_SCREEN_OFF");
      }
      if ((qax.a().get() == 0) && (qax.b().get() < qax.a()))
      {
        qax.a(new Thread(new VideoFeedsCPUMonitor.1.1(this)));
        qax.a().set(1);
        qax.a().start();
      }
    }
    do
    {
      do
      {
        return;
      } while (!"android.intent.action.SCREEN_ON".equals(paramContext));
      if (QLog.isColorLevel()) {
        QLog.d(qax.a(), 2, "Intent.ACTION_SCREEN_ON");
      }
    } while (qax.a().get() != 1);
    if ((qax.a() != null) && (qax.a().isAlive())) {
      qax.a().interrupt();
    }
    qax.a().set(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qay
 * JD-Core Version:    0.7.0.1
 */