import android.net.Uri;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyScreenShotReporter;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver.Listener;
import com.tencent.qphone.base.util.QLog;

public final class mhw
  implements ScreenshotContentObserver.Listener
{
  public void a(Uri paramUri, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("onDetectScreenshot() path=").append(paramString).append(", channelID=");
      if (ReadInJoyScreenShotReporter.a(ReadInJoyScreenShotReporter.a()) != null) {
        break label129;
      }
      paramUri = "null";
      paramString = paramString.append(paramUri).append(", channelType=");
      if (ReadInJoyScreenShotReporter.b(ReadInJoyScreenShotReporter.a()) != null) {
        break label139;
      }
    }
    label129:
    label139:
    for (paramUri = "null";; paramUri = ReadInJoyScreenShotReporter.b(ReadInJoyScreenShotReporter.a()))
    {
      QLog.d("ReadInJoyScreenShotReporter", 2, paramUri);
      if (ReadInJoyScreenShotReporter.a(ReadInJoyScreenShotReporter.a()) != null) {
        PublicAccountReportUtils.b(null, "", "0X8008100", "0X8008100", 0, 0, String.valueOf(System.currentTimeMillis() / 1000L), String.valueOf(ReadInJoyScreenShotReporter.b(ReadInJoyScreenShotReporter.a())), String.valueOf(ReadInJoyScreenShotReporter.a(ReadInJoyScreenShotReporter.a())), null, false);
      }
      return;
      paramUri = ReadInJoyScreenShotReporter.a(ReadInJoyScreenShotReporter.a());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mhw
 * JD-Core Version:    0.7.0.1
 */