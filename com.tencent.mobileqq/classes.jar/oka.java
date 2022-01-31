import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.takevideo.rmw.RMWLog;
import com.tencent.biz.qqstory.takevideo.rmw.RMWProto;
import com.tencent.biz.qqstory.takevideo.rmw.RMWService;

public class oka
  extends Handler
{
  public oka(RMWService paramRMWService) {}
  
  public void handleMessage(Message paramMessage)
  {
    RMWLog.a("RMWService", "service.handle : " + RMWProto.a(paramMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oka
 * JD-Core Version:    0.7.0.1
 */