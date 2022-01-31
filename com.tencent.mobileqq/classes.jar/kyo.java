import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;

public class kyo
  implements Runnable
{
  public kyo(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface) {}
  
  public void run()
  {
    long l = PublicAccountJavascriptInterface.a();
    try
    {
      PublicAccountJavascriptInterface.a(l);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kyo
 * JD-Core Version:    0.7.0.1
 */