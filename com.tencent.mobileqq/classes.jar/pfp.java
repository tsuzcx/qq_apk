import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.webviewbase.WebAIOController;

public class pfp
  extends BroadcastReceiver
{
  public pfp(WebAIOController paramWebAIOController) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.msg.newmessage".equals(paramIntent.getAction()))
    {
      WebAIOController.b = false;
      WebAIOController.c = true;
      this.a.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pfp
 * JD-Core Version:    0.7.0.1
 */