import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;

public class njf
  implements INetInfoHandler
{
  protected WeakReference<niz> a;
  
  public njf(niz paramniz)
  {
    this.a = new WeakReference(paramniz);
  }
  
  public void onNetMobile2None()
  {
    niz localniz = (niz)this.a.get();
    if (localniz != null) {
      localniz.a = 2;
    }
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    niz localniz = (niz)this.a.get();
    if (localniz != null) {
      localniz.a = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     njf
 * JD-Core Version:    0.7.0.1
 */