import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class pzd
  extends bbwf
{
  pzd(pzc parampzc, String paramString, RefreshData paramRefreshData, int paramInt) {}
  
  public void onCancel(bbwg parambbwg)
  {
    String str = parambbwg.a().getString("refreshId");
    this.jdField_a_of_type_Pzc.jdField_a_of_type_JavaUtilHashMap.remove("refresh_" + str);
    super.onCancel(parambbwg);
  }
  
  public void onDone(bbwg parambbwg)
  {
    String str1 = parambbwg.a().getString("refreshId");
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes onDone task.errCode =" + parambbwg.jdField_a_of_type_Int);
    }
    if (parambbwg.jdField_a_of_type_Int == 0)
    {
      parambbwg = new File(this.jdField_a_of_type_JavaLangString);
      if (!parambbwg.exists()) {}
    }
    for (;;)
    {
      try
      {
        bbdj.a(parambbwg.getAbsolutePath(), qaa.a(), false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.isShown = true;
        bbjn.f(this.jdField_a_of_type_Pzc.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext(), this.jdField_a_of_type_Pzc.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.toJson().toString(), this.jdField_a_of_type_Int);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes uncompressZip failed: id = " + str1 + ", " + QLog.getStackTraceString(localException));
        parambbwg.delete();
        continue;
      }
      finally
      {
        parambbwg.delete();
      }
      this.jdField_a_of_type_Pzc.jdField_a_of_type_JavaUtilHashMap.remove("refresh_" + str1);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes failed: id = " + str2);
      }
    }
  }
  
  public void onProgress(bbwg parambbwg)
  {
    super.onProgress(parambbwg);
  }
  
  public boolean onStart(bbwg parambbwg)
  {
    return super.onStart(parambbwg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     pzd
 * JD-Core Version:    0.7.0.1
 */