import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class pmm
  implements Manager
{
  private AppInterface a;
  
  public pmm(AppInterface paramAppInterface)
  {
    QLog.i("ReadInJoyLogicManager", 1, "[ReadInJoyLogicManager] constructed.");
    this.a = paramAppInterface;
    a();
  }
  
  public pmh a()
  {
    return pmh.a();
  }
  
  public void a()
  {
    pia.a();
    pmh.a().a(this.a);
  }
  
  public void b()
  {
    pmh.a().a(false);
  }
  
  public void onDestroy()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pmm
 * JD-Core Version:    0.7.0.1
 */