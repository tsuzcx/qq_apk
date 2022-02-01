package cooperation.qzone;

import bnez;
import com.tencent.mobileqq.app.QQAppInterface;

public final class QZoneHelper$7
  implements Runnable
{
  public QZoneHelper$7(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    bnez localbnez = (bnez)this.a.getManager(175);
    if (localbnez != null) {
      localbnez.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.7
 * JD-Core Version:    0.7.0.1
 */