import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

final class rfd
  implements sig
{
  public void a(Uri paramUri, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("onDetectScreenshot() path=").append(paramString).append(", channelID=");
      if (rfc.a(rfc.a()) != null) {
        break label129;
      }
      paramUri = "null";
      paramString = paramString.append(paramUri).append(", channelType=");
      if (rfc.b(rfc.a()) != null) {
        break label139;
      }
    }
    label129:
    label139:
    for (paramUri = "null";; paramUri = rfc.b(rfc.a()))
    {
      QLog.d("ReadInJoyScreenShotReporter", 2, paramUri);
      if (rfc.a(rfc.a()) != null) {
        noo.b(null, "", "0X8008100", "0X8008100", 0, 0, String.valueOf(System.currentTimeMillis() / 1000L), String.valueOf(rfc.b(rfc.a())), String.valueOf(rfc.a(rfc.a())), null, false);
      }
      return;
      paramUri = rfc.a(rfc.a());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rfd
 * JD-Core Version:    0.7.0.1
 */