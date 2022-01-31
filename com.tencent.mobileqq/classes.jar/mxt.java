import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;

public class mxt
  implements INetInfoHandler
{
  protected WeakReference<mxn> a;
  
  public mxt(mxn parammxn)
  {
    this.a = new WeakReference(parammxn);
  }
  
  public void onNetMobile2None()
  {
    mxn localmxn = (mxn)this.a.get();
    if (localmxn != null) {
      localmxn.a = 2;
    }
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    mxn localmxn = (mxn)this.a.get();
    if (localmxn != null) {
      localmxn.a = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mxt
 * JD-Core Version:    0.7.0.1
 */