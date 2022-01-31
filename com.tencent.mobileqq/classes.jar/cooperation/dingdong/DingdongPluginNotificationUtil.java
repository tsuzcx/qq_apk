package cooperation.dingdong;

import android.app.Activity;
import android.content.Intent;

public class DingdongPluginNotificationUtil
{
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("_dingdong_notification_schedule_id_");
    Intent localIntent = new Intent();
    localIntent.putExtra("schedule_feed_id", paramIntent);
    DingdongPluginHelper.a(paramActivity, "com.dingdong.business.Schedule.Activity.ScheduleDetailActivity", localIntent, -1);
    paramActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.dingdong.DingdongPluginNotificationUtil
 * JD-Core Version:    0.7.0.1
 */