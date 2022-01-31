package mqq.app;

import android.widget.Toast;
import com.tencent.qphone.base.remote.FromServiceMsg;

class MainService$1
  implements Runnable
{
  MainService$1(MainService paramMainService, FromServiceMsg paramFromServiceMsg, long paramLong) {}
  
  public void run()
  {
    Toast.makeText(MainService.access$000(this.this$0), "Caution! running too long. cmd=" + this.val$response.getServiceCmd() + " time=" + this.val$notifyCost + "ms.", 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.MainService.1
 * JD-Core Version:    0.7.0.1
 */