package cooperation.qzone.share;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;

class QZoneShareActivity$22
  extends BroadcastReceiver
{
  QZoneShareActivity$22(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.qq.shareupdate".equals(paramIntent.getAction())) {
      ThreadManager.postImmediately(new QZoneShareActivity.22.1(this), null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.22
 * JD-Core Version:    0.7.0.1
 */