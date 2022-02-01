import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;

public class nla
  implements INetInfoHandler
{
  protected WeakReference<nku> a;
  
  public nla(nku paramnku)
  {
    this.a = new WeakReference(paramnku);
  }
  
  public void onNetMobile2None()
  {
    nku localnku = (nku)this.a.get();
    if (localnku != null) {
      localnku.a = 2;
    }
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    nku localnku = (nku)this.a.get();
    if (localnku != null) {
      localnku.a = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nla
 * JD-Core Version:    0.7.0.1
 */