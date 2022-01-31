import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.av.utils.SparkDot;

public class jjo
  implements Runnable
{
  public jjo(GuildMultiActivity paramGuildMultiActivity) {}
  
  public void run()
  {
    if (SessionMgr.a().a(this.a.e).a.b == 5)
    {
      this.a.a.b();
      this.a.a.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jjo
 * JD-Core Version:    0.7.0.1
 */