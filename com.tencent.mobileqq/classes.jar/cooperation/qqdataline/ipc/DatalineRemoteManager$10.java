package cooperation.qqdataline.ipc;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class DatalineRemoteManager$10
  implements Runnable
{
  DatalineRemoteManager$10(DatalineRemoteManager paramDatalineRemoteManager) {}
  
  public void run()
  {
    while (!this.this$0.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      Bundle localBundle = (Bundle)this.this$0.jdField_a_of_type_JavaUtilArrayList.remove(0);
      if (localBundle == null) {
        return;
      }
      String str = localBundle.getString("notify_cmd");
      try
      {
        localBundle.setClassLoader(getClass().getClassLoader());
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("doPostCachedMsg send success strNotifyCmd:");
          localStringBuilder2.append(str);
          QLog.d("DatalineRemoteManager", 2, localStringBuilder2.toString());
        }
        this.this$0.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService.a("com.qqdataline.action.notify", localBundle);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("doPostCachedMsg send failed strNotifyCmd:");
        localStringBuilder1.append(str);
        QLog.d("DatalineRemoteManager", 2, localStringBuilder1.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineRemoteManager.10
 * JD-Core Version:    0.7.0.1
 */