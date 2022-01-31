import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;

public class lag
  implements Runnable
{
  public lag(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface) {}
  
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
 * Qualified Name:     lag
 * JD-Core Version:    0.7.0.1
 */