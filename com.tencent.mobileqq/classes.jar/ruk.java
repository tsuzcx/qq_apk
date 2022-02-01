import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

final class ruk
  implements sjr
{
  ruk(rum paramrum, HashMap paramHashMap) {}
  
  public void a(sjt paramsjt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "换链回包 mHasDestory = " + ruj.a().get() + ", vid = " + paramsjt.jdField_b_of_type_JavaLangString);
    }
    if ((ruj.a().get()) || (!this.jdField_a_of_type_Rum.jdField_a_of_type_JavaLangString.equals(paramsjt.jdField_b_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      paramsjt = paramsjt.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramsjt.hasNext())
      {
        sjt localsjt = (sjt)paramsjt.next();
        if ((localsjt.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(localsjt.jdField_c_of_type_JavaLangString)) && (localsjt.jdField_c_of_type_JavaLangString.equals(String.valueOf(this.jdField_a_of_type_Rum.jdField_a_of_type_Long))))
        {
          this.jdField_a_of_type_Rum.jdField_b_of_type_Int = localsjt.jdField_b_of_type_Int;
          this.jdField_a_of_type_Rum.jdField_c_of_type_Int = localsjt.jdField_c_of_type_Int;
          ruj.a(this.jdField_a_of_type_Rum, localsjt.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Rum.jdField_b_of_type_Long);
        }
      }
      for (int i = 1; (i == 0) && (QLog.isColorLevel()); i = 0)
      {
        QLog.d("VideoExtractFrame", 2, "no found videoInfo.tag = " + this.jdField_a_of_type_Rum.jdField_b_of_type_JavaLangString);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ruk
 * JD-Core Version:    0.7.0.1
 */