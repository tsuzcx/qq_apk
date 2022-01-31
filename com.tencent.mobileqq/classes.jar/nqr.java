import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class nqr
  extends bbwf
{
  nqr(nqq paramnqq) {}
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    if ((parambbwg.a == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("last_modified_time", parambbwg.i).commit();
      }
      this.a.b();
    }
    if (QLog.isColorLevel())
    {
      File localFile = new File(nqq.jdField_a_of_type_JavaLangString);
      long l = 0L;
      if (localFile.exists()) {
        l = localFile.lastModified();
      }
      QLog.d("EcShopAssistantManager", 2, "download onDone status=" + parambbwg.a() + ",errCode=" + parambbwg.a + ",httpCode=" + parambbwg.f + ",local lastModify=" + l + ",server lastModify=" + parambbwg.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqr
 * JD-Core Version:    0.7.0.1
 */