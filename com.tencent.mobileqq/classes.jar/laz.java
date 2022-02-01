import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class laz
  implements BusinessObserver
{
  public lba a;
  
  public laz(lba paramlba)
  {
    this.a = paramlba;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    acvc.b("GdtSSOLoadAD", "onReceive i " + paramInt + " success " + paramBoolean + " bundle " + paramBundle);
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while (this.a == null);
      this.a.a(paramBundle);
      return;
    } while (this.a == null);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     laz
 * JD-Core Version:    0.7.0.1
 */