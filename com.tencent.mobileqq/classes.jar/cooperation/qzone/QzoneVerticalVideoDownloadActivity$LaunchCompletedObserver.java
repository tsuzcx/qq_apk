package cooperation.qzone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

public class QzoneVerticalVideoDownloadActivity$LaunchCompletedObserver
  extends BroadcastReceiver
{
  private String mPluginID;
  private String mPluginName;
  
  public QzoneVerticalVideoDownloadActivity$LaunchCompletedObserver(QzoneVerticalVideoDownloadActivity paramQzoneVerticalVideoDownloadActivity, String paramString1, String paramString2)
  {
    this.mPluginName = paramString1;
    this.mPluginID = paramString2;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("plugin_apk");
    paramIntent = paramIntent.getStringExtra("plugin_name");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LaunchCompletedObserver.onReceive: ");
      localStringBuilder.append(paramContext);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramIntent);
      QLog.d("QzoneVerticalVideoDownloadActivity", 1, localStringBuilder.toString());
    }
    if ((this.mPluginID.equalsIgnoreCase(paramContext)) && (paramIntent != null)) {
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.QzoneVerticalVideoDownloadActivity.LaunchCompletedObserver
 * JD-Core Version:    0.7.0.1
 */