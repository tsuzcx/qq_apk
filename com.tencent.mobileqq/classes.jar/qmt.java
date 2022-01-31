import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCPUMonitor.1.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public final class qmt
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d(qms.a(), 2, "Intent.ACTION_SCREEN_OFF");
      }
      if ((qms.a().get() == 0) && (qms.b().get() < qms.a()))
      {
        qms.a(new Thread(new VideoFeedsCPUMonitor.1.1(this)));
        qms.a().set(1);
        qms.a().start();
      }
    }
    do
    {
      do
      {
        return;
      } while (!"android.intent.action.SCREEN_ON".equals(paramContext));
      if (QLog.isColorLevel()) {
        QLog.d(qms.a(), 2, "Intent.ACTION_SCREEN_ON");
      }
    } while (qms.a().get() != 1);
    if ((qms.a() != null) && (qms.a().isAlive())) {
      qms.a().interrupt();
    }
    qms.a().set(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qmt
 * JD-Core Version:    0.7.0.1
 */