package com.tencent.mobileqq.kandian.base.view.widget;

import android.net.Uri;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver.Listener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

final class ReadInJoyScreenShotReporter$1
  implements ScreenshotContentObserver.Listener
{
  public void a(Uri paramUri, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDetectScreenshot() path=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", channelID=");
      paramUri = ReadInJoyScreenShotReporter.a(ReadInJoyScreenShotReporter.a());
      paramString = "null";
      if (paramUri == null) {
        paramUri = "null";
      } else {
        paramUri = ReadInJoyScreenShotReporter.a(ReadInJoyScreenShotReporter.a());
      }
      localStringBuilder.append(paramUri);
      localStringBuilder.append(", channelType=");
      if (ReadInJoyScreenShotReporter.b(ReadInJoyScreenShotReporter.a()) == null) {
        paramUri = paramString;
      } else {
        paramUri = ReadInJoyScreenShotReporter.b(ReadInJoyScreenShotReporter.a());
      }
      localStringBuilder.append(paramUri);
      QLog.d("ReadInJoyScreenShotReporter", 2, localStringBuilder.toString());
    }
    if (ReadInJoyScreenShotReporter.a(ReadInJoyScreenShotReporter.a()) != null) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, "", "0X8008100", "0X8008100", 0, 0, String.valueOf(System.currentTimeMillis() / 1000L), String.valueOf(ReadInJoyScreenShotReporter.b(ReadInJoyScreenShotReporter.a())), String.valueOf(ReadInJoyScreenShotReporter.a(ReadInJoyScreenShotReporter.a())), null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyScreenShotReporter.1
 * JD-Core Version:    0.7.0.1
 */