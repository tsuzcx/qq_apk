import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.av.utils.SparkDot;

public class jlc
  implements Runnable
{
  public jlc(GuildMultiActivity paramGuildMultiActivity) {}
  
  public void run()
  {
    if (SessionMgr.a().a(this.a.e).a.b == 5)
    {
      this.a.a.b();
      this.a.a.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jlc
 * JD-Core Version:    0.7.0.1
 */