package cooperation.qzone;

import bmdx;
import com.tencent.mobileqq.app.QQAppInterface;

public final class QZoneHelper$7
  implements Runnable
{
  public QZoneHelper$7(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    bmdx localbmdx = (bmdx)this.a.getManager(175);
    if (localbmdx != null) {
      localbmdx.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.7
 * JD-Core Version:    0.7.0.1
 */