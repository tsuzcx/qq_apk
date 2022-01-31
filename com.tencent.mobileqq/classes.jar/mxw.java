import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;

public class mxw
  implements INetInfoHandler
{
  protected WeakReference<mxq> a;
  
  public mxw(mxq parammxq)
  {
    this.a = new WeakReference(parammxq);
  }
  
  public void onNetMobile2None()
  {
    mxq localmxq = (mxq)this.a.get();
    if (localmxq != null) {
      localmxq.a = 2;
    }
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    mxq localmxq = (mxq)this.a.get();
    if (localmxq != null) {
      localmxq.a = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mxw
 * JD-Core Version:    0.7.0.1
 */