import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class kvu
  extends BroadcastReceiver
{
  public kvu(VideoAppInterface paramVideoAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    QLog.d(VideoAppInterface.c(), 2, String.format("onReceive action=%s", new Object[] { paramContext }));
    System.exit(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kvu
 * JD-Core Version:    0.7.0.1
 */