import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;

public class mmx
  implements INetInfoHandler
{
  protected WeakReference<mmr> a;
  
  public mmx(mmr parammmr)
  {
    this.a = new WeakReference(parammmr);
  }
  
  public void onNetMobile2None()
  {
    mmr localmmr = (mmr)this.a.get();
    if (localmmr != null) {
      localmmr.a = 2;
    }
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None()
  {
    mmr localmmr = (mmr)this.a.get();
    if (localmmr != null) {
      localmmr.a = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mmx
 * JD-Core Version:    0.7.0.1
 */