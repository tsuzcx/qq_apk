package cooperation.qqfav;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class QfavHelper$3$1
  extends OnPluginInstallListener.Stub
{
  QfavHelper$3$1(QfavHelper.3 param3) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("install plugin ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" error! ");
      localStringBuilder.append(paramInt);
      QLog.i("qqfav", 2, localStringBuilder.toString());
    }
    try
    {
      ThreadManager.post(this.a.a, 5, null, false);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("install plugin ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" OK.");
      QLog.i("qqfav", 2, localStringBuilder.toString());
    }
    QfavHelper.d().set(true);
    try
    {
      ThreadManager.post(this.a.a, 5, null, false);
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.QfavHelper.3.1
 * JD-Core Version:    0.7.0.1
 */