package cooperation.qzone.webviewplugin;

import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.QZoneHelper;
import mqq.app.AppRuntime;

class QzoneVipPaymentJsPlugin$1
  implements Runnable
{
  QzoneVipPaymentJsPlugin$1(QzoneVipPaymentJsPlugin paramQzoneVipPaymentJsPlugin) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if ((localBaseApplicationImpl == null) || (localBaseApplicationImpl.getRuntime() == null)) {
      return;
    }
    QZoneHelper.preloadQzone(localBaseApplicationImpl, localBaseApplicationImpl.getRuntime().getAccount(), "h5");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */