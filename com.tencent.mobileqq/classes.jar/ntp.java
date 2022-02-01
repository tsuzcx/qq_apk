import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;

public class ntp
  implements INetInfoHandler
{
  protected WeakReference<ntj> a;
  
  public ntp(ntj paramntj)
  {
    this.a = new WeakReference(paramntj);
  }
  
  public void onNetMobile2None()
  {
    ntj localntj = (ntj)this.a.get();
    if (localntj != null) {
      localntj.a = 2;
    }
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    ntj localntj = (ntj)this.a.get();
    if (localntj != null) {
      localntj.a = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ntp
 * JD-Core Version:    0.7.0.1
 */