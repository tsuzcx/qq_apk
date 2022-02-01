import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class nng
{
  private static final String a = nng.class.getName();
  
  public static String a(String paramString)
  {
    localStringBuffer = new StringBuffer();
    try
    {
      paramString = new BufferedReader(new InputStreamReader(((HttpURLConnection)new URL(paramString).openConnection()).getInputStream()));
      for (;;)
      {
        String str = paramString.readLine();
        if (str == null) {
          break;
        }
        localStringBuffer.append(str);
      }
      return localStringBuffer.toString();
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "http error");
      }
    }
  }
  
  public static void a(String paramString, nni paramnni)
  {
    new nnh(paramnni, paramString).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nng
 * JD-Core Version:    0.7.0.1
 */