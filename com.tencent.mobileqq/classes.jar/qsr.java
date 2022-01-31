import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

final class qsr
  implements rvo
{
  public void a(Uri paramUri, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("onDetectScreenshot() path=").append(paramString).append(", channelID=");
      if (qsq.a(qsq.a()) != null) {
        break label129;
      }
      paramUri = "null";
      paramString = paramString.append(paramUri).append(", channelType=");
      if (qsq.b(qsq.a()) != null) {
        break label139;
      }
    }
    label129:
    label139:
    for (paramUri = "null";; paramUri = qsq.b(qsq.a()))
    {
      QLog.d("ReadInJoyScreenShotReporter", 2, paramUri);
      if (qsq.a(qsq.a()) != null) {
        ndn.b(null, "", "0X8008100", "0X8008100", 0, 0, String.valueOf(System.currentTimeMillis() / 1000L), String.valueOf(qsq.b(qsq.a())), String.valueOf(qsq.a(qsq.a())), null, false);
      }
      return;
      paramUri = qsq.a(qsq.a());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsr
 * JD-Core Version:    0.7.0.1
 */