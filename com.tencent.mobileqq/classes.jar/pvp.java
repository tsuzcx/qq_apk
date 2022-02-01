import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class pvp
  implements Manager
{
  private AppInterface a;
  
  public pvp(AppInterface paramAppInterface)
  {
    QLog.i("ReadInJoyLogicManager", 1, "[ReadInJoyLogicManager] constructed.");
    this.a = paramAppInterface;
    a();
  }
  
  public pvj a()
  {
    return pvj.a();
  }
  
  public void a()
  {
    pkz.a();
    pvj.a().a(this.a);
  }
  
  public void b()
  {
    pvj.a().a(false);
  }
  
  public void onDestroy()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pvp
 * JD-Core Version:    0.7.0.1
 */