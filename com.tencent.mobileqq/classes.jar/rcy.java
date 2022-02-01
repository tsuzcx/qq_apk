import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class rcy
  extends bhhe
{
  rcy(rcx paramrcx, String paramString, RefreshData paramRefreshData, int paramInt) {}
  
  public void onCancel(bhhf parambhhf)
  {
    String str = parambhhf.a().getString("refreshId");
    this.jdField_a_of_type_Rcx.jdField_a_of_type_JavaUtilHashMap.remove("refresh_" + str);
    super.onCancel(parambhhf);
  }
  
  public void onDone(bhhf parambhhf)
  {
    String str1 = parambhhf.a().getString("refreshId");
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes onDone task.errCode =" + parambhhf.jdField_a_of_type_Int);
    }
    if (parambhhf.jdField_a_of_type_Int == 0)
    {
      parambhhf = new File(this.jdField_a_of_type_JavaLangString);
      if (!parambhhf.exists()) {}
    }
    for (;;)
    {
      try
      {
        bgmg.a(parambhhf.getAbsolutePath(), rdv.a(), false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.isShown = true;
        bgsg.f(this.jdField_a_of_type_Rcx.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext(), this.jdField_a_of_type_Rcx.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.toJson().toString(), this.jdField_a_of_type_Int);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes uncompressZip failed: id = " + str1 + ", " + QLog.getStackTraceString(localException));
        parambhhf.delete();
        continue;
      }
      finally
      {
        parambhhf.delete();
      }
      this.jdField_a_of_type_Rcx.jdField_a_of_type_JavaUtilHashMap.remove("refresh_" + str1);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes failed: id = " + str2);
      }
    }
  }
  
  public void onProgress(bhhf parambhhf)
  {
    super.onProgress(parambhhf);
  }
  
  public boolean onStart(bhhf parambhhf)
  {
    return super.onStart(parambhhf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rcy
 * JD-Core Version:    0.7.0.1
 */