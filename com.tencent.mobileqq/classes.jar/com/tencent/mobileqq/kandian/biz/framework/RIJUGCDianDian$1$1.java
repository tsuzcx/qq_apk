package com.tencent.mobileqq.kandian.biz.framework;

import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity;

class RIJUGCDianDian$1$1
  implements Runnable
{
  RIJUGCDianDian$1$1(RIJUGCDianDian.1 param1) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.this$0.a, ReadInJoyDeliverUGCActivity.class);
    localIntent.putExtra("is_from_dian_dian", true);
    localIntent.putExtra("support_topic", true);
    this.this$0.a.startActivity(localIntent);
    RIJUGCDianDian.a("3", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJUGCDianDian.1.1
 * JD-Core Version:    0.7.0.1
 */