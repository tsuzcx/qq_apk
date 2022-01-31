import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;

public class ocp
  implements INetInfoHandler
{
  protected WeakReference<nyo> a;
  
  public ocp(nyo paramnyo)
  {
    this.a = new WeakReference(paramnyo);
  }
  
  public void onNetMobile2None()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((nyo)this.a.get()).c();
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((nyo)this.a.get()).i();
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null))
    {
      ((nyo)this.a.get()).g();
      ((nyo)this.a.get()).i();
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((nyo)this.a.get()).i();
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((nyo)this.a.get()).h();
    }
  }
  
  public void onNetWifi2None()
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((nyo)this.a.get()).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocp
 * JD-Core Version:    0.7.0.1
 */