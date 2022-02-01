import com.tencent.av.service.QQServiceForAV;
import com.tencent.mobileqq.app.QQAppInterface;

public class lwx
  extends amwl
{
  public lwx(QQServiceForAV paramQQServiceForAV) {}
  
  protected void onUpdateTroopList()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if (localQQAppInterface != null) {
      new bkik(localQQAppInterface).a(new lwy(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lwx
 * JD-Core Version:    0.7.0.1
 */