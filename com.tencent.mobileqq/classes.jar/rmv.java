import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class rmv
  extends bhyn
{
  rmv(rmu paramrmu, String paramString, RefreshData paramRefreshData, int paramInt) {}
  
  public void onCancel(bhyo parambhyo)
  {
    String str = parambhyo.a().getString("refreshId");
    this.jdField_a_of_type_Rmu.jdField_a_of_type_JavaUtilHashMap.remove("refresh_" + str);
    super.onCancel(parambhyo);
  }
  
  public void onDone(bhyo parambhyo)
  {
    String str1 = parambhyo.a().getString("refreshId");
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes onDone task.errCode =" + parambhyo.jdField_a_of_type_Int);
    }
    if (parambhyo.jdField_a_of_type_Int == 0)
    {
      parambhyo = new File(this.jdField_a_of_type_JavaLangString);
      if (!parambhyo.exists()) {}
    }
    for (;;)
    {
      try
      {
        FileUtils.uncompressZip(parambhyo.getAbsolutePath(), rns.a(), false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.isShown = true;
        bhhr.f(this.jdField_a_of_type_Rmu.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext(), this.jdField_a_of_type_Rmu.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.toJson().toString(), this.jdField_a_of_type_Int);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes uncompressZip failed: id = " + str1 + ", " + QLog.getStackTraceString(localException));
        parambhyo.delete();
        continue;
      }
      finally
      {
        parambhyo.delete();
      }
      this.jdField_a_of_type_Rmu.jdField_a_of_type_JavaUtilHashMap.remove("refresh_" + str1);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes failed: id = " + str2);
      }
    }
  }
  
  public void onProgress(bhyo parambhyo)
  {
    super.onProgress(parambhyo);
  }
  
  public boolean onStart(bhyo parambhyo)
  {
    return super.onStart(parambhyo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rmv
 * JD-Core Version:    0.7.0.1
 */