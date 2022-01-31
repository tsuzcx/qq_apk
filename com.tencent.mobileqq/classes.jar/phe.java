import com.tencent.biz.webviewplugin.PubAccountWebViewHttpBridge;

public class phe
  implements Runnable
{
  public phe(PubAccountWebViewHttpBridge paramPubAccountWebViewHttpBridge) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    PubAccountWebViewHttpBridge.a(this.a);
    this.a.a = (System.currentTimeMillis() - l);
    PubAccountWebViewHttpBridge.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phe
 * JD-Core Version:    0.7.0.1
 */