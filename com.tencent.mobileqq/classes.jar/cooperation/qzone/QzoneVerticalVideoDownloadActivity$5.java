package cooperation.qzone;

import bjoa;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;

class QzoneVerticalVideoDownloadActivity$5
  implements Runnable
{
  QzoneVerticalVideoDownloadActivity$5(QzoneVerticalVideoDownloadActivity paramQzoneVerticalVideoDownloadActivity, PluginBaseInfo paramPluginBaseInfo) {}
  
  public void run()
  {
    try
    {
      if (QzoneVerticalVideoDownloadActivity.access$700(this.this$0) != null) {
        QzoneVerticalVideoDownloadActivity.access$700(this.this$0).a(this.a.mID, null, QzoneVerticalVideoDownloadActivity.access$800(this.this$0));
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QzoneVerticalVideoDownloadActivity", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.QzoneVerticalVideoDownloadActivity.5
 * JD-Core Version:    0.7.0.1
 */