package com.tencent.mobileqq.kandian.base.view.widget;

import android.net.Uri;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver.Listener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
      paramUri = ReadInJoyScreenShotReporter.a(ReadInJoyScreenShotReporter.c());
      paramString = "null";
      if (paramUri == null) {
        paramUri = "null";
      } else {
        paramUri = ReadInJoyScreenShotReporter.a(ReadInJoyScreenShotReporter.c());
      }
      localStringBuilder.append(paramUri);
      localStringBuilder.append(", channelType=");
      if (ReadInJoyScreenShotReporter.b(ReadInJoyScreenShotReporter.c()) == null) {
        paramUri = paramString;
      } else {
        paramUri = ReadInJoyScreenShotReporter.b(ReadInJoyScreenShotReporter.c());
      }
      localStringBuilder.append(paramUri);
      QLog.d("ReadInJoyScreenShotReporter", 2, localStringBuilder.toString());
    }
    if (ReadInJoyScreenShotReporter.a(ReadInJoyScreenShotReporter.c()) != null) {
      PublicAccountReportUtils.b(null, "", "0X8008100", "0X8008100", 0, 0, String.valueOf(System.currentTimeMillis() / 1000L), String.valueOf(ReadInJoyScreenShotReporter.b(ReadInJoyScreenShotReporter.c())), String.valueOf(ReadInJoyScreenShotReporter.a(ReadInJoyScreenShotReporter.c())), null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyScreenShotReporter.1
 * JD-Core Version:    0.7.0.1
 */