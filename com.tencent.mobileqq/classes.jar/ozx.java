import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class ozx
  implements INetEventHandler
{
  ozx(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ozs.b(this.a);
      return;
    }
    ozs.j("");
    ozs.k("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ozx
 * JD-Core Version:    0.7.0.1
 */