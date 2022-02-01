package com.tencent.mobileqq.kandian.biz.ugc;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.framework.RIJUGCDianDian;

final class RIJUgcUtils$8
  implements Runnable
{
  RIJUgcUtils$8(Activity paramActivity, int paramInt) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.a, ReadInJoyDeliverUGCActivity.class);
    localIntent.putExtra("is_from_kan_dian", true);
    localIntent.putExtra("support_topic", true);
    localIntent.putExtra("ugcPushType", 1);
    localIntent.putExtra("key_from", this.b);
    this.a.startActivity(localIntent);
    RIJUGCDianDian.a("1", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils.8
 * JD-Core Version:    0.7.0.1
 */