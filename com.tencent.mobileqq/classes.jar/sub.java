import android.annotation.TargetApi;
import java.net.URL;

@TargetApi(14)
public class sub
{
  public static URL a(URL paramURL)
  {
    String str = paramURL.getHost();
    int k = str.indexOf(':');
    Object localObject = paramURL;
    if (k != -1)
    {
      localObject = str.substring(0, k);
      int j = paramURL.getPort();
      int i = j;
      if (j == -1) {
        i = Integer.valueOf(str.substring(k + 1)).intValue();
      }
      veg.b("URLChecker", "url is not initilized correctly, so re-create it");
      localObject = new URL(paramURL.getProtocol(), (String)localObject, i, paramURL.getFile());
    }
    return localObject;
  }
  
  public static boolean a(URL paramURL)
  {
    return paramURL.getHost().indexOf(':') == -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sub
 * JD-Core Version:    0.7.0.1
 */