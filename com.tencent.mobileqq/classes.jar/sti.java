import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import java.util.concurrent.atomic.AtomicBoolean;

class sti
  implements INetEventHandler
{
  private sti(stf paramstf) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    ved.d("Q.qqstory.publish:VideoServerInfoManager", "network change");
    this.a.b.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sti
 * JD-Core Version:    0.7.0.1
 */