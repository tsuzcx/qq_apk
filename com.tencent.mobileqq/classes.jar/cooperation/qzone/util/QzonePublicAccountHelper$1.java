package cooperation.qzone.util;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneApiProxy;
import mqq.app.AppRuntime;

final class QzonePublicAccountHelper$1
  implements Runnable
{
  QzonePublicAccountHelper$1(Context paramContext, AppRuntime paramAppRuntime) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.util.QzonePublicAccountHelper.1
 * JD-Core Version:    0.7.0.1
 */