import android.content.Context;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

final class orx
  implements INetEventHandler
{
  orx(Context paramContext) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ors.b(this.a);
      return;
    }
    ors.j("");
    ors.k("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     orx
 * JD-Core Version:    0.7.0.1
 */