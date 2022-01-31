import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class ldv
  implements BusinessObserver
{
  public ldw a;
  
  public ldv(ldw paramldw)
  {
    this.a = paramldw;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    aanp.b("GdtSSOLoadAD", "onReceive i " + paramInt + " success " + paramBoolean + " bundle " + paramBundle);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ldv
 * JD-Core Version:    0.7.0.1
 */