package cooperation.qzone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

class WatchActivityManager$ScreenKeyReceiver
  extends BroadcastReceiver
{
  private String action;
  
  private WatchActivityManager$ScreenKeyReceiver(WatchActivityManager paramWatchActivityManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.action = paramIntent.getAction();
    if (!TextUtils.isEmpty(this.action))
    {
      if (!"android.intent.action.SCREEN_OFF".equals(this.action)) {
        break label40;
      }
      WatchActivityManager.access$102(this.this$0, true);
    }
    label40:
    while (!this.action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
      return;
    }
    WatchActivityManager.access$202(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.WatchActivityManager.ScreenKeyReceiver
 * JD-Core Version:    0.7.0.1
 */