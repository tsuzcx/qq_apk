import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

final class qlg
  implements ooa
{
  qlg(qli paramqli, HashMap paramHashMap) {}
  
  public void a(ood paramood)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "换链回包 mHasDestory = " + qlf.a().get() + ", vid = " + paramood.jdField_b_of_type_JavaLangString);
    }
    if ((qlf.a().get()) || (!this.jdField_a_of_type_Qli.jdField_a_of_type_JavaLangString.equals(paramood.jdField_b_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      paramood = paramood.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramood.hasNext())
      {
        ood localood = (ood)paramood.next();
        if ((localood.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(localood.jdField_c_of_type_JavaLangString)) && (localood.jdField_c_of_type_JavaLangString.equals(String.valueOf(this.jdField_a_of_type_Qli.jdField_a_of_type_Long))))
        {
          this.jdField_a_of_type_Qli.jdField_b_of_type_Int = localood.jdField_b_of_type_Int;
          this.jdField_a_of_type_Qli.jdField_c_of_type_Int = localood.jdField_c_of_type_Int;
          qlf.a(this.jdField_a_of_type_Qli, localood.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Qli.jdField_b_of_type_Long);
        }
      }
      for (int i = 1; (i == 0) && (QLog.isColorLevel()); i = 0)
      {
        QLog.d("VideoExtractFrame", 2, "no found videoInfo.tag = " + this.jdField_a_of_type_Qli.jdField_b_of_type_JavaLangString);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlg
 * JD-Core Version:    0.7.0.1
 */