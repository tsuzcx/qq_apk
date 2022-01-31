import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import java.util.concurrent.atomic.AtomicBoolean;

class stl
  implements INetEventHandler
{
  private stl(sti paramsti) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    veg.d("Q.qqstory.publish:VideoServerInfoManager", "network change");
    this.a.b.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     stl
 * JD-Core Version:    0.7.0.1
 */