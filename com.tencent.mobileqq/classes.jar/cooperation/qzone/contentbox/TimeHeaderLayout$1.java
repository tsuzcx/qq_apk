package cooperation.qzone.contentbox;

import android.content.SharedPreferences;
import android.os.Handler;
import common.config.service.QZoneConfigHelper;

class TimeHeaderLayout$1
  implements Runnable
{
  TimeHeaderLayout$1(TimeHeaderLayout paramTimeHeaderLayout) {}
  
  public void run()
  {
    boolean[] arrayOfBoolean = new boolean[1];
    if (!this.this$0.preferences.contains(TimeHeaderLayout.KEY_TIME_CAPSULE_EXPAND)) {
      arrayOfBoolean[0] = QZoneConfigHelper.O();
    } else {
      arrayOfBoolean[0] = this.this$0.preferences.getBoolean(TimeHeaderLayout.KEY_TIME_CAPSULE_EXPAND, true);
    }
    this.this$0.handler.post(new TimeHeaderLayout.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.TimeHeaderLayout.1
 * JD-Core Version:    0.7.0.1
 */