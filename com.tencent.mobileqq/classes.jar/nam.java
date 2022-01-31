import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;

public class nam
  implements INetInfoHandler
{
  protected WeakReference<nag> a;
  
  public nam(nag paramnag)
  {
    this.a = new WeakReference(paramnag);
  }
  
  public void onNetMobile2None()
  {
    nag localnag = (nag)this.a.get();
    if (localnag != null) {
      localnag.a = 2;
    }
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    nag localnag = (nag)this.a.get();
    if (localnag != null) {
      localnag.a = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nam
 * JD-Core Version:    0.7.0.1
 */