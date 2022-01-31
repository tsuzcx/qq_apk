import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.ui.QavPanel;

public class jzj
  extends BroadcastReceiver
{
  public jzj(QavPanel paramQavPanel) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.redpoint.broadcast.push.av")) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jzj
 * JD-Core Version:    0.7.0.1
 */