import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

final class sjw
  implements ubp
{
  public void a(Uri paramUri, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("onDetectScreenshot() path=").append(paramString).append(", channelID=");
      if (sjv.a(sjv.a()) != null) {
        break label129;
      }
      paramUri = "null";
      paramString = paramString.append(paramUri).append(", channelType=");
      if (sjv.b(sjv.a()) != null) {
        break label139;
      }
    }
    label129:
    label139:
    for (paramUri = "null";; paramUri = sjv.b(sjv.a()))
    {
      QLog.d("ReadInJoyScreenShotReporter", 2, paramUri);
      if (sjv.a(sjv.a()) != null) {
        ocd.b(null, "", "0X8008100", "0X8008100", 0, 0, String.valueOf(System.currentTimeMillis() / 1000L), String.valueOf(sjv.b(sjv.a())), String.valueOf(sjv.a(sjv.a())), null, false);
      }
      return;
      paramUri = sjv.a(sjv.a());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sjw
 * JD-Core Version:    0.7.0.1
 */