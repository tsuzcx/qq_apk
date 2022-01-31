import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class nqo
  extends bbwt
{
  nqo(nqn paramnqn) {}
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    if ((parambbwu.a == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("last_modified_time", parambbwu.i).commit();
      }
      this.a.b();
    }
    if (QLog.isColorLevel())
    {
      File localFile = new File(nqn.jdField_a_of_type_JavaLangString);
      long l = 0L;
      if (localFile.exists()) {
        l = localFile.lastModified();
      }
      QLog.d("EcShopAssistantManager", 2, "download onDone status=" + parambbwu.a() + ",errCode=" + parambbwu.a + ",httpCode=" + parambbwu.f + ",local lastModify=" + l + ",server lastModify=" + parambbwu.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqo
 * JD-Core Version:    0.7.0.1
 */