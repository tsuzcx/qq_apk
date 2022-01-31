import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class lbr
  implements BusinessObserver
{
  public lbs a;
  
  public lbr(lbs paramlbs)
  {
    this.a = paramlbs;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    yxp.b("GdtSSOLoadAD", "onReceive i " + paramInt + " success " + paramBoolean + " bundle " + paramBundle);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     lbr
 * JD-Core Version:    0.7.0.1
 */