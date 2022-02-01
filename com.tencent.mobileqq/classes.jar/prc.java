import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class prc
  implements INetEventHandler
{
  prc(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      prb.a(this.a);
      return;
    }
    prb.a("");
    prb.b("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     prc
 * JD-Core Version:    0.7.0.1
 */