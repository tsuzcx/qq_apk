package com.tencent.mobileqq.kandian.biz.push.activity;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;

final class ReadinjoyJumpActivity$4
  implements Runnable
{
  ReadinjoyJumpActivity$4(long paramLong, Intent paramIntent, Context paramContext) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("jump_article_param_ids", this.a);
    localIntent.putExtra("jump_activity_launch_from", this.b.getIntExtra("jump_activity_launch_from", 0));
    localIntent.putExtra("daily_lock_screen_param", this.b.getBooleanExtra("daily_lock_screen_param", false));
    PublicFragmentActivity.a(this.c, localIntent, ReadinjoyJumpActivity.class);
    QLog.d("ReadinjoyJumpActivity", 2, "start activity!");
    ReadinjoyJumpActivity.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.activity.ReadinjoyJumpActivity.4
 * JD-Core Version:    0.7.0.1
 */