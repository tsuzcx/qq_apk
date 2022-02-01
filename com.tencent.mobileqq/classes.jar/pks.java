import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class pks
  implements Manager
{
  private AppInterface a;
  
  public pks(AppInterface paramAppInterface)
  {
    QLog.i("ReadInJoyLogicManager", 1, "[ReadInJoyLogicManager] constructed.");
    this.a = paramAppInterface;
    a();
  }
  
  public pkm a()
  {
    return pkm.a();
  }
  
  public void a()
  {
    pby.a();
    pkm.a().a(this.a);
  }
  
  public void b()
  {
    pkm.a().a(false);
  }
  
  public void onDestroy()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pks
 * JD-Core Version:    0.7.0.1
 */