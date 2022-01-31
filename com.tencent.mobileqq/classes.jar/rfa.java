import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

final class rfa
  implements sid
{
  public void a(Uri paramUri, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("onDetectScreenshot() path=").append(paramString).append(", channelID=");
      if (rez.a(rez.a()) != null) {
        break label129;
      }
      paramUri = "null";
      paramString = paramString.append(paramUri).append(", channelType=");
      if (rez.b(rez.a()) != null) {
        break label139;
      }
    }
    label129:
    label139:
    for (paramUri = "null";; paramUri = rez.b(rez.a()))
    {
      QLog.d("ReadInJoyScreenShotReporter", 2, paramUri);
      if (rez.a(rez.a()) != null) {
        nol.b(null, "", "0X8008100", "0X8008100", 0, 0, String.valueOf(System.currentTimeMillis() / 1000L), String.valueOf(rez.b(rez.a())), String.valueOf(rez.a(rez.a())), null, false);
      }
      return;
      paramUri = rez.a(rez.a());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rfa
 * JD-Core Version:    0.7.0.1
 */