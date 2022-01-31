import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class onm
  implements INetEventHandler
{
  onm(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      onh.c(this.a);
      return;
    }
    onh.j("");
    onh.k("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     onm
 * JD-Core Version:    0.7.0.1
 */