package cooperation.qqcircle.report;

import android.os.Bundle;
import com.tencent.qcircle.cooperation.config.QCircleSpUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;

class BaseMultiProcessSingleton$1
  implements Runnable
{
  BaseMultiProcessSingleton$1(BaseMultiProcessSingleton paramBaseMultiProcessSingleton, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject = this.val$bundle;
    if (localObject == null)
    {
      QLog.e("BaseMultiProcessSingleton", 1, "updateSpData  bundle == null");
      return;
    }
    localObject = ((Bundle)localObject).keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_process_data_update_");
      localStringBuilder.append(str);
      QCircleSpUtil.a(localStringBuilder.toString(), this.val$bundle.get(str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.report.BaseMultiProcessSingleton.1
 * JD-Core Version:    0.7.0.1
 */