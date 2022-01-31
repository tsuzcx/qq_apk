package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;

class QQStoryTakeVideoCloseAnimationActivity$1
  implements Runnable
{
  QQStoryTakeVideoCloseAnimationActivity$1(QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity) {}
  
  public void run()
  {
    QQStoryTakeVideoCloseAnimationActivity localQQStoryTakeVideoCloseAnimationActivity = this.this$0;
    Intent localIntent = new Intent(localQQStoryTakeVideoCloseAnimationActivity, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("main_tab_id", 6);
    localIntent.putExtra("open_now_tab_fragment", true);
    localIntent.putExtra("extra_from_share", true);
    localIntent.putExtra("new_video_extra_info", "need_publish_animation");
    localIntent.setFlags(335544320);
    localQQStoryTakeVideoCloseAnimationActivity.startActivity(localIntent);
    localQQStoryTakeVideoCloseAnimationActivity.overridePendingTransition(2130771981, 2130771983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity.1
 * JD-Core Version:    0.7.0.1
 */