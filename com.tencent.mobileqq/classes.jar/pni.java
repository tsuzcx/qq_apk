import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class pni
  extends batl
{
  pni(pnh parampnh, String paramString, RefreshData paramRefreshData, int paramInt) {}
  
  public void onCancel(batm parambatm)
  {
    String str = parambatm.a().getString("refreshId");
    this.jdField_a_of_type_Pnh.jdField_a_of_type_JavaUtilHashMap.remove("refresh_" + str);
    super.onCancel(parambatm);
  }
  
  public void onDone(batm parambatm)
  {
    String str1 = parambatm.a().getString("refreshId");
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes onDone task.errCode =" + parambatm.jdField_a_of_type_Int);
    }
    if (parambatm.jdField_a_of_type_Int == 0)
    {
      parambatm = new File(this.jdField_a_of_type_JavaLangString);
      if (!parambatm.exists()) {}
    }
    for (;;)
    {
      try
      {
        bace.a(parambatm.getAbsolutePath(), pof.a(), false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.isShown = true;
        baig.f(this.jdField_a_of_type_Pnh.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext(), this.jdField_a_of_type_Pnh.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.toJson().toString(), this.jdField_a_of_type_Int);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes uncompressZip failed: id = " + str1 + ", " + QLog.getStackTraceString(localException));
        parambatm.delete();
        continue;
      }
      finally
      {
        parambatm.delete();
      }
      this.jdField_a_of_type_Pnh.jdField_a_of_type_JavaUtilHashMap.remove("refresh_" + str1);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes failed: id = " + str2);
      }
    }
  }
  
  public void onProgress(batm parambatm)
  {
    super.onProgress(parambatm);
  }
  
  public boolean onStart(batm parambatm)
  {
    return super.onStart(parambatm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     pni
 * JD-Core Version:    0.7.0.1
 */