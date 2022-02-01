import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class pfg
  implements Manager
{
  private AppInterface a;
  
  public pfg(AppInterface paramAppInterface)
  {
    QLog.i("ReadInJoyLogicManager", 1, "[ReadInJoyLogicManager] constructed.");
    this.a = paramAppInterface;
    a();
  }
  
  public pfa a()
  {
    return pfa.a();
  }
  
  public void a()
  {
    pas.a();
    pfa.a().a(this.a);
  }
  
  public void b()
  {
    pfa.a().a(false);
  }
  
  public void onDestroy()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pfg
 * JD-Core Version:    0.7.0.1
 */