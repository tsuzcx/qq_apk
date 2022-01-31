import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;

public class ogi
  implements INetInfoHandler
{
  protected WeakReference<oby> a;
  
  public ogi(oby paramoby)
  {
    this.a = new WeakReference(paramoby);
  }
  
  public void onNetMobile2None()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((oby)this.a.get()).c();
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((oby)this.a.get()).i();
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null))
    {
      ((oby)this.a.get()).g();
      ((oby)this.a.get()).i();
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((oby)this.a.get()).i();
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((oby)this.a.get()).h();
    }
  }
  
  public void onNetWifi2None()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((oby)this.a.get()).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ogi
 * JD-Core Version:    0.7.0.1
 */