package com.tencent.mobileqq.nearby;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.AppIntefaceReportWrap;

final class NearbyTitleBarActivity$1
  implements Runnable
{
  NearbyTitleBarActivity$1(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    AppInterface localAppInterface = this.a;
    String str = this.b;
    AppIntefaceReportWrap.a(localAppInterface, "CliOper", "", "", str, str, 0, 0, this.c, this.d, this.e, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyTitleBarActivity.1
 * JD-Core Version:    0.7.0.1
 */