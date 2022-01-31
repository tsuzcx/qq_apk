import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class kzx
  extends DownloadListener
{
  public kzx(EcShopAssistantManager paramEcShopAssistantManager) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if ((paramDownloadTask.a == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("last_modified_time", paramDownloadTask.i).commit();
      }
      this.a.b();
    }
    if (QLog.isColorLevel())
    {
      File localFile = new File(EcShopAssistantManager.jdField_a_of_type_JavaLangString);
      long l = 0L;
      if (localFile.exists()) {
        l = localFile.lastModified();
      }
      QLog.d("EcShopAssistantManager", 2, "download onDone status=" + paramDownloadTask.a() + ",errCode=" + paramDownloadTask.a + ",httpCode=" + paramDownloadTask.e + ",local lastModify=" + l + ",server lastModify=" + paramDownloadTask.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kzx
 * JD-Core Version:    0.7.0.1
 */