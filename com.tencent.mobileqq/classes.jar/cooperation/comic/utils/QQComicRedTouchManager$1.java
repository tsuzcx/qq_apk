package cooperation.comic.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class QQComicRedTouchManager$1
  extends BroadcastReceiver
{
  QQComicRedTouchManager$1(QQComicRedTouchManager paramQQComicRedTouchManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginRedTouchManager", 2, "Received red touch push");
    }
    QQComicRedTouchManager.a(this.a);
    QQComicRedTouchManager.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.utils.QQComicRedTouchManager.1
 * JD-Core Version:    0.7.0.1
 */