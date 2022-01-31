import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class oxd
  implements Manager
{
  private AppInterface a;
  
  public oxd(AppInterface paramAppInterface)
  {
    QLog.i("ReadInJoyLogicManager", 1, "[ReadInJoyLogicManager] constructed.");
    this.a = paramAppInterface;
    a();
  }
  
  public owy a()
  {
    return owy.a();
  }
  
  public void a()
  {
    osv.a();
    owy.a().a(this.a);
  }
  
  public void b()
  {
    owy.a().a(false);
  }
  
  public void onDestroy()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oxd
 * JD-Core Version:    0.7.0.1
 */