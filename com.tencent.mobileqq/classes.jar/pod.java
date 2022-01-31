import com.tencent.component.network.downloader.UrlKeyGenerator;

public class pod
  extends UrlKeyGenerator
{
  public String b(String paramString)
  {
    String str = null;
    int i;
    if (UrlKeyGenerator.a(paramString, "http://")) {
      i = paramString.indexOf("/", "http://".length());
    }
    for (;;)
    {
      if (i != -1) {
        str = paramString.substring(i);
      }
      return str;
      if (UrlKeyGenerator.a(paramString, "https://")) {
        i = paramString.indexOf("/", "https://".length());
      } else {
        i = paramString.indexOf("/");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pod
 * JD-Core Version:    0.7.0.1
 */