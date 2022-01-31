import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.ark.ArkAppEnvConfig;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

public final class lgj
  implements Runnable
{
  public void run()
  {
    Object localObject2 = ReadInJoyHelper.c(ReadInJoyUtils.a());
    String str = ReadInJoyHelper.d(ReadInJoyUtils.a());
    Object localObject1;
    if ((ArkAppEnvConfig.a() != null) && (ArkAppEnvConfig.a().a() == 2))
    {
      localObject1 = "com.tencent.kandianfeeds";
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(str))) {
        break label190;
      }
      ArkLocalAppMgr localArkLocalAppMgr = ReadInJoyArkUtil.a();
      localObject1 = "";
      if (localArkLocalAppMgr != null) {
        localObject1 = localArkLocalAppMgr.a((String)localObject2, str);
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label126;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyArkUtil", 2, new Object[] { "No need to preDownload, appName: ", localObject2, ", appMinVersion: ", str, ", appPath: ", localObject1 });
      }
    }
    label126:
    do
    {
      do
      {
        return;
        localObject1 = "com.tencent.test.kandianfeeds";
        break;
        localObject1 = new ArkAppMessage();
        ((ArkAppMessage)localObject1).appName = ((String)localObject2);
        ((ArkAppMessage)localObject1).appMinVersion = str;
        ReadInJoyArkUtil.a((ArkAppMessage)localObject1, 0);
      } while (!QLog.isColorLevel());
      QLog.d("ReadInJoyArkUtil", 2, new Object[] { "After login preDownload begin, appName: ", ((ArkAppMessage)localObject1).appName, ", appMinVersion: ", ((ArkAppMessage)localObject1).appMinVersion });
      return;
      localObject2 = new ArkAppMessage();
      ((ArkAppMessage)localObject2).appName = ((String)localObject1);
      ((ArkAppMessage)localObject2).appMinVersion = "1.0.0.1";
      ReadInJoyArkUtil.a((ArkAppMessage)localObject2, 0);
    } while (!QLog.isColorLevel());
    label190:
    QLog.d("ReadInJoyArkUtil", 2, new Object[] { "After login preDownload begin, appName: ", ((ArkAppMessage)localObject2).appName, ", appMinVersion: ", ((ArkAppMessage)localObject2).appMinVersion });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lgj
 * JD-Core Version:    0.7.0.1
 */