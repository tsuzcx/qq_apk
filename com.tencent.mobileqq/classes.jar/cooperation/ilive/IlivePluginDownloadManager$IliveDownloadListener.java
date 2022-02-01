package cooperation.ilive;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

class IlivePluginDownloadManager$IliveDownloadListener
  extends DownloadListener
{
  private IlivePluginDownloadManager$IliveDownloadListener(IlivePluginDownloadManager paramIlivePluginDownloadManager) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if ((paramDownloadTask.a() == 3) && (paramDownloadTask.jdField_a_of_type_Int == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IlivePluginDownloadManager", 2, "onDone , url = " + paramDownloadTask.c + " isSuccess = " + bool + " errorCode = " + paramDownloadTask.jdField_a_of_type_Int + " httpCode = " + paramDownloadTask.f + " errMsg = " + paramDownloadTask.b);
      }
      IlivePluginDownloadManager.a(this.a).remove(paramDownloadTask);
      IlivePluginDownloadManager.a(this.a);
      if (!bool) {
        break;
      }
      IlivePluginDownloadManager.b(this.a);
      return;
    }
    IlivePluginDownloadManager.a(this.a, paramDownloadTask);
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    super.onProgress(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.e("IlivePluginDownloadManager", 2, "onProgress ,  percent = " + paramDownloadTask.jdField_a_of_type_Float + " url = " + paramDownloadTask.c + " runTime = " + BaseApplicationImpl.getApplication().getRuntime().getClass());
    }
    if (IlivePluginDownloadManager.a(this.a) != null) {
      IlivePluginDownloadManager.a(this.a).onProgress(paramDownloadTask.jdField_a_of_type_Float);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.IlivePluginDownloadManager.IliveDownloadListener
 * JD-Core Version:    0.7.0.1
 */