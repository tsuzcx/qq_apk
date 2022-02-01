package cooperation.qzone.util;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneApiProxy;

final class QzonePublicAccountHelper$1
  implements Runnable
{
  QzonePublicAccountHelper$1(Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      QzonePluginProxyActivity.getQZonePluginClassLoader(this.val$context);
      QZoneApiProxy.initServlet(this.val$context, this.val$app);
      QZoneApiProxy.initEnv(this.val$context, this.val$app);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("QzonePublicAccountHelper", 1, "QzonePublicAccountHelper: failed to load qzone plugin", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.util.QzonePublicAccountHelper.1
 * JD-Core Version:    0.7.0.1
 */