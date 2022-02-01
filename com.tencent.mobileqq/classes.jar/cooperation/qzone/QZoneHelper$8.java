package cooperation.qzone;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

final class QZoneHelper$8
  implements Runnable
{
  QZoneHelper$8(QZoneHelper.StartActivity paramStartActivity) {}
  
  public void run()
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if ((localObject == null) || (((List)localObject).size() <= 0))
    {
      this.val$startActivity.onStart(true, false);
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if ("com.tencent.mobileqq:qzone".equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneHelper", 2, "QzoneProcess is exist");
        }
        this.val$startActivity.onStart(true, true);
        return;
      }
    }
    this.val$startActivity.onStart(true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.8
 * JD-Core Version:    0.7.0.1
 */