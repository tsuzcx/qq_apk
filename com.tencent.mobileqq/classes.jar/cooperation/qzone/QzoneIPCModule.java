package cooperation.qzone;

import android.os.Bundle;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandler;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class QzoneIPCModule
  extends QIPCModule
{
  private static QzoneIPCModule a;
  
  public QzoneIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static QzoneIPCModule a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new QzoneIPCModule("QzoneIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneIPCModule", 2, "action = " + paramString);
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneIPCModule", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
      return null;
    }
    localObject = (QQAppInterface)localObject;
    if ("getHostInfo".equals(paramString)) {
      try
      {
        paramString = ((FriendsManager)((QQAppInterface)localObject).getManager(50)).b(((QQAppInterface)localObject).getCurrentAccountUin());
        paramBundle = new Bundle();
        paramBundle.putLong("age", paramString.age);
        paramBundle.putLong("gender", paramString.shGender);
        paramBundle.putLong("constellation", paramString.constellation);
        paramBundle.putString("country", paramString.strCountry);
        paramBundle.putString("province", paramString.strProvince);
        paramBundle.putString("city", paramString.strCity);
        paramString = EIPCResult.createResult(0, paramBundle);
        return paramString;
      }
      catch (Exception paramString)
      {
        QLog.e("QzoneIPCModule", 1, paramString, new Object[0]);
      }
    }
    do
    {
      for (;;)
      {
        return null;
        if (!"isFriend".equals(paramString)) {
          break;
        }
        long l = 0L;
        if (paramBundle != null) {}
        try
        {
          l = paramBundle.getLong("uin");
          boolean bool = ((FriendsManager)((QQAppInterface)localObject).getManager(50)).b(String.valueOf(l));
          paramString = new Bundle();
          paramString.putBoolean("isFriend", bool);
          paramString = EIPCResult.createResult(0, paramString);
          return paramString;
        }
        catch (Exception paramString)
        {
          QLog.e("QzoneIPCModule", 1, paramString, new Object[0]);
        }
      }
    } while (!"startDownloadVoicechangeSo".equals(paramString));
    for (;;)
    {
      try
      {
        paramInt = VcSystemInfo.f();
        if (paramInt > 2) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("QzoneIPCModule", 1, paramString, new Object[0]);
        continue;
        UpdateAvSo.b(BaseApplicationImpl.sApplication, "traeimp-armeabi-v7a", true);
        continue;
      }
      try
      {
        paramString = ((EarlyDownloadManager)((QQAppInterface)localObject).getManager(76)).a(QavSoDownloadHandler.e());
        if (paramString == null) {
          continue;
        }
        paramString.a(false);
      }
      catch (Exception paramString)
      {
        QLog.e("QzoneIPCModule", 1, "voiceChang checkVcSo Exception:" + paramString.getMessage());
        continue;
      }
      return EIPCResult.createResult(0, new Bundle());
      QLog.e("QzoneIPCModule", 1, "voiceChang checkVcSo null == earlyHandler:");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QzoneIPCModule
 * JD-Core Version:    0.7.0.1
 */