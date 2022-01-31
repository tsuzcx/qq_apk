import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

final class pzg
  implements ocp
{
  pzg(pzi parampzi, HashMap paramHashMap) {}
  
  public void a(ocs paramocs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "换链回包 mHasDestory = " + pzf.a().get() + ", vid = " + paramocs.jdField_b_of_type_JavaLangString);
    }
    if ((pzf.a().get()) || (!this.jdField_a_of_type_Pzi.jdField_a_of_type_JavaLangString.equals(paramocs.jdField_b_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      paramocs = paramocs.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramocs.hasNext())
      {
        ocs localocs = (ocs)paramocs.next();
        if ((localocs.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(localocs.jdField_c_of_type_JavaLangString)) && (localocs.jdField_c_of_type_JavaLangString.equals(String.valueOf(this.jdField_a_of_type_Pzi.jdField_a_of_type_Long))))
        {
          this.jdField_a_of_type_Pzi.jdField_b_of_type_Int = localocs.jdField_b_of_type_Int;
          this.jdField_a_of_type_Pzi.jdField_c_of_type_Int = localocs.jdField_c_of_type_Int;
          pzf.a(this.jdField_a_of_type_Pzi, localocs.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Pzi.jdField_b_of_type_Long);
        }
      }
      for (int i = 1; (i == 0) && (QLog.isColorLevel()); i = 0)
      {
        QLog.d("VideoExtractFrame", 2, "no found videoInfo.tag = " + this.jdField_a_of_type_Pzi.jdField_b_of_type_JavaLangString);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pzg
 * JD-Core Version:    0.7.0.1
 */