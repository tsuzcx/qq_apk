import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class pbd
  implements INetEventHandler
{
  pbd(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      pay.b(this.a);
      return;
    }
    pay.j("");
    pay.k("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pbd
 * JD-Core Version:    0.7.0.1
 */