package cooperation.qzone.networkedmodule;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

public class QzoneModuleCompat
{
  private static final int IN_BLACK_LIST = 1;
  private static final int NOT_INIT = -1;
  private static final int NOT_IN_BLACK_LIST = 0;
  private static final String TAG = "QzoneModuleCompat";
  private static int sIsInBlackList = -1;
  
  public static boolean isDeviceInBlackList()
  {
    for (;;)
    {
      try
      {
        i = sIsInBlackList;
        boolean bool = false;
        if (i != -1)
        {
          i = sIsInBlackList;
          if (i == 1) {
            bool = true;
          }
          return bool;
        }
        localObject1 = "";
        str1 = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzone_module_black_list", "");
        if (!TextUtils.isEmpty(str1)) {
          if (TextUtils.isEmpty(""))
          {
            localObject1 = str1;
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(",");
            ((StringBuilder)localObject1).append(str1);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          sIsInBlackList = 0;
          return false;
        }
      }
      finally
      {
        int i;
        Object localObject1;
        String str1;
        String str2;
        StringBuilder localStringBuilder;
        int j;
        continue;
        throw localObject2;
        continue;
        i += 1;
        continue;
      }
      try
      {
        localObject1 = ((String)localObject1).split(",");
        str1 = Build.MODEL.toLowerCase();
        str2 = Build.MANUFACTURER.toLowerCase();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Device info -- model: ");
        localStringBuilder.append(str1);
        localStringBuilder.append(", manufacturer: ");
        localStringBuilder.append(str2);
        localStringBuilder.append(", platform: ");
        localStringBuilder.append(System.getProperty("ro.board.platform"));
        QLog.i("QzoneModuleCompat", 1, localStringBuilder.toString());
        j = localObject1.length;
        i = 0;
        if (i < j)
        {
          localStringBuilder = localObject1[i];
          if (!localStringBuilder.contains(str1)) {
            if (!localStringBuilder.equals(str2)) {
              continue;
            }
          }
          sIsInBlackList = 1;
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QzoneModuleCompat", 1, "catch an exception:", localThrowable);
        sIsInBlackList = 0;
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleCompat
 * JD-Core Version:    0.7.0.1
 */