import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import java.util.concurrent.atomic.AtomicBoolean;

class sgp
  implements INetEventHandler
{
  private sgp(sgm paramsgm) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    urk.d("Q.qqstory.publish:VideoServerInfoManager", "network change");
    this.a.b.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sgp
 * JD-Core Version:    0.7.0.1
 */