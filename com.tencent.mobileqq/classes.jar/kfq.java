import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.utils.AvAddFriendHelper;
import com.tencent.av.utils.AvAddFriendHelper.IAvAddFriendCallBack;

public class kfq
  extends BroadcastReceiver
{
  public kfq(AvAddFriendHelper paramAvAddFriendHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("tencent.video.q2v.AddfrindMsg"))
    {
      paramContext = paramIntent.getStringExtra("peerUin");
      if (this.a.a != null) {
        this.a.a.a(paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kfq
 * JD-Core Version:    0.7.0.1
 */