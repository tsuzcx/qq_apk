import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;

public class nmp
  implements INetInfoHandler
{
  protected WeakReference<nmj> a;
  
  public nmp(nmj paramnmj)
  {
    this.a = new WeakReference(paramnmj);
  }
  
  public void onNetMobile2None()
  {
    nmj localnmj = (nmj)this.a.get();
    if (localnmj != null) {
      localnmj.a = 2;
    }
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    nmj localnmj = (nmj)this.a.get();
    if (localnmj != null) {
      localnmj.a = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nmp
 * JD-Core Version:    0.7.0.1
 */