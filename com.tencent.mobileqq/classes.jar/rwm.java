import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

final class rwm
  implements slp
{
  rwm(rwo paramrwo, HashMap paramHashMap) {}
  
  public void a(slr paramslr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "换链回包 mHasDestory = " + rwl.a().get() + ", vid = " + paramslr.jdField_b_of_type_JavaLangString);
    }
    if ((rwl.a().get()) || (!this.jdField_a_of_type_Rwo.jdField_a_of_type_JavaLangString.equals(paramslr.jdField_b_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      paramslr = paramslr.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramslr.hasNext())
      {
        slr localslr = (slr)paramslr.next();
        if ((localslr.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(localslr.jdField_c_of_type_JavaLangString)) && (localslr.jdField_c_of_type_JavaLangString.equals(String.valueOf(this.jdField_a_of_type_Rwo.jdField_a_of_type_Long))))
        {
          this.jdField_a_of_type_Rwo.jdField_b_of_type_Int = localslr.jdField_b_of_type_Int;
          this.jdField_a_of_type_Rwo.jdField_c_of_type_Int = localslr.jdField_c_of_type_Int;
          rwl.a(this.jdField_a_of_type_Rwo, localslr.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Rwo.jdField_b_of_type_Long);
        }
      }
      for (int i = 1; (i == 0) && (QLog.isColorLevel()); i = 0)
      {
        QLog.d("VideoExtractFrame", 2, "no found videoInfo.tag = " + this.jdField_a_of_type_Rwo.jdField_b_of_type_JavaLangString);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwm
 * JD-Core Version:    0.7.0.1
 */