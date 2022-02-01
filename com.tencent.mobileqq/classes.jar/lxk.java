import com.tencent.av.service.QQServiceForAV;
import com.tencent.mobileqq.app.QQAppInterface;

public class lxk
  extends anyz
{
  public lxk(QQServiceForAV paramQQServiceForAV) {}
  
  protected void onUpdateTroopList()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if (localQQAppInterface != null) {
      new bltw(localQQAppInterface).a(new lxl(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lxk
 * JD-Core Version:    0.7.0.1
 */