package cooperation.qzone.plugin;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class QZonePluginPreInstaller$1
  extends Handler
{
  QZonePluginPreInstaller$1(QZonePluginPreInstaller paramQZonePluginPreInstaller, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginPreInstaller", 2, "handleMessage, retryInstallNum=" + QZonePluginPreInstaller.access$000());
    }
    if (paramMessage.what == 1) {}
    try
    {
      paramMessage = (String)paramMessage.obj;
      QZonePluginPreInstaller.access$100(this.this$0).installPlugin(paramMessage, this.this$0, 2);
      return;
    }
    catch (Exception paramMessage)
    {
      QLog.e("QZonePluginPreInstaller", 1, paramMessage, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginPreInstaller.1
 * JD-Core Version:    0.7.0.1
 */