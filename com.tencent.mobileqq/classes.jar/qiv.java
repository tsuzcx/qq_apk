import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class qiv
  extends bead
{
  qiv(qiu paramqiu, String paramString, RefreshData paramRefreshData, int paramInt) {}
  
  public void onCancel(beae parambeae)
  {
    String str = parambeae.a().getString("refreshId");
    this.jdField_a_of_type_Qiu.jdField_a_of_type_JavaUtilHashMap.remove("refresh_" + str);
    super.onCancel(parambeae);
  }
  
  public void onDone(beae parambeae)
  {
    String str1 = parambeae.a().getString("refreshId");
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes onDone task.errCode =" + parambeae.jdField_a_of_type_Int);
    }
    if (parambeae.jdField_a_of_type_Int == 0)
    {
      parambeae = new File(this.jdField_a_of_type_JavaLangString);
      if (!parambeae.exists()) {}
    }
    for (;;)
    {
      try
      {
        bdhb.a(parambeae.getAbsolutePath(), qjs.a(), false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.isShown = true;
        bdne.f(this.jdField_a_of_type_Qiu.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext(), this.jdField_a_of_type_Qiu.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.toJson().toString(), this.jdField_a_of_type_Int);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes uncompressZip failed: id = " + str1 + ", " + QLog.getStackTraceString(localException));
        parambeae.delete();
        continue;
      }
      finally
      {
        parambeae.delete();
      }
      this.jdField_a_of_type_Qiu.jdField_a_of_type_JavaUtilHashMap.remove("refresh_" + str1);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes failed: id = " + str2);
      }
    }
  }
  
  public void onProgress(beae parambeae)
  {
    super.onProgress(parambeae);
  }
  
  public boolean onStart(beae parambeae)
  {
    return super.onStart(parambeae);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qiv
 * JD-Core Version:    0.7.0.1
 */