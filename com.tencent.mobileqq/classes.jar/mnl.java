import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.confighandler.QAVFunCallConfig;
import com.tencent.mobileqq.utils.confighandler.QAVFunCallHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class mnl
{
  public static int a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if (paramBoolean2) {
      if (!paramBoolean1) {
        break label67;
      }
    }
    label67:
    for (i = biki.a(paramAppRuntime, paramString, 6, paramBoolean1, null); i != 0; i = biki.a(paramAppRuntime, paramAppRuntime.getAccount(), 6, paramBoolean1, paramString))
    {
      if (AudioHelper.f()) {
        QLog.w("QAVConfig_382", 1, "getFunVideoId, 已经有默认配置, fcId[" + i + "]");
      }
      return i;
    }
    paramString = BusinessCommonConfig.getInstance(paramAppRuntime);
    if (paramString != null)
    {
      paramAppRuntime = (QAVFunCallHandler)paramString.getConfigHandler(382);
      paramAppRuntime = paramAppRuntime.getConfigDirect();
      if (paramAppRuntime == null) {
        break label174;
      }
      i = paramAppRuntime.getActivityFCId();
    }
    label174:
    for (;;)
    {
      if (AudioHelper.f()) {
        QLog.w("QAVConfig_382", 1, "getFunVideoId, fcId[" + i + "]");
      }
      return i;
      paramAppRuntime = new QAVFunCallHandler(paramAppRuntime.getAccount());
      break;
    }
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.AnnimateDownloadStart");
    localIntent.setPackage(paramVideoAppInterface.getApp().getPackageName());
    localIntent.putExtra("callId", paramInt);
    paramVideoAppInterface.getApp().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mnl
 * JD-Core Version:    0.7.0.1
 */