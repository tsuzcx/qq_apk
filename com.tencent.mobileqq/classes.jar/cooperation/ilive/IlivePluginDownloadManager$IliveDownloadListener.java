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
    boolean bool;
    if ((paramDownloadTask.a() == 3) && (paramDownloadTask.jdField_a_of_type_Int == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDone , url = ");
      localStringBuilder.append(paramDownloadTask.c);
      localStringBuilder.append(" isSuccess = ");
      localStringBuilder.append(bool);
      localStringBuilder.append(" errorCode = ");
      localStringBuilder.append(paramDownloadTask.jdField_a_of_type_Int);
      localStringBuilder.append(" httpCode = ");
      localStringBuilder.append(paramDownloadTask.f);
      localStringBuilder.append(" errMsg = ");
      localStringBuilder.append(paramDownloadTask.b);
      QLog.e("IlivePluginDownloadManager", 2, localStringBuilder.toString());
    }
    IlivePluginDownloadManager.a(this.a).remove(paramDownloadTask);
    IlivePluginDownloadManager.a(this.a);
    if (bool)
    {
      IlivePluginDownloadManager.b(this.a);
      return;
    }
    IlivePluginDownloadManager.a(this.a, paramDownloadTask);
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    super.onProgress(paramDownloadTask);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onProgress ,  percent = ");
      localStringBuilder.append(paramDownloadTask.jdField_a_of_type_Float);
      localStringBuilder.append(" url = ");
      localStringBuilder.append(paramDownloadTask.c);
      localStringBuilder.append(" runTime = ");
      localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getClass());
      QLog.e("IlivePluginDownloadManager", 2, localStringBuilder.toString());
    }
    if (IlivePluginDownloadManager.a(this.a) != null) {
      IlivePluginDownloadManager.a(this.a).onProgress(paramDownloadTask.jdField_a_of_type_Float);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.IlivePluginDownloadManager.IliveDownloadListener
 * JD-Core Version:    0.7.0.1
 */