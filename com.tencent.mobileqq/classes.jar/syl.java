import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil.HttpDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class syl
  implements Runnable
{
  public syl(Context paramContext, String paramString, QQAppInterface paramQQAppInterface, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener) {}
  
  public void run()
  {
    boolean bool = false;
    try
    {
      Object localObject = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), this.jdField_a_of_type_JavaLangString);
      localObject = new DownloadInfo(this.jdField_a_of_type_JavaLangString, (File)localObject, 0);
      if (HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (DownloadInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqUtilsHttpDownloadUtil$HttpDownloadListener) == 0) {
        bool = true;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.i("LebaIconDownloader", 2, "download ok");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.i("LebaIconDownloader", 2, "download error,error code:" + bool);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaIconDownloader", 2, localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     syl
 * JD-Core Version:    0.7.0.1
 */