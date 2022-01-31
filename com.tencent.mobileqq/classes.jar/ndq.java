import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import java.util.concurrent.atomic.AtomicBoolean;

public class ndq
  implements INetEventHandler
{
  private ndq(VideoServerInfoManager paramVideoServerInfoManager) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    SLog.d("Q.qqstory.publish:VideoServerInfoManager", "network change");
    this.a.b.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndq
 * JD-Core Version:    0.7.0.1
 */