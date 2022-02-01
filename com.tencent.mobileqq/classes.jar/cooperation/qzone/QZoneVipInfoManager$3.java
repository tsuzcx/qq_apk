package cooperation.qzone;

import com.tencent.mobileqq.app.QQAppInterface;

final class QZoneVipInfoManager$3
  implements Runnable
{
  QZoneVipInfoManager$3(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    QZoneHelper.preloadQzone(this.val$appInterface, "h5");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneVipInfoManager.3
 * JD-Core Version:    0.7.0.1
 */