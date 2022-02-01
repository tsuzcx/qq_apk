import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

final class snx
  implements uie
{
  public void a(Uri paramUri, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("onDetectScreenshot() path=").append(paramString).append(", channelID=");
      if (snw.a(snw.a()) != null) {
        break label129;
      }
      paramUri = "null";
      paramString = paramString.append(paramUri).append(", channelType=");
      if (snw.b(snw.a()) != null) {
        break label139;
      }
    }
    label129:
    label139:
    for (paramUri = "null";; paramUri = snw.b(snw.a()))
    {
      QLog.d("ReadInJoyScreenShotReporter", 2, paramUri);
      if (snw.a(snw.a()) != null) {
        odq.b(null, "", "0X8008100", "0X8008100", 0, 0, String.valueOf(System.currentTimeMillis() / 1000L), String.valueOf(snw.b(snw.a())), String.valueOf(snw.a(snw.a())), null, false);
      }
      return;
      paramUri = snw.a(snw.a());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     snx
 * JD-Core Version:    0.7.0.1
 */