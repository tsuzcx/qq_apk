import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class lbw
  implements BusinessObserver
{
  public lbx a;
  
  public lbw(lbx paramlbx)
  {
    this.a = paramlbx;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    yxs.b("GdtSSOLoadAD", "onReceive i " + paramInt + " success " + paramBoolean + " bundle " + paramBundle);
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
 * Qualified Name:     lbw
 * JD-Core Version:    0.7.0.1
 */