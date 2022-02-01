import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class rap
  extends bgod
{
  rap(rao paramrao, String paramString, RefreshData paramRefreshData, int paramInt) {}
  
  public void onCancel(bgoe parambgoe)
  {
    String str = parambgoe.a().getString("refreshId");
    this.jdField_a_of_type_Rao.jdField_a_of_type_JavaUtilHashMap.remove("refresh_" + str);
    super.onCancel(parambgoe);
  }
  
  public void onDone(bgoe parambgoe)
  {
    String str1 = parambgoe.a().getString("refreshId");
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes onDone task.errCode =" + parambgoe.jdField_a_of_type_Int);
    }
    if (parambgoe.jdField_a_of_type_Int == 0)
    {
      parambgoe = new File(this.jdField_a_of_type_JavaLangString);
      if (!parambgoe.exists()) {}
    }
    for (;;)
    {
      try
      {
        FileUtils.uncompressZip(parambgoe.getAbsolutePath(), rbm.a(), false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.isShown = true;
        bfyz.f(this.jdField_a_of_type_Rao.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext(), this.jdField_a_of_type_Rao.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.toJson().toString(), this.jdField_a_of_type_Int);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes uncompressZip failed: id = " + str1 + ", " + QLog.getStackTraceString(localException));
        parambgoe.delete();
        continue;
      }
      finally
      {
        parambgoe.delete();
      }
      this.jdField_a_of_type_Rao.jdField_a_of_type_JavaUtilHashMap.remove("refresh_" + str1);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes failed: id = " + str2);
      }
    }
  }
  
  public void onProgress(bgoe parambgoe)
  {
    super.onProgress(parambgoe);
  }
  
  public boolean onStart(bgoe parambgoe)
  {
    return super.onStart(parambgoe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rap
 * JD-Core Version:    0.7.0.1
 */