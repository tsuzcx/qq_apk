import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;

public class ocs
  implements INetInfoHandler
{
  protected WeakReference<nyr> a;
  
  public ocs(nyr paramnyr)
  {
    this.a = new WeakReference(paramnyr);
  }
  
  public void onNetMobile2None()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((nyr)this.a.get()).c();
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((nyr)this.a.get()).i();
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null))
    {
      ((nyr)this.a.get()).g();
      ((nyr)this.a.get()).i();
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((nyr)this.a.get()).i();
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((nyr)this.a.get()).h();
    }
  }
  
  public void onNetWifi2None()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((nyr)this.a.get()).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocs
 * JD-Core Version:    0.7.0.1
 */