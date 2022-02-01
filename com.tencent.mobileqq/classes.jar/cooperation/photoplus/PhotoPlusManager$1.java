package cooperation.photoplus;

import android.text.TextUtils;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class PhotoPlusManager$1
  extends DownloadListener
{
  PhotoPlusManager$1(PhotoPlusManager paramPhotoPlusManager, String paramString1, String paramString2, String paramString3) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    PhotoPlusManager.a(this.d).remove(this.a);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    PhotoPlusManager.a(this.d).remove(this.a);
    if (paramDownloadTask.e() == 3)
    {
      if (QLog.isColorLevel())
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append("[onDone] download finished ");
        paramDownloadTask.append(this.b);
        QLog.d("PhotoPlusManager", 2, paramDownloadTask.toString());
      }
      if (TextUtils.isEmpty(this.c))
      {
        this.d.b(this.a);
        return;
      }
      paramDownloadTask = PortalUtils.a(this.a);
      if (this.c.equalsIgnoreCase(paramDownloadTask))
      {
        this.d.b(this.a);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append("[onDone] checkMd5 failed: ");
        paramDownloadTask.append(this.a);
        QLog.d("PhotoPlusManager", 2, paramDownloadTask.toString());
      }
      FileUtils.deleteFile(this.a);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onDone] downloadFile failed: ");
      localStringBuilder.append(paramDownloadTask.d);
      localStringBuilder.append(" code=");
      localStringBuilder.append(paramDownloadTask.c);
      QLog.d("PhotoPlusManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.photoplus.PhotoPlusManager.1
 * JD-Core Version:    0.7.0.1
 */