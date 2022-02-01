package cooperation.vip.manager;

import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.QZoneHelper;

final class QZoneVipInfoManager$3
  implements Runnable
{
  QZoneVipInfoManager$3(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    QZoneHelper.preloadQzone(this.a, "h5");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.manager.QZoneVipInfoManager.3
 * JD-Core Version:    0.7.0.1
 */