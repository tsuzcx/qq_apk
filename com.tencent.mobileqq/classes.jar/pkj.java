import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.component.network.module.common.NetworkStatus;
import com.tencent.component.network.utils.thread.PriorityThreadPool;

public class pkj
  extends BroadcastReceiver
{
  public pkj(NetworkStatus paramNetworkStatus) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction())) {
      PriorityThreadPool.getDefault().submit(new pkk(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pkj
 * JD-Core Version:    0.7.0.1
 */