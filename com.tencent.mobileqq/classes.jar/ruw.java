import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

final class ruw
  implements szy
{
  public void a(Uri paramUri, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("onDetectScreenshot() path=").append(paramString).append(", channelID=");
      if (ruv.a(ruv.a()) != null) {
        break label129;
      }
      paramUri = "null";
      paramString = paramString.append(paramUri).append(", channelType=");
      if (ruv.b(ruv.a()) != null) {
        break label139;
      }
    }
    label129:
    label139:
    for (paramUri = "null";; paramUri = ruv.b(ruv.a()))
    {
      QLog.d("ReadInJoyScreenShotReporter", 2, paramUri);
      if (ruv.a(ruv.a()) != null) {
        nrt.b(null, "", "0X8008100", "0X8008100", 0, 0, String.valueOf(System.currentTimeMillis() / 1000L), String.valueOf(ruv.b(ruv.a())), String.valueOf(ruv.a(ruv.a())), null, false);
      }
      return;
      paramUri = ruv.a(ruv.a());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ruw
 * JD-Core Version:    0.7.0.1
 */