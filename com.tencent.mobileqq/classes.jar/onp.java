import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class onp
  implements INetEventHandler
{
  onp(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      onk.c(this.a);
      return;
    }
    onk.j("");
    onk.k("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     onp
 * JD-Core Version:    0.7.0.1
 */