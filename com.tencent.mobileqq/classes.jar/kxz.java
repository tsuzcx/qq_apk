import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;

public class kxz
  implements Runnable
{
  public kxz(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface) {}
  
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
 * Qualified Name:     kxz
 * JD-Core Version:    0.7.0.1
 */