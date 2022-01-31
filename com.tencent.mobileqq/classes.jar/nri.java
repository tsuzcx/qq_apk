import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;

public class nri
  implements INetInfoHandler
{
  protected WeakReference<nng> a;
  
  public nri(nng paramnng)
  {
    this.a = new WeakReference(paramnng);
  }
  
  public void onNetMobile2None()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((nng)this.a.get()).c();
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((nng)this.a.get()).i();
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null))
    {
      ((nng)this.a.get()).g();
      ((nng)this.a.get()).i();
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((nng)this.a.get()).i();
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((nng)this.a.get()).h();
    }
  }
  
  public void onNetWifi2None()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((nng)this.a.get()).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nri
 * JD-Core Version:    0.7.0.1
 */