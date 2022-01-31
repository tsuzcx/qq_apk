import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class nfq
  extends batl
{
  nfq(nfp paramnfp) {}
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    if ((parambatm.a == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("last_modified_time", parambatm.i).commit();
      }
      this.a.b();
    }
    if (QLog.isColorLevel())
    {
      File localFile = new File(nfp.jdField_a_of_type_JavaLangString);
      long l = 0L;
      if (localFile.exists()) {
        l = localFile.lastModified();
      }
      QLog.d("EcShopAssistantManager", 2, "download onDone status=" + parambatm.a() + ",errCode=" + parambatm.a + ",httpCode=" + parambatm.f + ",local lastModify=" + l + ",server lastModify=" + parambatm.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfq
 * JD-Core Version:    0.7.0.1
 */