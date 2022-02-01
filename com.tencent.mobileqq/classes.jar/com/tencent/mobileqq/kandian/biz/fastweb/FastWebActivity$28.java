package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager.Companion;

class FastWebActivity$28
  implements Runnable
{
  FastWebActivity$28(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    RIJPushNotifyManager.Companion.a().dismiss(false, "MATCH_ALL_UIN");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.28
 * JD-Core Version:    0.7.0.1
 */