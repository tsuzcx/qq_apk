package com.tencent.mobileqq.nearby.guide;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

class NearbyGuideActivity$11
  implements Runnable
{
  NearbyGuideActivity$11(NearbyGuideActivity paramNearbyGuideActivity, String paramString) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = this.this$0.app;
    String str = this.a;
    ReportController.b(localQQAppInterface, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.11
 * JD-Core Version:    0.7.0.1
 */