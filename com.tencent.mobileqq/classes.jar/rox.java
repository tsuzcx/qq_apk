import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCPUMonitor.1.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public final class rox
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d(row.a(), 2, "Intent.ACTION_SCREEN_OFF");
      }
      if ((row.a().get() == 0) && (row.b().get() < row.a()))
      {
        row.a(new Thread(new VideoFeedsCPUMonitor.1.1(this)));
        row.a().set(1);
        row.a().start();
      }
    }
    do
    {
      do
      {
        return;
      } while (!"android.intent.action.SCREEN_ON".equals(paramContext));
      if (QLog.isColorLevel()) {
        QLog.d(row.a(), 2, "Intent.ACTION_SCREEN_ON");
      }
    } while (row.a().get() != 1);
    if ((row.a() != null) && (row.a().isAlive())) {
      row.a().interrupt();
    }
    row.a().set(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rox
 * JD-Core Version:    0.7.0.1
 */