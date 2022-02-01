import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class phf
  implements INetEventHandler
{
  phf(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      pha.b(this.a);
      return;
    }
    pha.j("");
    pha.k("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phf
 * JD-Core Version:    0.7.0.1
 */