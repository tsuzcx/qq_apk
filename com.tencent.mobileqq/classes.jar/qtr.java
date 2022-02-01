import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class qtr
  extends biht
{
  qtr(qtq paramqtq, String paramString, RefreshData paramRefreshData, int paramInt) {}
  
  public void onCancel(bihu parambihu)
  {
    String str = parambihu.a().getString("refreshId");
    this.jdField_a_of_type_Qtq.jdField_a_of_type_JavaUtilHashMap.remove("refresh_" + str);
    super.onCancel(parambihu);
  }
  
  public void onDone(bihu parambihu)
  {
    String str1 = parambihu.a().getString("refreshId");
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes onDone task.errCode =" + parambihu.jdField_a_of_type_Int);
    }
    if (parambihu.jdField_a_of_type_Int == 0)
    {
      parambihu = new File(this.jdField_a_of_type_JavaLangString);
      if (!parambihu.exists()) {}
    }
    for (;;)
    {
      try
      {
        bhmi.a(parambihu.getAbsolutePath(), quo.a(), false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.isShown = true;
        bhsi.f(this.jdField_a_of_type_Qtq.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getBaseContext(), this.jdField_a_of_type_Qtq.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.toJson().toString(), this.jdField_a_of_type_Int);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes uncompressZip failed: id = " + str1 + ", " + QLog.getStackTraceString(localException));
        parambihu.delete();
        continue;
      }
      finally
      {
        parambihu.delete();
      }
      this.jdField_a_of_type_Qtq.jdField_a_of_type_JavaUtilHashMap.remove("refresh_" + str1);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes failed: id = " + str2);
      }
    }
  }
  
  public void onProgress(bihu parambihu)
  {
    super.onProgress(parambihu);
  }
  
  public boolean onStart(bihu parambihu)
  {
    return super.onStart(parambihu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qtr
 * JD-Core Version:    0.7.0.1
 */