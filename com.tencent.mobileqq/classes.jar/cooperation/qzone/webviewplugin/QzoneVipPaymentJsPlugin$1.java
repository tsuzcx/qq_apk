package cooperation.qzone.webviewplugin;

import bjdt;
import bjzg;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class QzoneVipPaymentJsPlugin$1
  implements Runnable
{
  public QzoneVipPaymentJsPlugin$1(bjzg parambjzg) {}
  
  public void run()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if ((localBaseApplicationImpl == null) || (localBaseApplicationImpl.getRuntime() == null)) {
      return;
    }
    bjdt.a(localBaseApplicationImpl, localBaseApplicationImpl.getRuntime().getAccount(), "h5");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */