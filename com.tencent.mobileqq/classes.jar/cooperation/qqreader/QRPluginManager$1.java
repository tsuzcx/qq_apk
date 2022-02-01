package cooperation.qqreader;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.util.Pair;
import cooperation.qqreader.utils.Log;
import mqq.util.WeakReference;

class QRPluginManager$1
  extends OnPluginInstallListener.Stub
{
  private int jdField_a_of_type_Int = 0;
  
  QRPluginManager$1(QRPluginManager paramQRPluginManager) {}
  
  public void onInstallBegin(String paramString)
  {
    Log.d("QRPluginManager", "launchPlugin onInstallBegin: pluginId = " + paramString);
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int == 0) || (paramInt1 - this.jdField_a_of_type_Int > paramInt2 / 101))
    {
      Log.e("QRPluginManager", "launchPlugin onInstallDownloadProgress: pluginId = " + paramString + ", offset = " + paramInt1 + ", total = " + paramInt2);
      this.jdField_a_of_type_Int = paramInt1;
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    Log.a("QRPluginManager", "launchPlugin onInstallError, pluginId = " + paramString + ", errorCode = " + paramInt);
    QRPluginManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramInt);
  }
  
  public void onInstallFinish(String paramString)
  {
    Log.c("QRPluginManager", "launchPlugin onInstallFinish, pluginId = " + paramString);
    QRPluginManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 0);
    if ((QRPluginManager.a(this.jdField_a_of_type_CooperationQqreaderQRPluginManager) != null) && (((WeakReference)QRPluginManager.a(this.jdField_a_of_type_CooperationQqreaderQRPluginManager).first).get() != null))
    {
      QRPluginManager.a(this.jdField_a_of_type_CooperationQqreaderQRPluginManager, (Context)((WeakReference)QRPluginManager.a(this.jdField_a_of_type_CooperationQqreaderQRPluginManager).first).get(), ((Integer)QRPluginManager.a(this.jdField_a_of_type_CooperationQqreaderQRPluginManager).second).intValue());
      QRPluginManager.a(this.jdField_a_of_type_CooperationQqreaderQRPluginManager, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.QRPluginManager.1
 * JD-Core Version:    0.7.0.1
 */