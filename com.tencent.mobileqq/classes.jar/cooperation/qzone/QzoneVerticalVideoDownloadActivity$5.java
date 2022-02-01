package cooperation.qzone;

import android.os.Handler;
import android.os.IBinder;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class QzoneVerticalVideoDownloadActivity$5
  implements OnPluginInstallListener
{
  QzoneVerticalVideoDownloadActivity$5(QzoneVerticalVideoDownloadActivity paramQzoneVerticalVideoDownloadActivity, long paramLong) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
  {
    QLog.i("QzoneVerticalVideoDownloadActivity", 1, " qzone_plugin onInstallBegin");
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    QLog.i("QzoneVerticalVideoDownloadActivity", 1, " qzone_plugin onInstallDownloadProgress");
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    QLog.e("QzoneVerticalVideoDownloadActivity", 1, " qzone_plugin onInstallError");
    QzoneVerticalVideoDownloadActivity.access$000(this.this$0).sendEmptyMessage(1012);
    paramString = new HashMap();
    paramString.put("status", "installError");
    QzoneVerticalVideoDownloadActivity.access$800(this.this$0.app, "vertical_layer_plugin_depend", paramString);
  }
  
  public void onInstallFinish(String paramString)
  {
    QLog.i("QzoneVerticalVideoDownloadActivity", 1, " qzone_plugin onInstallFinish");
    QzoneVerticalVideoDownloadActivity.access$000(this.this$0).sendEmptyMessage(1011);
    long l1 = System.currentTimeMillis();
    long l2 = this.val$starime;
    QzoneVerticalVideoDownloadActivity.access$700(this.this$0.app, "vertical_layer_plugin_depend", "status", "installFinish", (int)(l1 - l2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneVerticalVideoDownloadActivity.5
 * JD-Core Version:    0.7.0.1
 */