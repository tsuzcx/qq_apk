package cooperation.qzone.networkedmodule;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.List;

class QzoneModuleManager$1
  extends ModuleDownloadListenerAdapter
{
  QzoneModuleManager$1(QzoneModuleManager paramQzoneModuleManager) {}
  
  private void updateNextModule()
  {
    if (!NetworkState.isWifiConn())
    {
      QLog.w("QzoneModuleManager", 1, "isWifiConn:false,so stop update.");
      return;
    }
    QzoneModuleManager.access$008(this.this$0);
    Object localObject;
    while (QzoneModuleManager.access$000(this.this$0) < QzoneModuleConst.QZONE_MODULES_PREDOWNLOAD.size())
    {
      localObject = (String)QzoneModuleConst.QZONE_MODULES_PREDOWNLOAD.get(QzoneModuleManager.access$000(this.this$0));
      if (this.this$0.checkIfNeedUpdate((String)localObject))
      {
        this.this$0.updateModule((String)localObject, this);
        break;
      }
      QzoneModuleManager.access$008(this.this$0);
    }
    if (QzoneModuleManager.access$000(this.this$0) == QzoneModuleConst.QZONE_MODULES_PREDOWNLOAD.size())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateAllModules completed--totalModules:");
      ((StringBuilder)localObject).append(QzoneModuleManager.access$000(this.this$0));
      QLog.i("QzoneModuleManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onDownloadCanceled(String paramString)
  {
    super.onDownloadCanceled(paramString);
    updateNextModule();
  }
  
  public void onDownloadFailed(String paramString)
  {
    super.onDownloadFailed(paramString);
    updateNextModule();
  }
  
  public void onDownloadSucceed(String paramString)
  {
    super.onDownloadSucceed(paramString);
    updateNextModule();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleManager.1
 * JD-Core Version:    0.7.0.1
 */