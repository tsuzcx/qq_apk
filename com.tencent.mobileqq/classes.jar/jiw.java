import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.qphone.base.util.QLog;

public class jiw
  implements Runnable
{
  public jiw(GuildMultiActivity paramGuildMultiActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(GuildMultiActivity.a, 2, "updateMemInStage refresh");
    }
    GuildMultiActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jiw
 * JD-Core Version:    0.7.0.1
 */