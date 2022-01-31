import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class oce
  implements INetEventHandler
{
  oce(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      obz.c(this.a);
      return;
    }
    obz.j("");
    obz.k("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oce
 * JD-Core Version:    0.7.0.1
 */