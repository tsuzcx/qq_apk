import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.LocalVideoPusher.Condition;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class oav
  implements LocalVideoPusher.Condition
{
  public oav(LocalVideoPushSegment paramLocalVideoPushSegment) {}
  
  public boolean a()
  {
    long l = ((Long)this.a.a.b("last_cancel_time", Long.valueOf(0L))).longValue();
    try
    {
      String str = (String)this.a.a.b("localVideoScanInterval", "1440");
      SLog.a("Q.qqstory.home.LocalVideoPushSegment", "localVideoScanInterval config=%s", str);
      i = Integer.valueOf(str).intValue();
      if (NetConnInfoCenter.getServerTimeMillis() - l < i * 60 * 1000) {
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 1440;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oav
 * JD-Core Version:    0.7.0.1
 */