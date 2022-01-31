import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshRes;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class mak
  extends DownloadListener
{
  public mak(ReadInJoyRefreshManager paramReadInJoyRefreshManager, String paramString, RefreshData paramRefreshData) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    String str = paramDownloadTask.a().getString("refreshId");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyRefreshManager.jdField_a_of_type_JavaUtilHashMap.remove("refresh_" + str);
    super.onCancel(paramDownloadTask);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    String str1 = paramDownloadTask.a().getString("refreshId");
    if (paramDownloadTask.a == 0)
    {
      paramDownloadTask = new File(this.jdField_a_of_type_JavaLangString);
      if (!paramDownloadTask.exists()) {}
    }
    for (;;)
    {
      try
      {
        FileUtils.a(paramDownloadTask.getAbsolutePath(), RefreshRes.a(), false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.isShown = true;
        SharedPreUtils.v(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyRefreshManager.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyRefreshManager.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.toJson().toString());
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyRefreshManager", 2, "downloadSkinRes uncompressZip failed: id = " + str1 + ", " + QLog.getStackTraceString(localException));
        paramDownloadTask.delete();
        continue;
      }
      finally
      {
        paramDownloadTask.delete();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyRefreshManager.jdField_a_of_type_JavaUtilHashMap.remove("refresh_" + str1);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyRefreshManager", 2, "downloadSkinRes failed: id = " + str2);
      }
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    super.onProgress(paramDownloadTask);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mak
 * JD-Core Version:    0.7.0.1
 */