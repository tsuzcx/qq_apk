import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCPUMonitor.1.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public final class qmw
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d(qmv.a(), 2, "Intent.ACTION_SCREEN_OFF");
      }
      if ((qmv.a().get() == 0) && (qmv.b().get() < qmv.a()))
      {
        qmv.a(new Thread(new VideoFeedsCPUMonitor.1.1(this)));
        qmv.a().set(1);
        qmv.a().start();
      }
    }
    do
    {
      do
      {
        return;
      } while (!"android.intent.action.SCREEN_ON".equals(paramContext));
      if (QLog.isColorLevel()) {
        QLog.d(qmv.a(), 2, "Intent.ACTION_SCREEN_ON");
      }
    } while (qmv.a().get() != 1);
    if ((qmv.a() != null) && (qmv.a().isAlive())) {
      qmv.a().interrupt();
    }
    qmv.a().set(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qmw
 * JD-Core Version:    0.7.0.1
 */