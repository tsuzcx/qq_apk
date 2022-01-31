import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class pza
  extends bbwt
{
  pza(pyz parampyz, String paramString, RefreshData paramRefreshData, int paramInt) {}
  
  public void onCancel(bbwu parambbwu)
  {
    String str = parambbwu.a().getString("refreshId");
    this.jdField_a_of_type_Pyz.jdField_a_of_type_JavaUtilHashMap.remove("refresh_" + str);
    super.onCancel(parambbwu);
  }
  
  public void onDone(bbwu parambbwu)
  {
    String str1 = parambbwu.a().getString("refreshId");
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes onDone task.errCode =" + parambbwu.jdField_a_of_type_Int);
    }
    if (parambbwu.jdField_a_of_type_Int == 0)
    {
      parambbwu = new File(this.jdField_a_of_type_JavaLangString);
      if (!parambbwu.exists()) {}
    }
    for (;;)
    {
      try
      {
        bbdx.a(parambbwu.getAbsolutePath(), pzx.a(), false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.isShown = true;
        bbkb.f(this.jdField_a_of_type_Pyz.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext(), this.jdField_a_of_type_Pyz.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.toJson().toString(), this.jdField_a_of_type_Int);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes uncompressZip failed: id = " + str1 + ", " + QLog.getStackTraceString(localException));
        parambbwu.delete();
        continue;
      }
      finally
      {
        parambbwu.delete();
      }
      this.jdField_a_of_type_Pyz.jdField_a_of_type_JavaUtilHashMap.remove("refresh_" + str1);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes failed: id = " + str2);
      }
    }
  }
  
  public void onProgress(bbwu parambbwu)
  {
    super.onProgress(parambbwu);
  }
  
  public boolean onStart(bbwu parambbwu)
  {
    return super.onStart(parambbwu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     pza
 * JD-Core Version:    0.7.0.1
 */