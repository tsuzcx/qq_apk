package cooperation.qzone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

public class QZoneLiveVideoBaseDownLoadActivty$LaunchCompletedObserver
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public QZoneLiveVideoBaseDownLoadActivty$LaunchCompletedObserver(QZoneLiveVideoBaseDownLoadActivty paramQZoneLiveVideoBaseDownLoadActivty, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("plugin_apk");
    paramIntent = paramIntent.getStringExtra("plugin_name");
    if (QLog.isColorLevel()) {
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 1, "LaunchCompletedObserver.onReceive: " + paramContext + ", " + paramIntent);
    }
    if ((this.b.equalsIgnoreCase(paramContext)) && (paramIntent != null)) {
      this.jdField_a_of_type_CooperationQzoneQZoneLiveVideoBaseDownLoadActivty.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoBaseDownLoadActivty.LaunchCompletedObserver
 * JD-Core Version:    0.7.0.1
 */