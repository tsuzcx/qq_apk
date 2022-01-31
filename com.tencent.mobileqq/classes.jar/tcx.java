import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class tcx
  extends sly<tau, tav>
{
  tcx(tcw paramtcw, String[] paramArrayOfString) {}
  
  public void a(@NonNull tau paramtau, @Nullable tav paramtav, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramtav == null) || (paramtav.jdField_a_of_type_Int != 0))
    {
      if (paramtav != null) {}
      for (int i = paramtav.jdField_a_of_type_Int;; i = -1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EncryptUrlJob", 2, "encrypt failed, error code = " + i);
        }
        tcw.a(this.jdField_a_of_type_Tcw, false);
        return;
      }
    }
    if (((Boolean)((spz)sqg.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue()) {}
    for (paramtau = tfe.a(this.jdField_a_of_type_ArrayOfJavaLangString[1], tcw.a(this.jdField_a_of_type_Tcw));; paramtau = this.jdField_a_of_type_ArrayOfJavaLangString[1])
    {
      paramtau = this.jdField_a_of_type_ArrayOfJavaLangString[0] + "?token=" + paramtav.jdField_a_of_type_JavaLangString + "&" + paramtau;
      if (QLog.isColorLevel()) {
        QLog.d("EncryptUrlJob", 2, new Object[] { "encrypt done url:", paramtau });
      }
      this.jdField_a_of_type_Tcw.a("EncryptUrlJob_coverUrl", paramtav.c);
      this.jdField_a_of_type_Tcw.a("EncryptUrlJob_encryptedUrl", paramtau);
      tcw.b(this.jdField_a_of_type_Tcw, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tcx
 * JD-Core Version:    0.7.0.1
 */