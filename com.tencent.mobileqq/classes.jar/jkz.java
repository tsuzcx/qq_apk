import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.qphone.base.util.QLog;

public class jkz
  implements Runnable
{
  public jkz(GuildMultiActivity paramGuildMultiActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(GuildMultiActivity.a, 2, "updateMemInStage refresh");
    }
    GuildMultiActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jkz
 * JD-Core Version:    0.7.0.1
 */