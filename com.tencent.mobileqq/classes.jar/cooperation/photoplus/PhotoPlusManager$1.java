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
    PhotoPlusManager.a(this.jdField_a_of_type_CooperationPhotoplusPhotoPlusManager).remove(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    PhotoPlusManager.a(this.jdField_a_of_type_CooperationPhotoplusPhotoPlusManager).remove(this.jdField_a_of_type_JavaLangString);
    if (paramDownloadTask.a() == 3)
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
        this.jdField_a_of_type_CooperationPhotoplusPhotoPlusManager.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      paramDownloadTask = PortalUtils.a(this.jdField_a_of_type_JavaLangString);
      if (this.c.equalsIgnoreCase(paramDownloadTask))
      {
        this.jdField_a_of_type_CooperationPhotoplusPhotoPlusManager.a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append("[onDone] checkMd5 failed: ");
        paramDownloadTask.append(this.jdField_a_of_type_JavaLangString);
        QLog.d("PhotoPlusManager", 2, paramDownloadTask.toString());
      }
      FileUtils.deleteFile(this.jdField_a_of_type_JavaLangString);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onDone] downloadFile failed: ");
      localStringBuilder.append(paramDownloadTask.b);
      localStringBuilder.append(" code=");
      localStringBuilder.append(paramDownloadTask.a);
      QLog.d("PhotoPlusManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.photoplus.PhotoPlusManager.1
 * JD-Core Version:    0.7.0.1
 */