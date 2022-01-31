import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class ohd
  implements Manager
{
  private AppInterface a;
  
  public ohd(AppInterface paramAppInterface)
  {
    QLog.i("ReadInJoyLogicManager", 1, "[ReadInJoyLogicManager] constructed.");
    this.a = paramAppInterface;
    a();
  }
  
  public ogy a()
  {
    return ogy.a();
  }
  
  public void a()
  {
    odc.a();
    ogy.a().a(this.a);
  }
  
  public void b()
  {
    ogy.a().a(false);
  }
  
  public void onDestroy()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ohd
 * JD-Core Version:    0.7.0.1
 */