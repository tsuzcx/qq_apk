import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

final class tbi
  implements uwb
{
  public void a(Uri paramUri, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("onDetectScreenshot() path=").append(paramString).append(", channelID=");
      if (tbh.a(tbh.a()) != null) {
        break label129;
      }
      paramUri = "null";
      paramString = paramString.append(paramUri).append(", channelType=");
      if (tbh.b(tbh.a()) != null) {
        break label139;
      }
    }
    label129:
    label139:
    for (paramUri = "null";; paramUri = tbh.b(tbh.a()))
    {
      QLog.d("ReadInJoyScreenShotReporter", 2, paramUri);
      if (tbh.a(tbh.a()) != null) {
        olh.b(null, "", "0X8008100", "0X8008100", 0, 0, String.valueOf(System.currentTimeMillis() / 1000L), String.valueOf(tbh.b(tbh.a())), String.valueOf(tbh.a(tbh.a())), null, false);
      }
      return;
      paramUri = tbh.a(tbh.a());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tbi
 * JD-Core Version:    0.7.0.1
 */